package css.com.cn.ctrl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import css.com.cn.service.AccountService;

@RestController
@RequestMapping(value = "account")
public class AccountController {

	@Autowired
    private AccountService accountServiceImpl;
	
	
	@RequestMapping("/index")
	public String index(){
		return "account";
	}

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     * @return
     */
    @RequestMapping("decrease")
    public String decrease(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money){
        accountServiceImpl.decrease(userId,money);
        return "Account decrease success";
    }
}
