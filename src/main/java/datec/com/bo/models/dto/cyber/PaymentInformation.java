
package datec.com.bo.models.dto.cyber;

import lombok.Data;

@Data
public class PaymentInformation {
  
  private Customer customer;
  // private PaymentInstrument paymentInstrument;
  private InstrumentIdentifier instrumentIdentifier;
  // private ShippingAddress shippingAddress;
  private PaymentType paymentType;
  private Card card;
  // private Invoice invoice;
  // private AccountFeatures accountFeatures;
  // private FluidData fluidData;
}
