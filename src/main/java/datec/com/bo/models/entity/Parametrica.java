
package datec.com.bo.models.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the parametrica
 * database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "parametrica", schema = "pgt")
public class Parametrica {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)
  private Long idparametrica;
  @Column(length = 60)
  private String codigo;
  @Column(length = 1000)
  private String descripcion;
  @Column(length = 100)
  private String dominio;
  @Column(length = 5)
  private String estado;
  @Column(name = "fecha_alta")
  private Timestamp fechaAlta;
  @Column(name = "fecha_baja")
  private Timestamp fechaBaja;
  @Column(length = 1000)
  private String glosa;
  @Column(length = 100)
  private String subdominio;
  @Column(length = 10)
  private String tipo;
  @Column(name = "usuario_alta", length = 60)
  private String usuarioAlta;
  @Column(name = "usuario_baja", length = 60)
  private String usuarioBaja;
  @Column(length = 100)
  private String valor;
}