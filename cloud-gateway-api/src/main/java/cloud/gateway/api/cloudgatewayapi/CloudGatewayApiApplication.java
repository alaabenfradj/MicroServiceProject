package cloud.gateway.api.cloudgatewayapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudGatewayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayApiApplication.class, args);
	}

}
