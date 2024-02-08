
package datec.com.bo.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import datec.com.bo.models.entity.Parametrica;

@Repository
public interface IParametricaDao extends
                                 JpaRepository<Parametrica, Long> {
  
  @Query(value = "SELECT * FROM pgt.parametrica WHERE dominio=:dominio AND subdominio=:subdominio AND codigo=:codigo", nativeQuery = true)
  public Parametrica obtener(@Param("dominio") String dominio,
                             @Param("subdominio") String subdominio,
                             @Param("codigo") String codigo);
  
  @Query(value = "SELECT * FROM pgt.parametrica WHERE UPPER(dominio)=UPPER(:dominio) AND "
    + " UPPER(subdominio)=UPPER(:subdominio) AND UPPER(codigo)=UPPER(:codigo)", nativeQuery = true)
  public List<Parametrica> lista(@Param("dominio") String dominio,
                                 @Param("subdominio") String subdominio,
                                 @Param("codigo") String codigo);
}
