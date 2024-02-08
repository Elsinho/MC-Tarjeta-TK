
package datec.com.bo.models.dto.cyber;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Links {
  
  private Self self;
  private ArrayList<Status> status;
  private ArrayList<Report> report;
}
