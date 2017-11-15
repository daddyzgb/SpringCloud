package textboot.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



/**
 * MyEclipse Persistence Tools
 * @author zgb
 * 2017.9.1
 */
@Entity  
@Table(name="tb_client_tax_info")  
public class TbClientTaxInfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id  
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menuSeq")  
	@SequenceGenerator(name = "menuSeq", initialValue = 2, allocationSize = 1, sequenceName = "SEQ_TAX_INFO")  
	private Long id;
	
	private String mobile; //用户手机号
	private String tax_country; //纳税国
	private String tax_num; //纳税识别号
	private String cause; //不能填写纳税国或者识别号的原因
	private String tax_create_time; 
	
	
	
	public TbClientTaxInfo(){
		
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTax_create_time() {
		return tax_create_time;
	}
	public void setTax_create_time(String tax_create_time) {
		this.tax_create_time = tax_create_time;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTax_country() {
		return tax_country;
	}
	public void setTax_country(String tax_country) {
		this.tax_country = tax_country;
	}
	public String getTax_num() {
		return tax_num;
	}
	public void setTax_num(String tax_num) {
		this.tax_num = tax_num;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	
	
	
	
	
	

}