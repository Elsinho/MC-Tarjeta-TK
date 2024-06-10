
package datec.com.bo.models.services;

import java.util.List;
import java.util.Optional;

import datec.com.bo.models.dao.ICyberSouerceDao.AuxilarDao;
import datec.com.bo.models.dto.Response;
import datec.com.bo.models.entity.AtcProfileEmpresa;
import datec.com.bo.models.entity.CyberSource;

public interface ICyberSourceServ {
  
  Response batchesStatus(String url,
                         AtcProfileEmpresa profileObj) throws Exception;
  Response batches(List<AuxilarDao> paymentToken,
                   AtcProfileEmpresa profile) throws Exception;
  Optional<CyberSource> obtenerID(Long id);
  Optional<CyberSource> obtenerTransactionId(String id);
  Response batchesReport(String url,
                         AtcProfileEmpresa profileObj) throws Exception;
  List<AuxilarDao> listaPaymentToken(Long profile,
                                     String codigo,
                                     String tipo,
                                     String fecha);
  
}
