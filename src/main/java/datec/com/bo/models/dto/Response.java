
package datec.com.bo.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
  
  protected Boolean status;
  private String message;
  private Object data;
  
}
