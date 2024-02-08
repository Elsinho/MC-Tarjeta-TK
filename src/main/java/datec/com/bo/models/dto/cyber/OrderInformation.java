
package datec.com.bo.models.dto.cyber;

import java.util.List;

import lombok.Data;

@Data
public class OrderInformation {
  
  private BillTo billTo;
  // private ShipTo shipTo;
  private AmountDetails amountDetails;
  // private ShippingDetails shippingDetails;
  // private InvoiceDetails invoiceDetails;
  private List<LineItem> lineItems;
}
