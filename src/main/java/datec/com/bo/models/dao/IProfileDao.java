
package datec.com.bo.models.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import datec.com.bo.models.entity.AtcProfileEmpresa;

public interface IProfileDao extends
                             CrudRepository<AtcProfileEmpresa, Long> {
  
  @Query(value = "SELECT pe.* FROM pgt.cybersource cy INNER JOIN pgt.recibo r on r.idrecibo=cy.idrecibo INNER JOIN "
    + " pgt.deuda d on d.idrecibo=r.idrecibo INNER JOIN pgt.cliente c on c.idcliente=d.idcliente "
    + " INNER JOIN pgt.empresa e on e.idempresa=c.idempresa INNER JOIN pgt.atc_profile_empresa pe on pe.idprofile=e.idagregador"
    + " WHERE cy.idcyber=:idcyber", nativeQuery = true)
  public Optional<AtcProfileEmpresa> obtener(@Param("idcyber") Long idcyber);
}
