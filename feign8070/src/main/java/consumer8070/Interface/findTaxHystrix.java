package consumer8070.Interface;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;


@Component
public class findTaxHystrix implements  FindTaxService{
	
	@Override
	public String findtaxinfo( @RequestParam(value = "mobile") String mobile){
        return "error " +mobile;
    }
	
	@Override
	 public String sayHiFromClientOne(@RequestParam(value = "name") String name){
	        return "orror "+name ;
	    }

}
