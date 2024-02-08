
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
@Table(name = "persona", schema = "pgt")
public class Personas implements
                      Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idpersona;
  private String nombres;
  private String apellido_paterno;
  private String apellido_materno;
  private String apellido_casado;
  private String tipo_documento;
  private String valor_documento;
  private String estado_civil;
  private Date fecha_nacimiento;
  private String lugar_nacimiento;
  private String nacionalidad;
  private String emision_documento;
  private Date fecha_aniversario;
  private String profesion;
  private String domicilio;
  private Integer edad;
  private String foto;
  private Date fecha_alta;
  
  @PrePersist
  public void fechaalta( ) { this.fecha_alta = new Date( ); }
  
  private String usuario_alta;
  private Date fecha_baja;
  private String usuario_baja;
  private Date fecha_modificacion;
  private String usuario_modificacion;
  private String estado;
  @OneToMany(mappedBy = "idpersona", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JsonIgnoreProperties({"idpersona","hibernateLazyInitializer","handler"})
  private List<Clientes> idcliente;
  private static final long serialVersionUID = 1L;
  
}
