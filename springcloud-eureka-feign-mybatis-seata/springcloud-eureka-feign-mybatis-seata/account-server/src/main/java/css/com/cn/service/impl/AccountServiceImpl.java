package css.com.cn.service.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import css.com.cn.dao.AccountDao;
import css.com.cn.feign.OrderApi;
import css.com.cn.service.AccountService;


/**
 * 账户业务实现类
 * @author admin
 *
 */
@Service
public class AccountServiceImpl  implements AccountService{

	 private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
	    @Autowired
	    private AccountDao accountDao;
	    @Autowired
	    private OrderApi orderApi;

	    /**
	     * 扣减账户余额
	     * @param userId 用户id
	     * @param money 金额
	     */
	    
	    @Override
	    public void decrease(Long userId, BigDecimal money) {
	    	LOGGER.info("------->account-service中扣减账户余额开始");
	    	//模拟超时，全局事务回滚
	    		try {
					Thread.sleep(30*3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        accountDao.decrease(userId,money);
	        LOGGER.info("------->account-service中扣减账户余额结束");

	       
	    }

}
