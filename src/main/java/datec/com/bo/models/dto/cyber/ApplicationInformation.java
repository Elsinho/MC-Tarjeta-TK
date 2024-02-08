
package datec.com.bo.models.dto.cyber;

import java.util.List;

import lombok.Data;

@Data
public class ApplicationInformation {
  
  private String status;
  private int reasonCode;
  private List<Application> applications;
}
