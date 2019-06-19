package com.unimoni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
//@ComponentScan({"com.unimoni","com.unimoni.service","com.unimoni.service.impl"})
@EnableFeignClients
//@EnableHystrixDashboard
//@EnableHystrixDashboard
//@EnableTurbine
public class BookAppointmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookAppointmentApplication.class, args);
	}

}
