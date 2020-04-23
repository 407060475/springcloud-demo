package css.com.cn.service;

import java.math.BigDecimal;

import css.com.cn.entity.Order;


public interface OrderService {
	
	/**
     * 创建订单
     * @param order
     * @return
     */
    void create(Order order);

    /**
     * 修改订单状态
     * @param userId
     * @param money
     * @param status
     */
    void update(Long userId,Integer status);

}
