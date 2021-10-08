package com.translog.workitem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WorkitemApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkitemApplication.class, args);
	}

}
