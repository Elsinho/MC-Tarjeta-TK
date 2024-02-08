
package datec.com.bo.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import datec.com.bo.models.dao.IParametricaDao;
import datec.com.bo.models.entity.Parametrica;
import datec.com.bo.models.services.IParametricaServ;

@Service
public class IParametricaImpl implements
                              IParametricaServ {
  
  @Autowired
  private IParametricaDao parametricaDao;
  
  @Override
  @Transactional(readOnly = true)
  public Parametrica obtener(String dominio,
                             String subdominio,
                             String codigo) {
    return parametricaDao.obtener(dominio, subdominio, codigo);
  }
  
  @Override
  @Transactional(readOnly = true)
  public List<Parametrica> lista(String dominio,
                                 String subdominio,
                                 String codigo) {
    return parametricaDao.lista(dominio, subdominio, codigo);
  }
}
