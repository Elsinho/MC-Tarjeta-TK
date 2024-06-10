
package datec.com.bo.config.Logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Aspect for logging execution of service and repository Spring components.
 * @author Ramesh Fadatare
 *
 */
@Aspect
@Component
public class ApiLogs {
  
  private final Logger log = LoggerFactory.getLogger(this.getClass( ));
  private StringBuilder logging = new StringBuilder( );
  
  /**
   * Pointcut that matches all repositories, services and Web REST endpoints.
   */
  @Pointcut("within(@org.springframework.stereotype.Repository *)"
    + " || within(@org.springframework.stereotype.Service *)"
    + " || within(@org.springframework.web.bind.annotation.RestController *)")
  public void springBeanPointcut( ) {
    // Method is empty as this is just a Pointcut, the implementations are in the advices.
  }
  
  /**
   * Pointcut that matches all Spring beans in the application's main packages.
   */
  @Pointcut("within(datec.com.bo.models.implement..*)" + " || within(datec.com.bo.controllers..*)")
  public void applicationPackagePointcut( ) {
    // Method is empty as this is just a Pointcut, the implementations are in the advices.
  }
  
  /**
   * Advice that logs methods throwing exceptions.
   *
   * @param joinPoint join point for advice
   * @param e exception
   */
  @AfterThrowing(pointcut = "applicationPackagePointcut() && springBeanPointcut()", throwing = "e")
  public void logAfterThrowing(JoinPoint joinPoint,
                               Exception e) {
    log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature( )
                                                               .getDeclaringType( )
                                                               .getSimpleName( ), joinPoint.getSignature( )
                                                                                           .getName( ), e
                                                                                                         .getCause( ) != null ?
                                                                                                           e.getCause( ) :
                                                                                                           "NULL");
  }
  
  private String addLog(String newLog) {
    int length = newLog.length( );
    if (length > 1000) { return newLog.substring(0, 900) + "\n+900"; }
    return newLog;
  }
  
  /**
   * Advice that logs when a method is entered and exited.
   *
   * @param joinPoint join point for advice
   * @return result
   * @throws Throwable throws IllegalArgumentException
   */
  @Around("applicationPackagePointcut() && springBeanPointcut()")
  public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
    ObjectMapper mapper = new ObjectMapper( );
    String arg = null;
    
    try {
      arg = getArgumentString(joinPoint);
      arg = this.addLog(arg);
    }catch(Exception e) {
      e.printStackTrace( );
    }
    
    log.info("{}.{}() >>> ARG: {}", joinPoint.getSignature( )
                                             .getDeclaringType( )
                                             .getSimpleName( ), joinPoint.getSignature( )
                                                                         .getName( ), arg);
    
    try {
      Object result = joinPoint.proceed( );
      String classes = joinPoint.getSignature( )
                                .getDeclaringType( )
                                .getSimpleName( );
      String method = joinPoint.getSignature( )
                               .getName( );
      String returnValue = getReturnValueString(result);
      returnValue = this.addLog(returnValue);
      log.info("<<< Return << {}.{}() << {}", classes, method, returnValue);
      return result;
    }catch(IllegalArgumentException e) {
      log.error("Illegal argument: {} in {}.{}()", joinPoint.getArgs( ), joinPoint.getSignature( )
                                                                                  .getDeclaringTypeName( ),
        joinPoint.getSignature( )
                 .getName( ));
      throw e;
    }
  }
  
  private String getArgumentString(ProceedingJoinPoint joinPoint) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper( );
    StringBuilder arguments = new StringBuilder("[");
    Object[ ] args = joinPoint.getArgs( );
    for(Object arg: args) {
      if (arg instanceof MultipartFile) {
        // If the argument is MultipartFile, handle it differently
        arguments.append("MultipartFile(...), ");
      }else {
        arguments.append(mapper.writeValueAsString(arg))
                 .append(", ");
      }
    }
    if (arguments.length( ) > 1) {
      arguments.setLength(arguments.length( ) - 2); // Remove the last ", "
    }
    arguments.append("]");
    return arguments.toString( );
  }
  
  private String getReturnValueString(Object result) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper( );
    if (result instanceof MultipartFile) {
      // If the return value is MultipartFile, handle it differently
      return "MultipartFile(...)";
    }else {
      return mapper.writeValueAsString(result);
    }
  }
}
