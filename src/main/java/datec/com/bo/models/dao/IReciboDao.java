
package datec.com.bo.models.dao;

import org.springframework.data.repository.CrudRepository;

import datec.com.bo.models.entity.Recibo;

public interface IReciboDao extends
                            CrudRepository<Recibo, Long> {
  
}
