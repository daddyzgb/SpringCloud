package textboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class Client8081Application {

    @RequestMapping("/")
    public String greeting() {
    	//8081端口
        return "HELLO WORLD!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Client8081Application.class, args);
    }
}