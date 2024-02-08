
package datec.com.bo.models.dto.cyber;

import lombok.Data;

@Data
public class ConsumerAuthenticationInformation {
  
  private String eciRaw;
  private String cavv;
  private String directoryServerTransactionId;
  private String paSpecificationVersion;
  private StrongAuthentication strongAuthentication;
}
