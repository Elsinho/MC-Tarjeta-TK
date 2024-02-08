
package datec.com.bo.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "deuda", schema = "pgt")
public class Deuda implements
                   Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long iddeuda;
  private Long idfactura;
  private Date fecha_alta;
  
  @PrePersist
  public void fechaalta( ) { this.fecha_alta = new Date( ); }
  
  private String usuario_alta;
  private Date fecha_modificacion;
  private String usuario_modificacion;
  private Date fecha_baja;
  private String usuario_baja;
  private String estado;
  @Column(length = 2000)
  private String observacion;
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idrecibo")
  @JsonIgnoreProperties({"iddeuda","idcontrato","iddetalle","hibernateLazyInitializer","handler"})
  private Recibo idrecibo;
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idcliente")
  @JsonIgnoreProperties({"iddeuda","idcontrato","hibernateLazyInitializer","handler"})
  private Clientes idcliente;
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idpago")
  @JsonIgnoreProperties({"iddeuda","hibernateLazyInitializer","handler"})
  private Pagos idpago;
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
}
