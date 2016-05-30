package solution.steve;

import org.springframework.boot.SpringApplication;
import org.apache.curator.test.TestingServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ZookeeperServerApplication {

    @Bean
    TestingServer testingServer() throws Exception {
        return new TestingServer(2181);
    }

	public static void main(String[] args) {
		SpringApplication.run(ZookeeperServerApplication.class, args);
	}
}
