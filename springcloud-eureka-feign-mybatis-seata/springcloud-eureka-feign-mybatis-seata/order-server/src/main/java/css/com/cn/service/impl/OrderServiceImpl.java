package css.com.cn.service.impl;

import io.seata.spring.annotation.GlobalTransactional;


import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import css.com.cn.dao.OrderDao;
import css.com.cn.entity.Order;
import css.com.cn.feign.AccountApi;
import css.com.cn.feign.StorageApi;
import css.com.cn.service.OrderService;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao orderDao;
	@Autowired
	StorageApi storageApi;
	@Autowired
	AccountApi accountApi;

	 /**
     * 创建订单
     * @param order
     * @return
     * 测试结果：
     * 1.添加本地事务：仅仅扣减库存
     * 2.不添加本地事务：创建订单，扣减库存
     */
	@GlobalTransactional(name = "fsp-create-order")
	@Override
	public void create(Order order) {
		  	log.info("------->下单开始");
	        //本应用创建订单
	        orderDao.create(order);

	        //远程调用库存服务扣减库存
	        log.info("------->order-service中扣减库存开始");
	        storageApi.decrease(order.getProductId(),order.getCount());
	        log.info("------->order-service中扣减库存结束:{}",order.getId());

	        //远程调用账户服务扣减余额
	        log.info("------->order-service中扣减余额开始");
	        accountApi.decrease(order.getUserId(),order.getMoney());
	        log.info("------->order-service中扣减余额结束");

	        //修改订单状态为已完成
	        log.info("------->order-service中修改订单状态开始");
	        orderDao.update(order.getUserId(),0);
	        log.info("------->order-service中修改订单状态结束");

	        log.info("------->下单结束");
	}

	 /**
     * 修改订单状态
     */
	@Override
	public void update(Long userId, Integer status) {
		orderDao.update(userId, status);

	}

}
