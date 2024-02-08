
package datec.com.bo.models.dto;

import datec.com.bo.models.dto.cyber.Links;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resp_Batches {
  
  private Links _links;
  private String batchId;
  private Long batchItemCount;
}
