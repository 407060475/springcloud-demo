package css.com.cn.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import css.com.cn.entity.Order;

@Repository
public interface OrderDao {
	
	 /**
     * 创建订单
     * @param order
     * @return
     */
    void create(Order order);

    /**
     * 修改订单金额
     * @param userId
     * @param money
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);

}
