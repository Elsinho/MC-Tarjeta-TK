
package datec.com.bo.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente", schema = "pgt")
public class Clientes implements
                      Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idcliente;
  private String estado;
  private String codigo_cliente;
  private Date fecha_alta;
  
  @PrePersist
  public void fechaalta( ) { this.fecha_alta = new Date( ); }
  
  private String usuario_alta;
  private Date fecha_modificacion;
  private String usuario_modificacion;
  private Date fecha_baja;
  private String usuario_baja;
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idempresa")
  @JsonIgnoreProperties({"idcliente","hijo","idpadre","atcProfileEmpresa","hibernateLazyInitializer",
                         "handler"})
  private Empresas idempresa;
  @OneToMany(mappedBy = "idcliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JsonIgnoreProperties({"idcliente","idcontarto","idrecibo","hibernateLazyInitializer","handler"})
  private List<Deuda> iddeuda;
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idpersona")
  @JsonIgnoreProperties({"idcliente","hibernateLazyInitializer","handler"})
  private Personas idpersona;
  private static final long serialVersionUID = 7509784102743761592L;
}
