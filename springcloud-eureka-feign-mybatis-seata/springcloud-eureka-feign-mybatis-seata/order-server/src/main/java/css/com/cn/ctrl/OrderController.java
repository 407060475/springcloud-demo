package css.com.cn.ctrl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import css.com.cn.entity.Order;
import css.com.cn.service.OrderService;

@RestController
@RequestMapping(value = "order")
public class OrderController {

	@Autowired
	OrderService orderServiceImpl;
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}

	/**
	 * 创建订单
	 * 
	 * @param order
	 * @return
	 */
	@GetMapping("/create")
	public String create(Order order) {
		orderServiceImpl.create(order);
		return "Create order success";
	}

	/**
	 * 修改订单状态
	 * 
	 * @param userId
	 * @param money
	 * @param status
	 * @return
	 */
	@RequestMapping("update")
	String update(@RequestParam("userId") Long userId,
			@RequestParam("status") Integer status) {
		orderServiceImpl.update(userId, status);
		return "订单状态修改成功";
	}
}
