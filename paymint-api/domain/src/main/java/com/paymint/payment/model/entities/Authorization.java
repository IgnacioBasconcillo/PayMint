package com.paymint.payment.model.entities;

import com.paymint.payment.model.enums.authorization.AuthorizationStatus;
import com.paymint.payment.model.enums.authorization.ChallengeType;

import java.time.LocalDateTime;

import java.util.Objects;
import java.util.UUID;

public class Authorization {

  private final UUID authorizationId;
  private final ChallengeType challengeType;
  private final String token;
  private final LocalDateTime authorizedAt;
  private final LocalDateTime expiredAt;

  private AuthorizationStatus status;

  public Authorization(
      UUID authorizationId,
      ChallengeType challengeType,
      String token,
      LocalDateTime authorizedAt,
      LocalDateTime expiredAt) {
    this.authorizationId = Objects.requireNonNull(authorizationId);
    this.challengeType = Objects.requireNonNull(challengeType);
    this.token = Objects.requireNonNull(token);
    this.authorizedAt = authorizedAt;
    this.expiredAt = expiredAt;
    this.status = AuthorizationStatus.PENDING;
  }

  public void authorize(String providedToken) {
    if (this.expiredAt != null && LocalDateTime.now().isAfter(this.expiredAt)) {
      this.status = AuthorizationStatus.EXPIRED;
      throw new IllegalStateException("Authorization expired");
    }

    if (!this.token.equals(providedToken)) {
      this.status = AuthorizationStatus.FAILED;
      throw new IllegalArgumentException("Invalid authorization token");
    }

    this.status = AuthorizationStatus.AUTHORIZED;
  }

  public boolean isAuthorized() {
    return this.status == AuthorizationStatus.AUTHORIZED;
  }

  // Getters
  public UUID authorizationId() {
    return authorizationId;
  }

  public AuthorizationStatus status() {
    return status;
  }

  public ChallengeType challengeType() {
    return challengeType;
  }

  public String token() {
    return token;
  }

  public LocalDateTime authorizedAt() {
    return authorizedAt;
  }

  public LocalDateTime expiredAt() {
    return expiredAt;
  }
}
