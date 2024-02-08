
package datec.com.bo.models.dto.cyber;

import java.util.List;

import lombok.Data;

@Data
public class Score {
  
  private List<String> factorCodes;
  private int result;
}
