
package datec.com.bo.models.dto.cyber;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class LineItem {
  
  private String productCode;
  private BigDecimal taxAmount;
  private BigDecimal quantity;
  private BigDecimal unitPrice;
}
