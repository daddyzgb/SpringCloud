package textboot.dao;
 
import org.springframework.data.jpa.repository.JpaRepository;   

import textboot.bean.TbClientTax;
   
  
public interface TbtaxDAO extends JpaRepository<TbClientTax,Integer>{  
	//通过手机号查询涉税基本信息
	public TbClientTax findClientTaxByMobile(String mobile);
	
	//保存用户
	/*public Object addTbClientTax(@RequestBody TbClientTax tbclienttax){
		return null;
	}*/
    
      
}  