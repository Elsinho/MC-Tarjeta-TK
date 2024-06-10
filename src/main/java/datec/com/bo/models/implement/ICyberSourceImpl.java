
package datec.com.bo.models.implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import datec.com.bo.exceptions.ManualUnauthorizedException;
import datec.com.bo.models.dao.ICertificadoAccesoDao;
import datec.com.bo.models.dao.ICyberSouerceDao;
import datec.com.bo.models.dao.ICyberSouerceDao.AuxilarDao;
import datec.com.bo.models.dto.AccountUpdaterBatches;
import datec.com.bo.models.dto.Included;
import datec.com.bo.models.dto.Resp_Batches;
import datec.com.bo.models.dto.Resp_Batches_Status;
import datec.com.bo.models.dto.Response;
import datec.com.bo.models.dto.Token;
import datec.com.bo.models.entity.AtcProfileEmpresa;
import datec.com.bo.models.entity.CertificadoAcceso;
import datec.com.bo.models.entity.CyberSource;
import datec.com.bo.models.entity.Parametrica;
import datec.com.bo.models.services.ICyberSourceServ;
import datec.com.bo.models.services.IParametricaServ;
import datec.com.bo.utils.UtilsCyber;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ICyberSourceImpl implements
                              ICyberSourceServ {
  
  @Autowired
  private ICyberSouerceDao cyberDao;
  @Autowired
  private ICertificadoAccesoDao certificadoDao;
  @Autowired
  private IParametricaServ paraS;
  @Autowired
  private UtilsCyber utilsCyber;
  public static String gmtDateTime = "DATE_PLACEHOLDER";
  public static String resource = "resource_PLACEHOLDER";
  public static String postRequestTarget = "REQUEST_TARGET_PALCEHOLDER";
  private final String USER_AGENT = "Mozilla/5.0";
  
  @Override
  @Transactional(readOnly = true)
  public Optional<CyberSource> obtenerID(Long id) { return cyberDao.findById(id); }
  
  @Override
  @Transactional(readOnly = true)
  public Optional<CyberSource> obtenerTransactionId(String id) { return cyberDao.findByTransactionId(id); }
  
  @Override
  @Transactional(readOnly = true)
  public List<AuxilarDao> listaPaymentToken(Long profile,
                                            String codigo,
                                            String tipo,
                                            String fecha) {
    return cyberDao.buscarPaymentToken(profile, codigo, tipo, fecha);
  }
  
  @Override
  @Transactional(readOnly = true)
  public Response batches(List<AuxilarDao> paymentToken,
                          AtcProfileEmpresa profile) throws Exception {
    Response resp = new Response( );
    Long references = new Date( ).getTime( );
    String requestHost = profile.getUrl( );
    Parametrica para = paraS.obtener("SERVICIO", "CYBERSOURCE", "BATCHES");
    resource = para.getGlosa( );
    log.info("=================================================");
    log.info(profile.getSessionId( ));
    CertificadoAcceso buscar = certificadoDao.findById(profile.getSessionId( ))
                                             .get( );
    log.info("=================================================");
    log.info(buscar.getIdcertificado( ) + "");
    log.info("=================================================");
    AccountUpdaterBatches AUB = new AccountUpdaterBatches( );
    List<Token> listaToken = new ArrayList<>( );
    for(AuxilarDao _PayTok: paymentToken) {
      Token T = new Token( );
      T.setId(_PayTok.getPayment_token( ));
      listaToken.add(T);
    }
    Included I = new Included(listaToken);
    AUB.setType("oneOff");
    AUB.setMerchantReference(references.toString( ));
    AUB.setNotificationEmail(para.getValor( ));
    AUB.setIncluded(I);
    ObjectMapper mapper = new ObjectMapper( );
    mapper.setSerializationInclusion(Include.NON_NULL);
    String payload = mapper.writeValueAsString(AUB);
    log.info(payload);
    String merchantId = profile.getSessionId( );
    String merchantKeyId = buscar.getLlave( );
    String merchantsecretKey = buscar.getLlaveSecreta( );
    System.out.println("\n\nSample 1: POST call");
    System.out.println(resource + "\n" + merchantId + "\n" + merchantKeyId + "\n" + merchantsecretKey + "\n"
      + requestHost + "\n" + resource + "\n" + payload);
    String respuesta = utilsCyber.sendPost("https://" + requestHost + resource, merchantId, merchantKeyId,
      merchantsecretKey, requestHost, resource, payload);
    Resp_Batches cyber_resp = mapper.readValue(respuesta, Resp_Batches.class);
    resp.setData(cyber_resp);
    resp.setMessage("");
    resp.setStatus(true);
    return resp;
  }
  
  @Override
  @Transactional
  public Response batchesStatus(String url,
                                AtcProfileEmpresa profile) throws Exception {
    Response resp = new Response( );
    resource = url;
    String requestHost = profile.getUrl( );
    log.info("=================================================");
    log.info(profile.getSessionId( ));
    CertificadoAcceso buscar = certificadoDao.findById(profile.getSessionId( ))
                                             .get( );
    log.info("=================================================");
    log.info(buscar.getIdcertificado( ) + "");
    log.info("=================================================");
    ObjectMapper mapper = new ObjectMapper( );
    mapper.setSerializationInclusion(Include.NON_NULL);
    String merchantId = profile.getSessionId( );
    String merchantKeyId = buscar.getLlave( );
    String merchantsecretKey = buscar.getLlaveSecreta( );
    System.out.println("\n\nSample 2: GET call");
    System.out.println(resource + "\n" + merchantId + "\n" + merchantKeyId + "\n" + merchantsecretKey + "\n"
      + requestHost + "\n" + resource);
    String respuesta = null;
    try {
      respuesta = utilsCyber.sendGet(resource, merchantId, merchantKeyId, merchantsecretKey, requestHost,
        resource, null);
    }catch(ManualUnauthorizedException e) {
      log.error(e.getMessage( ));
      return new Response(true, e.getMessage( ), null);
    }
    Resp_Batches_Status cyber_resp = mapper.readValue(respuesta, Resp_Batches_Status.class);
    resp.setData(cyber_resp);
    resp.setMessage("");
    resp.setStatus(true);
    return resp;
  }
  
  @Override
  @Transactional
  public Response batchesReport(String url,
                                AtcProfileEmpresa profile) throws Exception {
    Response resp = new Response( );
    resource = url;
    String requestHost = profile.getUrl( );
    log.info("=================================================");
    log.info(profile.getSessionId( ));
    CertificadoAcceso buscar = certificadoDao.findById(profile.getSessionId( ))
                                             .get( );
    log.info("=================================================");
    log.info(buscar.getIdcertificado( ) + "");
    log.info("=================================================");
    ObjectMapper mapper = new ObjectMapper( );
    mapper.setSerializationInclusion(Include.NON_NULL);
    String merchantId = profile.getSessionId( );
    String merchantKeyId = buscar.getLlave( );
    String merchantsecretKey = buscar.getLlaveSecreta( );
    System.out.println("\n\nSample 3: GET call");
    System.out.println(resource + "\n" + merchantId + "\n" + merchantKeyId + "\n" + merchantsecretKey + "\n"
      + requestHost + "\n" + resource);
    String respuesta = null;
    try {
      respuesta = utilsCyber.sendGet(resource, merchantId, merchantKeyId, merchantsecretKey, requestHost,
        resource, null);
    }catch(ManualUnauthorizedException e) {
      log.error(e.getMessage( ));
      return new Response(true, e.getMessage( ), null);
    }
    resp.setData(respuesta);
    resp.setMessage("");
    resp.setStatus(true);
    return resp;
  }
}
