
package datec.com.bo.models.services;

import java.util.Optional;

import datec.com.bo.models.dto.Response;
import datec.com.bo.models.entity.AtcProfileEmpresa;
import datec.com.bo.models.entity.CyberSource;

public interface ICyberSourceServ {
  
  Response batchesStatus(String url,
                         AtcProfileEmpresa profileObj) throws Exception;
  Response batches(CyberSource cyber,
                   AtcProfileEmpresa profileObj) throws Exception;
  Optional<CyberSource> obtenerID(Long id);
  Optional<CyberSource> obtenerTransactionId(String id);
  Response batchesReport(String url,
                         AtcProfileEmpresa profileObj) throws Exception;
}
