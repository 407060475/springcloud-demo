package css.com.cn.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 库存服务
 * @author Administrator
 *
 */
@FeignClient(value="storage-server",fallback=FallBack.class)
public interface StorageApi  {
	
	/**
     * 扣减库存
     * @param userId 用户id
     * @param money 金额
     * @return
     */
    @RequestMapping("/storage/decrease")
    String decrease(@RequestParam("productId") Long userId, @RequestParam("count") Integer count);

}
