
package datec.com.bo.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recibo", schema = "pgt")
public class Recibo implements
                    Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idrecibo;
  private String cupon;
  private Long idprogramacion;
  private String tipo_recibo;
  private String reference_number;
  private Long nro_recibo;
  private BigDecimal monto;
  private Date fecha_vencimiento;
  private String estado;
  private BigDecimal monto_interes;
  private BigDecimal monto_cargo;
  private String concepto_recibo;
  private String descripcion_general;
  private String periodo;
  @Column(name = "fechaAlta")
  @Temporal(TemporalType.TIMESTAMP)
  private Date fecha_alta;
  
  @PrePersist
  public void fechaalta( ) {
    this.fecha_alta = new Date( );
    setNroTransaccion(java.util.UUID.randomUUID( ));
  }
  
  private String usuario_alta;
  @Column(name = "fechaModificacion")
  @Temporal(TemporalType.TIMESTAMP)
  private Date fecha_modificacion;
  private String usuario_modificacion;
  @Column(name = "fechaBaja")
  @Temporal(TemporalType.TIMESTAMP)
  private Date fecha_baja;
  private String usuario_baja;
  private Integer moneda;
  private String codigo_pago;
  private String glosa1;
  private String glosa2;
  private String glosa3;
  private String glosa4;
  private String glosa5;
  private String glosa6;
  private String glosa7;
  private String glosa8;
  private String nombre_apellido;
  private String suscripcion;
  @GeneratedValue(generator = "myIdStrategy")
  @GenericGenerator(name = "myIdStrategy", strategy = "uuid")
  @Column(name = "nro_transaccion")
  private UUID nroTransaccion;
  @OneToOne(mappedBy = "idrecibo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JsonIgnoreProperties({"idrecibo","iddetalle","hibernateLazyInitializer","handler"})
  private Deuda iddeuda;
  private String lote;
  @OneToMany(mappedBy = "recibo")
  @JsonIgnoreProperties({"recibo","idparametrica","hibernateLazyInitializer","handler"})
  private List<CyberSource> cybersources;
  /**
  		 * 
  		 */
  private static final long serialVersionUID = 1L;
}
