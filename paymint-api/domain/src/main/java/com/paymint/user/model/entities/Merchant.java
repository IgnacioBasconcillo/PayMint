package com.paymint.user.model.entities;

import com.paymint.user.model.valueobjects.merchant.MerchantId;

import java.util.Objects;

public class Merchant {
  private final MerchantId merchantId;
  private final String businessName;
  private final String taxId;
  private final String callbackUrl;

  public Merchant(MerchantId merchantId, String businessName, String taxId, String callbackUrl) {
    this.merchantId = Objects.requireNonNull(merchantId);
    this.businessName = Objects.requireNonNull(businessName);
    this.taxId = Objects.requireNonNull(taxId);
    this.callbackUrl = Objects.requireNonNull(callbackUrl);
  }

  public MerchantId getMerchantId() {
    return merchantId;
  }

  public String getBusinessName() {
    return businessName;
  }

  public String getTaxId() {
    return taxId;
  }

  public String getCallbackUrl() {
    return callbackUrl;
  }
}
