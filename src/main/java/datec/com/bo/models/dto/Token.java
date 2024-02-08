
package datec.com.bo.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token {
  
  private String id;
  private String expirationMonth;
  private String expirationYear;
}
