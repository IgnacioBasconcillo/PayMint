package com.paymint.user.model.aggregates;

import com.paymint.concepts.ddd.Entity;
import com.paymint.paymentmethod.model.aggregates.PaymentMethod;
import com.paymint.user.model.valueobjects.*;

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
  private RoleType roleType;

  private final Set<PaymentMethod> paymentMethods = new HashSet<>();

  public User(
      UserId id,
      AccountStatus accountStatus,
      DateOfBirth dateOfBirth,
      NationalId nationalId,
      Email email,
      Name name,
      Password password,
      PhoneNumber phoneNumber,
      Address address,
      RoleType roleType) {
    this.id = Objects.requireNonNull(id);
    this.accountStatus = Objects.requireNonNull(accountStatus);
    this.dateOfBirth = Objects.requireNonNull(dateOfBirth);
    this.nationalId = Objects.requireNonNull(nationalId);
    this.email = Objects.requireNonNull(email);
    this.name = Objects.requireNonNull(name);
    this.password = Objects.requireNonNull(password);
    this.phoneNumber = Objects.requireNonNull(phoneNumber);
    this.address = Objects.requireNonNull(address);
    this.roleType = Objects.requireNonNull(roleType);
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

  public RoleType getRole() {
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

  public RoleType getRoleType() {
    return roleType;
  }

  public Set<PaymentMethod> getPaymentMethods() {
    return Collections.unmodifiableSet(paymentMethods);
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

  public void addPaymentMethod(PaymentMethod method) {
    Objects.requireNonNull(method);
    if (paymentMethods.contains(method)) {
      throw new IllegalStateException("Payment method already exists.");
    }
    this.paymentMethods.add(method);
    // domainEvents.add(new PaymentMethodAddedEvent(this.id, method.getId()));
  }

  public void removePaymentMethod(PaymentMethod method) {
    this.paymentMethods.remove(method);
    // domainEvents.add(new PaymentMethodRemovedEvent(...));
  }

  public boolean isMerchant() {
    return roleType == RoleType.MERCHANT;
  }

  public boolean isCustomer() {
    return roleType == RoleType.CUSTOMER;
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
