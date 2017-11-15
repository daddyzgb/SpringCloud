package consumer8070.Interface;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@FeignClient(value = "client8080",fallback=findTaxHystrix.class)
public interface FindTaxService {
		
	
		@RequestMapping(value = "/kiiik/findtax",method = RequestMethod.POST)
	    String findtaxinfo(@RequestParam(value = "mobile") String mobile);
		
		
		 @RequestMapping(value = "/hi",method = RequestMethod.GET)
		    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
