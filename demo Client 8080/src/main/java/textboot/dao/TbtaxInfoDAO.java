package textboot.dao;

import java.util.List;  


import org.springframework.data.jpa.repository.JpaRepository;   
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import textboot.bean.TbClientTaxInfo;
   
  
public interface TbtaxInfoDAO extends JpaRepository<TbClientTaxInfo,Integer>{  
    
	//通过手机号查询个人涉税识别号登详细信息
    //public List<Object> findTaxInfoByMobile(String mobile);
	
	//" select tax_country,cause,tax_num,tax_create_time from  tb_client_tax_info where tax_create_time in (select max(tax_create_time) from tb_client_tax_info where mobile=?)";
	
	
	   @Query(value = "select tax_country,cause,tax_num,tax_create_time from  tb_client_tax_info where tax_create_time in (select max(tax_create_time) from tb_client_tax_info where mobile=?1)", nativeQuery = true)  
	   @Modifying  
	   public List<Object> findTaxInfoByMobile(String name);  
      
}  