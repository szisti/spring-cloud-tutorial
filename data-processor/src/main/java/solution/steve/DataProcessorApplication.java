package solution.steve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DataProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataProcessorApplication.class, args);
	}
}
