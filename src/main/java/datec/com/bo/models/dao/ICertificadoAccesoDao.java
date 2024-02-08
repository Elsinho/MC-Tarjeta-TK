
package datec.com.bo.models.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import datec.com.bo.models.entity.CertificadoAcceso;

@Repository
public interface ICertificadoAccesoDao extends
                                       JpaRepository<CertificadoAcceso, Long> {
  
  Optional<CertificadoAcceso> findById(String id);
}
