package com.srmasset.thcepdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
/**
 * Classe configuração do spring boot
 * @author ledzo
 *
 */
@SpringBootApplication
@ComponentScan({ "com.srmasset" })
@EnableCaching
@EnableEurekaServer
@EnableEurekaClient
@EnableCircuitBreaker
public class ThCepDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThCepDetailsApplication.class, args);
	}

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}


}
