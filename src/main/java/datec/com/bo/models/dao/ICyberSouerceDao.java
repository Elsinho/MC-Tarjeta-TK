
package datec.com.bo.models.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import datec.com.bo.models.entity.CyberSource;

public interface ICyberSouerceDao extends
                                  CrudRepository<CyberSource, Long> {
  
  public Optional<CyberSource> findByTransactionId(String transaction_id);
  
}
