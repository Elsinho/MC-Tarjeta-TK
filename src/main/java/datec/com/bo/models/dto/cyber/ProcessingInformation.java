
package datec.com.bo.models.dto.cyber;

import lombok.Data;

@Data
public class ProcessingInformation {
  
  private String paymentSolution;
  private String commerceIndicator;
  private String commerceIndicatorLabel;
  private AuthorizationOptions authorizationOptions;
  // private BankTransferOptions bankTransferOptions;
  // private JapanPaymentOptions japanPaymentOptions;
  private FundingOptions fundingOptions;
  private String ecommerceIndicator;
}
