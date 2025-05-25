package com.paymint.user.model.aggregates;

import com.paymint.concepts.ddd.Entity;
import com.paymint.user.model.entities.Merchant;
import com.paymint.user.model.entities.PaymentMethod;
import com.paymint.user.model.valueobjects.*;
import com.paymint.user.model.enums.AccountStatus;
import com.paymint.user.model.enums.RoleType;
import com.paymint.user.model.valueobjects.paymentmethod.PaymentMethodId;

import java.util.*;

public class User implements Entity {

  private final UserId id;
  private AccountStatus accountStatus;
  private final DateOfBirth dateOfBirth;
  private final NationalId nationalId;
  private final Email email;
  private Name name;
  private Password password;
  private PhoneNumber phoneNumber;
  private Address address;
  private Set<RoleType> roleType;
  private final List<PaymentMethod> paymentMethods = new ArrayList<>();
  private final Optional<Merchant> merchant;

  public User(
      UserId id,
      DateOfBirth dateOfBirth,
      NationalId nationalId,
      Email email,
      Optional<Merchant> merchant,
      Set<RoleType> roleType,
      Address address,
      PhoneNumber phoneNumber,
      Password password,
      Name name,
      AccountStatus accountStatus) {
    this.id = id;
    this.dateOfBirth = dateOfBirth;
    this.nationalId = nationalId;
    this.email = email;
    this.merchant = merchant;
    this.roleType = roleType;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.password = password;
    this.name = name;
    this.accountStatus = accountStatus;
  }

  public UserId getId() {
    return id;
  }

  public Email getEmail() {
    return email;
  }

  public Name getName() {
    return name;
  }

  public Password getPassword() {
    return password;
  }

  public PhoneNumber getPhoneNumber() {
    return phoneNumber;
  }

  public Address getAddress() {
    return address;
  }

  public Set<RoleType> getRole() {
    return roleType;
  }

  public AccountStatus getAccountStatus() {
    return accountStatus;
  }

  public DateOfBirth getDateOfBirth() {
    return dateOfBirth;
  }

  public NationalId getNationalId() {
    return nationalId;
  }

  public Set<RoleType> getRoleType() {
    return roleType;
  }

  public List<PaymentMethod> getPaymentMethods() {
    return paymentMethods;
  }

  public boolean isActive() {
    return accountStatus == AccountStatus.ACTIVE;
  }

  public void activate() {
    this.accountStatus = AccountStatus.ACTIVE;
    // domainEvents.add(new UserActivatedEvent(this.id));
  }

  public void block() {
    this.accountStatus = AccountStatus.BLOCKED;
    // domainEvents.add(new UserBlockedEvent(this.id));
  }

  public void updateContactInformation(PhoneNumber newPhone, Address newAddress) {
    this.phoneNumber = Objects.requireNonNull(newPhone);
    this.address = Objects.requireNonNull(newAddress);
  }

  public void rename(Name newName) {
    this.name = Objects.requireNonNull(newName);
  }

  public void changePassword(Password newPassword) {
    this.password = Objects.requireNonNull(newPassword);
  }

  public boolean isCustomer() {
    return roleType.contains(RoleType.CUSTOMER);
  }

  public void addPaymentMethod(PaymentMethod method) {
    Objects.requireNonNull(method);

    if (method.getExpiryDate().isExpired()) {
      throw new IllegalArgumentException("Expired payment method cannot be added.");
    }

    if (paymentMethods.stream()
        .anyMatch(existing -> existing.getMethodId().equals(method.getMethodId()))) {
      throw new IllegalArgumentException("The payment method already exists.");
    }

    if (paymentMethods.stream()
        .anyMatch(
            existing -> existing.getMaskedCardNumber().equals(method.getMaskedCardNumber()))) {
      throw new IllegalArgumentException("The masked card number already exists.");
    }

    paymentMethods.add(method);
  }

  public void removePaymentMethod(PaymentMethodId methodId) {
    boolean removed = paymentMethods.removeIf(pm -> pm.getMethodId().equals(methodId));
    if (!removed) {
      throw new IllegalArgumentException("Payment method not found: " + methodId);
    }
  }

  public List<PaymentMethod> getActivePaymentMethods() {
    return paymentMethods.stream().filter(PaymentMethod::isActive).toList();
  }

  public List<PaymentMethod> getAllPaymentMethods() {
    return List.copyOf(paymentMethods);
  }

  public boolean isMerchant() {
    return roleType.contains(RoleType.MERCHANT) && merchant.isPresent();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return id.equals(user.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
