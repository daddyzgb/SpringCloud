package consumer8071.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class TestService {
	
	@Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {
        return restTemplate.getForObject("http://CLIENT8080/hi?name="+name,String.class);
    }
    
    public String findService(String mobile) {
        return restTemplate.getForObject("http://CLIENT8080/kiiik/findtax?mobile="+mobile,String.class);
    }

}
