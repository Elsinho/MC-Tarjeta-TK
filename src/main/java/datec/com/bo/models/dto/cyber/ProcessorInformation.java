
package datec.com.bo.models.dto.cyber;

import lombok.Data;

@Data
public class ProcessorInformation {
  
  private Processor processor;
  private String networkTransactionId;
  private String approvalCode;
  private String responseCode;
  private Avs avs;
  private CardVerification cardVerification;
  private AchVerification achVerification;
  // private ElectronicVerificationResults electronicVerificationResults;
  private String systemTraceAuditNumber;
  private String eventStatus;
  private String retrievalReferenceNumber;
}
