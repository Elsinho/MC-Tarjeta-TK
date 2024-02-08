
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
@Table(name = "empresa", schema = "pgt")
public class Empresas implements
                      Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idempresa;
  private String razon_social;
  private String nombre;
  private String rubro;
  private String direccion;
  private String nit;
  private String emision_nit;
  private String correos;
  private String telefono_fijo;
  private String telefono_movil;
  private String pagina_web;
  private Date fecha_creacion;;
  private Date fecha_alta;
  private String logo;
  
  @PrePersist
  public void fechaalta( ) { this.fecha_alta = new Date( ); }
  
  private String usuario_alta;
  private Date fecha_baja;
  private String usuario_baja;
  private String estado;
  @OneToMany(mappedBy = "idempresa")
  @JsonIgnoreProperties({"idempresa","iddeuda","idpersona","hibernateLazyInitializer","handler"})
  private List<Clientes> idcliente;
  @OneToMany(mappedBy = "idpadre", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
  @JsonIgnoreProperties({"idpadre","hibernateLazyInitializer","handler"})
  private List<Empresas> hijo;
  @ManyToOne
  @JoinColumn(name = "idpadre")
  @JsonIgnoreProperties({"hijo","atcProfileEmpresas","atcMerchantDataRubroEmpresas","idrecurso",
                         "hibernateLazyInitializer","handler"})
  private Empresas idpadre;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idagregador")
  @JsonIgnoreProperties({"empresas","hibernateLazyInitializer","handler"})
  private AtcProfileEmpresa atcProfileEmpresa;
}