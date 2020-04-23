package css.com.cn;

import lombok.extern.slf4j.Slf4j;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 库存服务
 * @author 
 */
@EnableEurekaClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("css.com.cn.dao")
@Slf4j
public class StorageServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorageServerApplication.class, args);
		log.info("启动完成");
	}

}