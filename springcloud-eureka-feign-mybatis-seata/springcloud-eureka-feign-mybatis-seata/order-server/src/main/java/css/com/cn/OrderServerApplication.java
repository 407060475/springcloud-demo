package css.com.cn;

import lombok.extern.slf4j.Slf4j;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 订单服务
 * @author 
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@MapperScan("css.com.cn.dao")
@EnableDiscoveryClient
@EnableFeignClients
@Slf4j
public class OrderServerApplication {

	public static void main(String[] args) {
		log.info("启动开始");
		SpringApplication.run(OrderServerApplication.class, args);
		log.info("启动完成");
	}

}
