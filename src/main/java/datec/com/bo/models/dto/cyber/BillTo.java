
package datec.com.bo.models.dto.cyber;

import lombok.Data;

@Data
public class BillTo {
  
  private String firstName;
  private String lastName;
  private String address1;
  private String locality;
  private String administrativeArea;
  private String postalCode;
  private String email;
  private String country;
}
