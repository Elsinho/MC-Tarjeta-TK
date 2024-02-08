
package datec.com.bo.models.dto.cyber;

import lombok.Data;

@Data
public class Application {
  
  private String name;
  private String reasonCode;
  private String rCode;
  private String rFlag;
  private String reconciliationId;
  private String rMessage;
  private int returnCode;
  private String status;
}
