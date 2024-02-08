
package datec.com.bo.models.dto.cyber;

import java.util.List;

import lombok.Data;

@Data
public class RiskInformation {
  
  private Profile profile;
  private List<Rule> rules;
  private Score score;
}
