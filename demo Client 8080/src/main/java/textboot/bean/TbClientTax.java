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
 * 2017.10.12
 */
@Entity  
@Table(name="tb_client_tax")  
public class TbClientTax implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Id  
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menuSeq2")  
	@SequenceGenerator(name = "menuSeq2", initialValue = 2, allocationSize = 1, sequenceName = "SEQ_TAX_INFO")
	private Long id;
	
	private String mobile; //用户手机号
    private String tax_resident_type; //用户涉税居民类型
	
	private String bor_country;//出生国家
	private String bor_pro;//出生省份
	private String bor_city;//出生市
	private String bor_area;//出生区
	
	private String tax_job;//涉税信息-职业
	private String contact_pro;//联系地址-省
	private String contact_city;//联系地址-市
	private String contact_area;//联系地址-区
	private String create_time_of_tax; 
	
	
	public TbClientTax(){
		
	}
	
	public String getCreate_time_of_tax() {
		return create_time_of_tax;
	}
	public void setCreate_time_of_tax(String create_time_of_tax) {
		this.create_time_of_tax = create_time_of_tax;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTax_resident_type() {
		return tax_resident_type;
	}
	public void setTax_resident_type(String tax_resident_type) {
		this.tax_resident_type = tax_resident_type;
	}
	public String getBor_country() {
		return bor_country;
	}
	public void setBor_country(String bor_country) {
		this.bor_country = bor_country;
	}
	public String getBor_pro() {
		return bor_pro;
	}
	public void setBor_pro(String bor_pro) {
		this.bor_pro = bor_pro;
	}
	public String getBor_city() {
		return bor_city;
	}
	public void setBor_city(String bor_city) {
		this.bor_city = bor_city;
	}
	public String getBor_area() {
		return bor_area;
	}
	public void setBor_area(String bor_area) {
		this.bor_area = bor_area;
	}
	public String getTax_job() {
		return tax_job;
	}
	public void setTax_job(String tax_job) {
		this.tax_job = tax_job;
	}
	public String getContact_pro() {
		return contact_pro;
	}
	public void setContact_pro(String contact_pro) {
		this.contact_pro = contact_pro;
	}
	public String getContact_city() {
		return contact_city;
	}
	public void setContact_city(String contact_city) {
		this.contact_city = contact_city;
	}
	public String getContact_area() {
		return contact_area;
	}
	public void setContact_area(String contact_area) {
		this.contact_area = contact_area;
	}
	
	
	
	
	
	
	
	
	
	
	

}