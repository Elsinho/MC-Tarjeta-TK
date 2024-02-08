
package datec.com.bo.models.services;

import java.util.List;

import org.springframework.stereotype.Service;

import datec.com.bo.models.entity.Parametrica;

@Service
public interface IParametricaServ {
  
  public Parametrica obtener(String dominio,
                             String subdominio,
                             String codigo);
  public List<Parametrica> lista(String dominio,
                                 String subdominio,
                                 String codigo);
}
