package css.com.cn;

import lombok.extern.slf4j.Slf4j;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 账户服务
 * @author 
 */
@MapperScan("css.com.cn.dao")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients
@Slf4j
public class AccountServerApplication {
	public static void main(String[] args) {
		log.info("启动开始");
		SpringApplication.run(AccountServerApplication.class, args);
		log.info("启动结束");
	}

}
