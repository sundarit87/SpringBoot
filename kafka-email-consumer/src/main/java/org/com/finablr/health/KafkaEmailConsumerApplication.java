package org.com.finablr.health;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class KafkaEmailConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaEmailConsumerApplication.class, args);
	}

}
