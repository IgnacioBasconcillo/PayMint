package com.paymint.merchant.model.aggregates;

import com.paymint.merchant.model.valueobjects.ApiKey;
import com.paymint.merchant.model.valueobjects.BusinessName;
import com.paymint.merchant.model.valueobjects.MerchantId;

public class Merchant {
  private final MerchantId merchantId;
  private final BusinessName businessName;
  private final ApiKey apiKey;

  public Merchant(MerchantId merchantId, BusinessName businessName, ApiKey apiKey) {
    this.merchantId = merchantId;
    this.businessName = businessName;
    this.apiKey = apiKey;
  }

  public MerchantId getMerchantId() {
    return merchantId;
  }

  public BusinessName getBusinessName() {
    return businessName;
  }

  public ApiKey getApiKey() {
    return apiKey;
  }
}
