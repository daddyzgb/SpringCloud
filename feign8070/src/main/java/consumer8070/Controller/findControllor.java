package consumer8070.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import consumer8070.Interface.FindTaxService;

@RestController
public class findControllor {
	
		@Autowired
	    FindTaxService fService;
	   
		@RequestMapping(value = "/kiiik/findtax",method = RequestMethod.GET)
	    public String find(@RequestParam String mobile){
	        return fService.findtaxinfo(mobile);
	    }
		
		  @RequestMapping(value = "/hi",method = RequestMethod.GET)
		    public String sayHi(@RequestParam String name){
		        return fService.sayHiFromClientOne(name);
		    }
		
		

}
