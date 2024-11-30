package com.paymint.models.entities;
import com.paymint.models.valueobjects.*;

public class User {
    private final UserId id;
    private final AccountStatus accountStatus;
    private final DateOfBirth dateOfBirth;
    private final NationalId nationalId;
    private final Email email;
    private final Name name;
    private final Password password;
    private final PhoneNumber phoneNumber;
    private final Address address;
    private final Role role;

    public User(UserId id, AccountStatus accountStatus, DateOfBirth dateOfBirth, NationalId nationalId, Email email, Name name, Password password, PhoneNumber phoneNumber, Address address, Role role) {
        this.id = id;
        this.accountStatus = accountStatus;
        this.dateOfBirth = dateOfBirth;
        this.nationalId = nationalId;
        this.email = email;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.role = role;
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

    public Role getRole() {
        return role;
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
}
