
package datec.com.bo.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "pago", schema = "pgt")
public class Pagos implements
                   Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idpago;
  @Column(length = 2000)
  private String descripcion;
  private String reference_number;
  private Long idmetodo;
  private Date fecha_alta;
  
  @PrePersist
  public void fechaalta( ) { this.fecha_alta = new Date( ); }
  
  private String usuario_alta;
  private Date fecha_baja;
  private String usuario_baja;
  @OneToMany(mappedBy = "idpago")
  @JsonIgnoreProperties({"idpago","idrecibo","hibernateLazyInitializer","handler"})
  private List<Deuda> iddeuda;
  /**
   * 
   */
  private static final long serialVersionUID = -318107384519062206L;
}
