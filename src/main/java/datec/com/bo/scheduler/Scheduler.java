
package datec.com.bo.scheduler;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import datec.com.bo.models.dto.Resp_Batches;
import datec.com.bo.models.dto.Response;
import datec.com.bo.models.entity.AtcProfileEmpresa;
import datec.com.bo.models.entity.CyberSource;
import datec.com.bo.models.services.ICyberSourceServ;
import datec.com.bo.models.services.IProfileServ;

@Component
public class Scheduler {
  
  private static final Logger log = LoggerFactory.getLogger(Scheduler.class);
  @Autowired
  private ICyberSourceServ cyberS;
  @Autowired
  private IProfileServ empresaS;
  
  public void ejecucionMC( ) throws Exception {
    log.info("Ejecutando...");
    Optional<CyberSource> cyber = cyberS.obtenerTransactionId("7062127987006339604003");
    CyberSource cyberObj = cyber.get( );
    Optional<AtcProfileEmpresa> profile = empresaS.buscarIdcyber(cyberObj.getIdcyber( ));
    AtcProfileEmpresa profileObj = profile.get( );
    Response resp = cyberS.batches(cyberObj, profileObj);
    Resp_Batches resp_batches = ( Resp_Batches ) resp.getData( );
    String url = resp_batches.get_links( )
                             .getStatus( )
                             .get(0)
                             .getHref( );
    cyberS.batchesStatus(url, profileObj);
    cyberS.batchesReport(url, profileObj);
  }
  
  @Scheduled(cron = "0 0 12 * * *")
  public void ejecutarAlMediodia( ) throws Exception { this.ejecucionMC( ); }
  
  @Scheduled(cron = "0 0 19 * * *")
  public void ejecutarALas7PM( ) throws Exception { this.ejecucionMC( ); }
  
  // @Scheduled(initialDelay = 0, fixedRate = 60000)
  // public void cronJobSch( ) throws Exception { this.ejecucionMC( ); }
}