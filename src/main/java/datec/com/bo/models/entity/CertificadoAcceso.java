
package datec.com.bo.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the kiosko database table.
 * 
 */
@Entity
@Getter
@Setter
@Table(name = "certificado_acceso", schema = "pgt")
public class CertificadoAcceso {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idcertificado;
  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String llave;
  @Lob
  @Type(type = "org.hibernate.type.TextType")
  private String llaveSecreta;
  private String id;
  private Long idempresa;
  private String ruta;
  private String estado;
  private String data1;
  private String data2;
  private Long data3;
  @Column(name = "fecha_alta")
  @Temporal(TemporalType.TIMESTAMP)
  private Date fechaAlta;
  
  @PrePersist
  public void fechaalta( ) {
    this.fechaAlta = new Date( );
    this.estado = "A";
  }
  
  @Column(name = "fecha_baja")
  @Temporal(TemporalType.TIMESTAMP)
  private Date fechaBaja;
  @Column(name = "fecha_modificacion")
  @Temporal(TemporalType.TIMESTAMP)
  private Date fechaModificacion;
  @Column(name = "fecha_vencimiento")
  @Temporal(TemporalType.DATE)
  private Date fechaVencimiento;
  @Column(name = "usuario_alta")
  private String usuarioAlta;
  @Column(name = "usuario_baja")
  private String usuarioBaja;
  @Column(name = "usuario_modificacion")
  private String usuarioModificacion;
}