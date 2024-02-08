
package datec.com.bo.models.dto.cyber;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class TokenizacionCyber {
  
  private String id;
  private String rootId;
  private String reconciliationId;
  private Date submitTimeUTC;
  private String merchantId;
  // private ApplicationInformation applicationInformation;
  // private BuyerInformation buyerInformation;
  // private ClientReferenceInformation clientReferenceInformation;
  // private ConsumerAuthenticationInformation consumerAuthenticationInformation;
  private DeviceInformation deviceInformation;
  // private InstallmentInformation installmentInformation;
  // private FraudMarkingInformation fraudMarkingInformation;
  private List<MerchantDefinedInformation> merchantDefinedInformation;
  private MerchantInformation merchantInformation;
  private OrderInformation orderInformation;
  private PaymentInformation paymentInformation;
  // private PaymentInsightsInformation paymentInsightsInformation;
  private ProcessingInformation processingInformation;
  private ProcessorInformation processorInformation;
  // private PointOfSaleInformation pointOfSaleInformation;
  // private RiskInformation riskInformation;
  // private RecipientInformation recipientInformation;
  // private SenderInformation senderInformation;
  // private TokenInformation tokenInformation;
  // private Links _links;
}
