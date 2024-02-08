
package datec.com.bo.models.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import datec.com.bo.models.dao.IReciboDao;
import datec.com.bo.models.entity.Recibo;
import datec.com.bo.models.services.IReciboServ;

@Service
public class IReciboImpl implements
                         IReciboServ {
  
  @Autowired
  private IReciboDao reciboDao;
  
  @Override
  @Transactional(readOnly = true)
  public Optional<Recibo> buscarId(Long idrecibo) { return reciboDao.findById(idrecibo); }
  
}