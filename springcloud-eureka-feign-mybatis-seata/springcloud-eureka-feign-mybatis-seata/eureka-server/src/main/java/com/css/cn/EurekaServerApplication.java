package com.css.cn;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
@Slf4j
public class EurekaServerApplication {

	public static void main(String[] args) {
		log.info("启动开始");
		SpringApplication.run(EurekaServerApplication.class, args);
		log.info("启动结束");
	}

}
