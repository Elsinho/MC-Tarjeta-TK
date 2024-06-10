
package datec.com.bo.models.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the
 * atc_profile_empresa database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "atc_profile_empresa", schema = "pgt")
public class AtcProfileEmpresa {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)
  private Long idprofile;
  @Column(name = "access_key", nullable = false, length = 255)
  private String accessKey;
  @Column(name = "dato_adicional1", length = 255)
  private String datoAdicional1;
  @Column(name = "dato_adicional2", length = 255)
  private String datoAdicional2;
  @Column(length = 50)
  private String estado;
  @Column(name = "mode_profile", nullable = false, length = 100)
  private String modeProfile;
  @Column(name = "org_id", nullable = false, length = 255)
  private String orgId;
  @Column(name = "profile_id", nullable = false, length = 255)
  private String profileId;
  @Column(name = "session_id", nullable = false, length = 255)
  private String sessionId;
  @Column(name = "secret_key", nullable = false, length = 500)
  private String secretKey;
  @Column(name = "aggregator_id")
  private String aggregatorId;
  @Column(name = "sales_organization_id")
  private String salesOrganizationId;
  @Column(name = "submerchant_name")
  private String submerchantName;
  @Column(name = "submerchant_city")
  private String submerchantCity;
  @Column(name = "merchant_category_code")
  private String merchantCategoryCode;
  @Column(name = "merchant_descriptor")
  private String merchantDescriptor;
  @Temporal(TemporalType.DATE)
  @Column(name = "Fecha_expiracion")
  private Date FechaExpiracion;
  @Column(name = "tipo")
  private String tipo;
  @Column(name = "url")
  private String url;
  @OneToMany(mappedBy = "atcProfileEmpresa", fetch = FetchType.EAGER)
  @JsonIgnoreProperties({"atcProfileEmpresa","hibernateLazyInitializer","handler"})
  private List<Empresas> empresas;
}