
package datec.com.bo.models.dto;

import datec.com.bo.models.dto.cyber.Billing;
import datec.com.bo.models.dto.cyber.Links;
import datec.com.bo.models.dto.cyber.Totals;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resp_Batches_Status {
  
  private Links _links;
  private String batchCaEndpoints;
  private String batchCreatedDate;
  private String batchId;
  private String batchSource;
  private Billing billing;
  private String description;
  private String merchantReference;
  private String status;
  private Totals totals;
}
