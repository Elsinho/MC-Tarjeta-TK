
package datec.com.bo.models.dto.cyber;

import lombok.Data;

@Data
public class AmountDetails {
  
  private String totalAmount;
  private String currency;
  private String taxAmount;
  private String authorizedAmount;
}
