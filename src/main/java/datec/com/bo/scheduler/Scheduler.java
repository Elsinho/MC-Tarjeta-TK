
package datec.com.bo.scheduler;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import datec.com.bo.models.dao.ICyberSouerceDao.AuxilarDao;
import datec.com.bo.models.dto.Resp_Batches;
import datec.com.bo.models.dto.Response;
import datec.com.bo.models.entity.AtcProfileEmpresa;
import datec.com.bo.models.entity.Parametrica;
import datec.com.bo.models.services.ICyberSourceServ;
import datec.com.bo.models.services.IParametricaServ;
import datec.com.bo.models.services.IProfileServ;

@Component
public class Scheduler {
  
  private static final Logger log = LoggerFactory.getLogger(Scheduler.class);
  @Autowired
  private ICyberSourceServ cyberS;
  @Autowired
  private IProfileServ profileS;
  @Autowired
  private IParametricaServ paraS;
  
  public void ejecucionMC( ) throws Exception {
    log.info("Ejecutando...");
    List<Parametrica> paraObj = paraS.lista("PROCESADORA", "TARJETA", "TOKENIZACION");
    for(Parametrica p: paraObj) {
      String[ ] _cardType = p.getGlosa( )
                             .split(";");
      for(String type: _cardType) {
        Optional<AtcProfileEmpresa> profile = profileS.buscarIdprofile(Long.valueOf(p.getValor( )));
        AtcProfileEmpresa profileObj = profile.get( );
        List<AuxilarDao> transactionId = cyberS.listaPaymentToken(Long.valueOf(profileObj.getIdprofile( )),
          "100", type, "");
        Response resp = cyberS.batches(transactionId, profileObj);
        Resp_Batches resp_batches = ( Resp_Batches ) resp.getData( );
        String url = resp_batches.get_links( )
                                 .getStatus( )
                                 .get(0)
                                 .getHref( );
        cyberS.batchesStatus(url, profileObj);
        cyberS.batchesReport(url, profileObj);
      }
    }
  }
  
  // @Scheduled(cron = "0 0 12 * * *")
  // public void ejecutarAlMediodia( ) throws Exception { this.ejecucionMC( ); }
  //
  // @Scheduled(cron = "0 0 19 * * *")
  // public void ejecutarALas7PM( ) throws Exception { this.ejecucionMC( ); }
  
  @Scheduled(cron = "1 0 0 1 * ?")
  public void ejecutarPrimerDiaMes01Seg( ) throws Exception { this.ejecucionMC( ); }
  
  @PostConstruct
  public void cronJobSch( ) throws Exception { this.ejecucionMC( ); }
}