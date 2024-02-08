
package datec.com.bo.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import datec.com.bo.exceptions.ManualUnauthorizedException;

@Service
public class UtilsCyber {
  
  private static final Logger log = LoggerFactory.getLogger(UtilsCyber.class);
  
  public String sendGet(String url,
                        String merchantId,
                        String merchantKeyId,
                        String merchantsecretKey,
                        String requestHost,
                        String resource,
                        String payload) throws Exception {
    String getRequestTarget = "get /accountupdater/v1/batches";
    URL obj = new URL(url);
    HttpURLConnection con = ( HttpURLConnection ) obj.openConnection( );
    con.setRequestProperty("v-c-merchant-id", merchantId);
    con.setRequestProperty("v-c-correlation-id", "123");
    String gmtDateTime = getdate( );
    con.setRequestProperty("date", gmtDateTime);
    con.setRequestProperty("Host", requestHost);
    StringBuilder signatureHeaderValue = getSignatureHeader("GET", merchantKeyId, requestHost, gmtDateTime,
      resource, getRequestTarget, merchantId, merchantsecretKey, payload);
    con.setRequestProperty("Signature", signatureHeaderValue.toString( ));
    con.setRequestMethod("GET");
    int responseCode = con.getResponseCode( );
    if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
      String msj =
                 "La solicitud no está autorizada. Verifique las credenciales. Tener permiso en el consumo de servicio";
      log.error(msj);
      throw new ManualUnauthorizedException(msj);
    }
    String responseHeader = con.getHeaderField("v-c-correlation-id");
    log.info("\n -- RequestURL -- ");
    log.info("\tURL : " + url);
    log.info("\n -- HTTP Headers -- ");
    log.info("\tContent-Type : " + "application/json");
    log.info("\tv-c-merchant-id : " + merchantId);
    log.info("\tDate : " + gmtDateTime);
    log.info("\tHost : " + requestHost);
    log.info("\tSignature : " + signatureHeaderValue);
    log.info("\n -- Response Message -- ");
    log.info("\tResponse Code :" + responseCode);
    log.info("\tv-c-correlation-id :" + responseHeader);
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream( )));
    String inputLine;
    StringBuffer response = new StringBuffer( );
    while((inputLine = in.readLine( )) != null) {
      response.append(inputLine);
    }
    in.close( );
    log.info("\tResponse Payload :\n" + response.toString( ));
    return response.toString( );
  }
  
  public String sendPost(String url,
                         String merchantId,
                         String merchantKeyId,
                         String merchantsecretKey,
                         String requestHost,
                         String resource,
                         String payload) throws Exception {
    URL obj = new URL(url);
    StringBuffer response = new StringBuffer( );
    String postRequestTarget = "post /accountupdater/v1/batches";
    HttpURLConnection con = ( HttpURLConnection ) obj.openConnection( );
    con.setRequestProperty("v-c-merchant-id", merchantId);
    con.setRequestProperty("v-c-correlation-id", "123");
    con.setRequestProperty("profile-id", "19B96029-CF15-4606-AD1E-8433FE7C880F");
    String gmtDateTime = getdate( );
    con.setRequestProperty("date", gmtDateTime);
    con.setRequestProperty("Host", requestHost);
    con.setRequestProperty("Digest", getDigest(payload));
    StringBuilder signatureHeaderValue = getSignatureHeader("POST", merchantKeyId, requestHost, gmtDateTime,
      resource, postRequestTarget, merchantId, merchantsecretKey, payload);
    con.setRequestProperty("Signature", signatureHeaderValue.toString( ));
    con.setRequestMethod("POST");
    con.setRequestProperty("User-Agent", "Mozilla/5.0");
    con.setRequestProperty("Content-Type", "application/json");
    con.setDoOutput(true);
    con.setDoInput(true);
    DataOutputStream wr = new DataOutputStream(con.getOutputStream( ));
    wr.write(payload.getBytes("UTF-8"));
    wr.flush( );
    wr.close( );
    int responseCode = con.getResponseCode( );
    String responseHeader = con.getHeaderField("v-c-correlation-id");
    log.info("\n -- RequestURL -- ");
    log.info("\tURL : " + url);
    log.info("\n -- HTTP Headers -- ");
    log.info("\tContent-Type : " + "application/json");
    log.info("\tv-c-merchant-id : " + merchantId);
    log.info("\tDate : " + gmtDateTime);
    log.info("\tHost : " + requestHost);
    log.info("\tDigest : " + getDigest(payload));
    log.info("\tSignature : " + signatureHeaderValue);
    log.info("\n -- Response Message -- ");
    log.info("\tResponse Code :" + responseCode);
    log.info("\tv-c-correlation-id :" + responseHeader);
    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream( )));
      String inputLine;
      
      while((inputLine = in.readLine( )) != null) {
        response.append(inputLine);
      }
      in.close( );
      log.info("\tResponse Payload :\n" + response.toString( ));
    }catch(Exception exception) {
      BufferedReader in = new BufferedReader(new InputStreamReader(con.getErrorStream( )));
      String inputLine;
      while((inputLine = in.readLine( )) != null) {
        response.append(inputLine);
      }
      in.close( );
      log.error(exception.toString( ));
    }
    return response.toString( );
  }
  
  private String getdate( ) {
    return(DateTimeFormatter.RFC_1123_DATE_TIME.format(ZonedDateTime.now(ZoneId.of("GMT"))));
  }
  
  private StringBuilder getSignatureHeader(String httpMethod,
                                           String merchantKeyId,
                                           String requestHost,
                                           String gmtDateTime,
                                           String resource,
                                           String postRequestTarget,
                                           String merchantId,
                                           String merchantsecretKey,
                                           String payload) throws Exception {
    StringBuilder signatureHeaderValue = new StringBuilder( );
    signatureHeaderValue.append("keyid=\"" + merchantKeyId + "\"");
    signatureHeaderValue.append(", algorithm=\"HmacSHA256\"");
    String getHeaders = "host date (request-target)" + " " + "v-c-merchant-id";
    String postHeaders = "host date (request-target) digest v-c-merchant-id";
    if (httpMethod.equalsIgnoreCase("GET")) signatureHeaderValue.append(", headers=\"" + getHeaders + "\"");
    else if (httpMethod.equalsIgnoreCase("POST")) signatureHeaderValue.append(", headers=\"" + postHeaders
      + "\"");
    String signatureValue = getSignatureParam(httpMethod, requestHost, gmtDateTime, resource,
      postRequestTarget, merchantId, merchantsecretKey, payload);
    signatureHeaderValue.append(", signature=\"" + signatureValue + "\"");
    return signatureHeaderValue;
  }
  
  private String getSignatureParam(String httpMethod,
                                   String requestHost,
                                   String gmtDateTime,
                                   String resource,
                                   String postRequestTarget,
                                   String merchantId,
                                   String merchantsecretKey,
                                   String payload) throws Exception {
    StringBuilder signatureString = new StringBuilder( );
    signatureString.append('\n');
    signatureString.append("host");
    signatureString.append(": ");
    signatureString.append(requestHost);
    signatureString.append('\n');
    signatureString.append("date");
    signatureString.append(": ");
    signatureString.append(gmtDateTime);
    signatureString.append('\n');
    signatureString.append("(request-target)");
    signatureString.append(": ");
    String getRequestTarget = "get " + resource;
    if (httpMethod.equalsIgnoreCase("GET")) signatureString.append(getRequestTarget);
    else if (httpMethod.equalsIgnoreCase("POST")) signatureString.append(postRequestTarget);
    signatureString.append('\n');
    if (httpMethod.equalsIgnoreCase("POST")) {
      signatureString.append("digest");
      signatureString.append(": ");
      signatureString.append(getDigest(payload));
      signatureString.append('\n');
    }
    signatureString.append("v-c-merchant-id");
    signatureString.append(": ");
    signatureString.append(merchantId);
    signatureString.delete(0, 1);
    String signatureStr = signatureString.toString( );
    SecretKeySpec secretKey = new SecretKeySpec(
      Base64.getDecoder( )
            .decode(merchantsecretKey),
      "HmacSHA256");
    Mac aKeyId = Mac.getInstance("HmacSHA256");
    aKeyId.init(secretKey);
    aKeyId.update(signatureStr.getBytes( ));
    byte[ ] aHeaders = aKeyId.doFinal( );
    String base64EncodedSignature = Base64.getEncoder( )
                                          .encodeToString(aHeaders);
    return base64EncodedSignature;
  }
  
  private String getDigest(String payload) throws NoSuchAlgorithmException,
                                           IOException {
    MessageDigest digestString = MessageDigest.getInstance("SHA-256");
    byte[ ] digestBytes = digestString.digest(payload.getBytes("UTF-8"));
    String bluePrint = Base64.getEncoder( )
                             .encodeToString(digestBytes);
    bluePrint = "SHA-256=" + bluePrint;
    return bluePrint;
  }
}
