
package datec.com.bo.models.dto.cyber;

import lombok.Data;

@Data
public class Card {
  
  private String suffix;
  private String prefix;
  private String expirationMonth;
  private String expirationYear;
  private String type;
}
