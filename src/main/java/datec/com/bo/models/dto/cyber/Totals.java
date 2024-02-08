
package datec.com.bo.models.dto.cyber;

import lombok.Data;

@Data
public class Totals {
  
  private int acceptedRecords;
  private int rejectedRecords;
  private int updatedRecords;
  private int caResponses;
  private int caResponsesOmitted;
}
