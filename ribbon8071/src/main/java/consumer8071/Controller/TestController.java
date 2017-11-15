package consumer8071.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import consumer8071.Service.TestService;

@RestController
public class TestController {
	
	@Autowired
	TestService testservice;
	
	@RequestMapping(value = "/hi")
	public String hi(@RequestParam String name){
        return testservice.hiService(name);
    }
	
	@RequestMapping(value = "/kiiik/findtax")
	public String find(@RequestParam String mobile){
        return testservice.findService(mobile);
    }

}
