
package datec.com.bo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import datec.com.bo.models.services.ICyberSourceServ;
import datec.com.bo.models.services.IProfileServ;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/v1/cybersource")
public class TarjetaMasterCardCtrl {
  
  @Autowired
  private ICyberSourceServ cyberS;
  @Autowired
  private IProfileServ empresaS;
  
  // @GetMapping("/batches")
  // public ResponseEntity<?> batches(@RequestParam("transaction_id") String id,
  // @RequestParam("correo") String correo) throws Exception {
  // Map<String, Object> response = new HashMap<>( );
  // ObjectMapper mapper = new ObjectMapper( );
  // mapper.setSerializationInclusion(Include.NON_NULL);
  // Optional<CyberSource> cyber = cyberS.obtenerTransactionId(id);
  // if (cyber.isEmpty( )) {
  // response.put("mensaje", "No se encontro el valor TransactionId :: " + id);
  // return ResponseEntity.status(HttpStatus.NOT_FOUND)
  // .body(response);
  // }
  // CyberSource cyberObj = cyber.get( );
  // Optional<AtcProfileEmpresa> profile = empresaS.buscarIdcyber(cyberObj.getIdcyber( ));
  // AtcProfileEmpresa profileObj = profile.get( );
  // Response resp = cyberS.batches(cyberObj, profileObj);
  // Resp_Batches resp_batches = ( Resp_Batches ) resp.getData( );
  // cyberS.batchesStatus(resp_batches.get_links( )
  // .getStatus( )
  // .get(0)
  // .getHref( ), profileObj);
  // return ResponseEntity.status(HttpStatus.OK)
  // .body(resp);
  // }
}
