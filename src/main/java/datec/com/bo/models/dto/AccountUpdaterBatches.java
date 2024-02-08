
package datec.com.bo.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountUpdaterBatches {
  
  private String type;
  private Included included;
  private String merchantReference;
  private String notificationEmail;
}
