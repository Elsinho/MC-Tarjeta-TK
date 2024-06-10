
package datec.com.bo.models.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import datec.com.bo.models.entity.CyberSource;

public interface ICyberSouerceDao extends
                                  CrudRepository<CyberSource, Long> {
  
  public Optional<CyberSource> findByTransactionId(String transaction_id);
  @Query(value = "SELECT * FROM pgt.listar_cybersource_tokenizados(:profile,:codigo,:tipo,:fecha);", nativeQuery = true)
  public List<AuxilarDao> buscarPaymentToken(@Param("profile") Long profile,
                                              @Param("codigo") String codigo,
                                              @Param("tipo") String tipo,
                                              @Param("fecha") String fecha);
  
  public static interface AuxilarDao { String getPayment_token( ); }
}
