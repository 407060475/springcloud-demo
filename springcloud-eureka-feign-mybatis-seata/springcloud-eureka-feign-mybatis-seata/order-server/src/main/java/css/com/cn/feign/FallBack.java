package css.com.cn.feign;

import java.math.BigDecimal;

public class FallBack implements AccountApi,StorageApi {

	@Override
	public String decrease(Long userId, BigDecimal money) {
		
		return "failback";
	}

	@Override
	public String decrease(Long userId, Integer count) {
		return  "failback";
	}

}
