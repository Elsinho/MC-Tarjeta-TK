
package datec.com.bo.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cybersource", schema = "pgt")
public class CyberSource {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idcyber;
  @Column(length = 3000)
  private String utf8;
  @Column(length = 3000)
  private String auth_cv_result;
  @Column(length = 3000)
  private String req_locale;
  @Column(length = 3000)
  private String payer_authentication_cavv;
  @Column(length = 3000)
  private String score_device_fingerprint_true_ipaddress_attributes;
  @Column(length = 3000)
  private String req_cad_expiry_date;
  @Column(length = 3000)
  private String req_bill_to_addres_city;
  @Column(length = 3000)
  private String decision_case_priority;
  @Column(length = 3000)
  private String score_identity_info;
  @Column(length = 3000)
  private String auth_trans_ref_no;
  @Column(length = 3000)
  private String req_bill_to_surname;
  @Column(length = 3000)
  private String score_rcode;
  @Column(length = 3000)
  private String auth_amount;
  @Column(length = 3000)
  private String req_payer_authentication_merchant_name;
  @Column(length = 3000)
  private String auth_time;
  @Column(length = 3000)
  private String decision_early_return_code;
  @Column(name = "transaction_id", length = 3000)
  private String transactionId;
  @Column(length = 3000)
  private String score_device_fingerprint_javascript_enabled;
  @Column(length = 3000)
  private String payer_authentication_pares_status;
  @Column(length = 3000)
  private String payer_authentication_cav;
  @Column(length = 3000)
  private String auth_code;
  @Column(length = 3000)
  private String payer_authentication_specification_version;
  @Column(length = 3000)
  private String req_bill_to_address_country;
  @Column(length = 3000)
  private String auth_cv_result_raw;
  @Column(length = 3000)
  private String score_device_fingerprint_cookies_enabled;
  @Column(length = 3000)
  private String score_suspicious_info;
  @Column(length = 3000)
  private String decision_rcode;
  @Column(length = 3000)
  private String score_rmsg;
  @Column(length = 3000)
  private String score_device_fingerprint_browser_language;
  @Column(length = 3000)
  private String req_bill_to_address_line1;
  @Column(length = 3000)
  private String req_card_number;
  @Column(length = 3000)
  private String score_device_fingerprint_true_ipaddress;
  @Column(length = 3000)
  private String signature;
  @Column(length = 3000)
  private String auth_cavv_result;
  @Column(length = 3000)
  private String request_token;
  @Column(length = 3000)
  private String req_amount;
  @Column(length = 3000)
  private String payer_authentication_reason_code;
  @Column(length = 3000)
  private String decision;
  @Column(length = 3000)
  private String decision_return_code;
  @Column(length = 3000)
  private String signed_field_names;
  @Column(length = 3000)
  private String decision_reason_code;
  @Column(length = 3000)
  private String payer_authentication_eci;
  @Column(length = 3000)
  private String score_time_local;
  @Column(length = 3000)
  private String req_transaction_type;
  @Column(length = 3000)
  private String payer_authentication_xid;
  @Column(length = 3000)
  private String score_internet_info;
  @Column(length = 3000)
  private String req_reference_number;
  @Column(length = 3000)
  private String score_device_fingerprint_flash_enabled;
  @Column(length = 3000)
  private String score_device_fingerprint_images_enabled;
  @Column(length = 3000)
  private String req_payer_authentication_indicator;
  @Column(length = 3000)
  private String score_score_result;
  @Column(length = 3000)
  private String req_card_type_selection_indicator;
  @Column(length = 3000)
  private String payer_authentication_enroll_veres_enrolled;
  @Column(length = 3000)
  private String payer_authentication_proof_xml;
  @Column(length = 3000)
  private String req_card_expiry_date;
  @Column(length = 3000)
  private String score_rflag;
  @Column(length = 3000)
  private String score_card_issuer;
  @Column(length = 3000)
  private String auth_response;
  @Column(length = 3000)
  private String bill_trans_ref_no;
  @Column(length = 3000)
  private String req_payment_method;
  @Column(length = 3000)
  private String score_device_fingerprint_true_ipaddress_city;
  @Column(length = 3000)
  private String payer_authentication_enroll_e_commerce_indicator;
  @Column(length = 3000)
  private String req_card_type;
  @Column(length = 3000)
  private String payer_authentication_transaction_id;
  @Column(length = 3000)
  private String score_device_fingerprint_screen_resolution;
  @Column(length = 3000)
  private String auth_avs_code;
  @Column(length = 3000)
  private String score_address_info;
  @Column(length = 3000)
  private String score_factors;
  @Column(length = 3000)
  private String score_model_used;
  @Column(length = 3000)
  private String decision_rmsg;
  @Column(length = 3000)
  private String req_profile_id;
  @Column(length = 3000)
  private String score_device_fingerprint_hash;
  @Column(length = 3000)
  private String decision_rflag;
  @Column(length = 3000)
  private String signed_date_time;
  @Column(length = 3000)
  private String score_card_scheme;
  @Column(length = 3000)
  private String score_device_fingerprint_true_ipaddress_country;
  @Column(length = 3000)
  private String score_bin_country;
  @Column(length = 3000)
  private String req_bill_to_address_city;
  @Column(length = 3000)
  private String req_bill_to_address_postal_code;
  @Column(length = 3000)
  private String score_reason_code;
  @Column(length = 3000)
  private String reason_code;
  @Column(length = 3000)
  private String req_bill_to_forename;
  @Column(length = 3000)
  private String req_payer_authentication_acs_window_size;
  @Column(length = 3000)
  private String req_device_fingerprint_id;
  @Column(length = 3000)
  private String auth_cavv_result_raw;
  @Column(length = 3000)
  private String score_card_account_type;
  @Column(length = 3000)
  private String req_bill_to_email;
  @Column(length = 3000)
  private String auth_avs_code_raw;
  @Column(length = 3000)
  private String req_currency;
  @Column(length = 3000)
  private String score_device_fingerprint_smart_id_confidence_level;
  @Column(length = 3000)
  private String message;
  @Column(length = 3000)
  private String req_transaction_uuid;
  @Column(length = 3000)
  private String score_device_fingerprint_smart_id;
  @Column(length = 3000)
  private String score_return_code;
  @Column(length = 3000)
  private String score_host_severity;
  @Column(length = 3000)
  private String req_access_key;
  @Column(length = 3000)
  private String decision_early_reason_code;
  @Column(length = 3000)
  private String payer_authentication_validate_result;
  @Column(length = 3000)
  private String req_bill_to_address_state;
  @Column(length = 3000)
  private String decision_early_rcode;
  @Column(length = 3000)
  private String req_merchant_defined_data1;
  @Column(length = 3000)
  private String req_merchant_defined_data2;
  @Column(length = 3000)
  private String req_merchant_defined_data3;
  @Column(length = 3000)
  private String req_merchant_defined_data4;
  @Column(length = 3000)
  private String req_merchant_defined_data5;
  @Column(length = 3000)
  private String req_merchant_defined_data6;
  @Column(length = 3000)
  private String req_merchant_defined_data7;
  @Column(length = 3000)
  private String req_merchant_defined_data8;
  @Column(length = 3000)
  private String req_merchant_defined_data9;
  @Column(length = 3000)
  private String req_merchant_defined_data10;
  @Column(length = 3000)
  private String req_merchant_defined_data11;
  @Column(length = 3000)
  private String req_merchant_defined_data12;
  @Column(length = 3000)
  private String req_merchant_defined_data13;
  @Column(length = 3000)
  private String req_merchant_defined_data14;
  @Column(length = 3000)
  private String req_merchant_defined_data15;
  @Column(length = 3000)
  private String req_merchant_defined_data16;
  @Column(length = 3000)
  private String req_merchant_defined_data17;
  @Column(length = 3000)
  private String req_merchant_defined_data18;
  @Column(length = 3000)
  private String req_merchant_defined_data19;
  @Column(length = 3000)
  private String req_merchant_defined_data20;
  @Column(length = 3000)
  private String req_merchant_defined_data21;
  @Column(length = 3000)
  private String req_merchant_defined_data22;
  @Column(length = 3000)
  private String req_merchant_defined_data23;
  @Column(length = 3000)
  private String req_merchant_defined_data24;
  @Column(length = 3000)
  private String req_merchant_defined_data25;
  @Column(length = 3000)
  private String req_merchant_defined_data26;
  @Column(length = 3000)
  private String req_merchant_defined_data27;
  @Column(length = 3000)
  private String req_merchant_defined_data28;
  @Column(length = 3000)
  private String req_merchant_defined_data29;
  @Column(length = 3000)
  private String req_merchant_defined_data30;
  @Column(length = 3000)
  private String req_merchant_defined_data31;
  @Column(length = 3000)
  private String req_merchant_defined_data32;
  @Column(length = 3000)
  private String req_merchant_defined_data33;
  @Column(length = 3000)
  private String req_merchant_defined_data34;
  @Column(length = 3000)
  private String req_merchant_defined_data35;
  @Column(length = 3000)
  private String req_merchant_defined_data36;
  @Column(length = 3000)
  private String req_merchant_defined_data37;
  @Column(length = 3000)
  private String req_merchant_defined_data38;
  @Column(length = 3000)
  private String req_merchant_defined_data39;
  @Column(length = 3000)
  private String req_merchant_defined_data40;
  @Column(length = 3000)
  private String req_merchant_defined_data41;
  @Column(length = 3000)
  private String req_merchant_defined_data42;
  @Column(length = 3000)
  private String req_merchant_defined_data43;
  @Column(length = 3000)
  private String req_merchant_defined_data44;
  @Column(length = 3000)
  private String req_merchant_defined_data45;
  @Column(length = 3000)
  private String req_merchant_defined_data46;
  @Column(length = 3000)
  private String req_merchant_defined_data47;
  @Column(length = 3000)
  private String req_merchant_defined_data48;
  @Column(length = 3000)
  private String req_merchant_defined_data49;
  @Column(length = 3000)
  private String req_merchant_defined_data50;
  @Column(length = 3000)
  private String score_velocity_info;
  @Column(length = 3000)
  private String req_merchant_defined_data51;
  @Column(length = 3000)
  private String req_merchant_defined_data52;
  @Column(length = 3000)
  private String req_merchant_defined_data53;
  @Column(length = 3000)
  private String req_merchant_defined_data54;
  @Column(length = 3000)
  private String req_merchant_defined_data55;
  @Column(length = 3000)
  private String req_merchant_defined_data56;
  @Column(length = 3000)
  private String req_merchant_defined_data57;
  @Column(length = 3000)
  private String decision_velocity_info;
  @Column(length = 3000)
  private String payer_authentication_validate_e_commerce_indicator;
  @Column(length = 3000)
  private String req_merchant_defined_data58;
  @Column(length = 3000)
  private String req_merchant_defined_data59;
  @Column(length = 3000)
  private String req_merchant_defined_data60;
  @Column(length = 3000)
  private String req_merchant_defined_data61;
  @Column(length = 3000)
  private String req_merchant_defined_data62;
  @Column(length = 3000)
  private String req_merchant_defined_data63;
  @Column(length = 3000)
  private String req_merchant_defined_data64;
  @Column(length = 3000)
  private String req_merchant_defined_data65;
  @Column(length = 3000)
  private String req_merchant_defined_data66;
  @Column(length = 3000)
  private String req_merchant_defined_data67;
  @Column(length = 3000)
  private String req_merchant_defined_data68;
  @Column(length = 3000)
  private String req_merchant_defined_data69;
  @Column(length = 3000)
  private String req_merchant_defined_data70;
  @Column(length = 3000)
  private String req_merchant_defined_data71;
  @Column(length = 3000)
  private String req_merchant_defined_data72;
  @Column(length = 3000)
  private String req_merchant_defined_data73;
  @Column(length = 3000)
  private String req_merchant_defined_data74;
  @Column(length = 3000)
  private String req_merchant_defined_data75;
  @Column(length = 3000)
  private String req_merchant_defined_data76;
  @Column(length = 3000)
  private String req_merchant_defined_data77;
  @Column(length = 3000)
  private String req_merchant_defined_data78;
  @Column(length = 3000)
  private String req_merchant_defined_data79;
  @Column(length = 3000)
  private String req_merchant_defined_data80;
  @Column(length = 3000)
  private String req_merchant_defined_data81;
  @Column(length = 3000)
  private String req_merchant_defined_data82;
  @Column(length = 3000)
  private String req_merchant_defined_data83;
  @Column(length = 3000)
  private String req_merchant_defined_data84;
  @Column(length = 3000)
  private String req_merchant_defined_data85;
  @Column(length = 3000)
  private String req_merchant_defined_data86;
  @Column(length = 3000)
  private String req_merchant_defined_data87;
  @Column(length = 3000)
  private String req_merchant_defined_data88;
  @Column(length = 3000)
  private String req_merchant_defined_data89;
  @Column(length = 3000)
  private String req_merchant_defined_data90;
  @Column(length = 3000)
  private String req_merchant_defined_data91;
  @Column(length = 3000)
  private String req_merchant_defined_data92;
  @Column(length = 3000)
  private String req_merchant_defined_data93;
  @Column(length = 3000)
  private String req_merchant_defined_data94;
  @Column(length = 3000)
  private String req_merchant_defined_data95;
  @Column(length = 3000)
  private String req_merchant_defined_data96;
  @Column(length = 3000)
  private String req_merchant_defined_data97;
  @Column(length = 3000)
  private String req_merchant_defined_data98;
  @Column(length = 3000)
  private String req_merchant_defined_data99;
  @Column(length = 3000)
  private String req_merchant_defined_data100;
  @JsonIgnoreProperties({"cybersources","hibernateLazyInitializer","handler"})
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idrecibo")
  private Recibo recibo;
  @JsonIgnoreProperties({"idcyber","idrecibo","hibernateLazyInitializer","handler"})
  @ManyToOne
  @JoinColumn(name = "idparametrica")
  private Parametrica idparametrica;
  private Date fecha_alta;
  @Column(length = 3000)
  private String card_type_name;
  @Column(length = 3000)
  private String invalid_fields;
  @Column(length = 3000)
  private String payer_authentication_uci;
  @Column(length = 3000)
  private String payment_account_reference;
  @Column(length = 3000)
  private String payer_authentication_acs_transaction_id;
  @Column(length = 3000)
  private String score_ip_city;
  @Column(length = 3000)
  private String score_ip_state;
  @Column(length = 3000)
  private String score_ip_country;
  @Column(length = 3000)
  private String score_ip_routing_method;
  @Column(length = 3000)
  private String merchant_advice_code;
  @Column(length = 3000)
  private String payment_token_instrument_identifier_new;
  @Column(length = 3000)
  private String payment_token;
  @Column(length = 3000)
  private String payment_token_instrument_identifier_id;
  @Column(length = 3000)
  private String payment_token_instrument_identifier_status;
  private String req_aggregator_id;
  private String req_merchant_descriptor;
  private String auth_reconciliation_reference_number;
  private String req_submerchant_id;
  private String req_sales_organization_id;
  
  @PrePersist
  public void fechaalta( ) { this.fecha_alta = new Date( ); }
  
}
