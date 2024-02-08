
package datec.com.bo.models.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import datec.com.bo.models.dao.IProfileDao;
import datec.com.bo.models.entity.AtcProfileEmpresa;
import datec.com.bo.models.services.IProfileServ;

@Service
public class IProfileImpl implements
                          IProfileServ {
  
  @Autowired
  private IProfileDao profileDao;
  
  @Override
  @Transactional(readOnly = true)
  public Optional<AtcProfileEmpresa> buscarIdcyber(Long idcyber) { return profileDao.obtener(idcyber); }
  
}