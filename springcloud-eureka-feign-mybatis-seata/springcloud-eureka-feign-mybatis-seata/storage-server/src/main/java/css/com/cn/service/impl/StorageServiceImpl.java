package css.com.cn.service.impl;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import css.com.cn.dao.StorageDao;
import css.com.cn.service.StorageService;

/**
 * @author IT云清
 */
@Service("storageServiceImpl")
@Slf4j
public class StorageServiceImpl implements StorageService {


    @Autowired       
    private StorageDao storageDao;

    /**
     * 扣减库存
     * @param productId 产品id
     * @param count 数量
     * @return
     */
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->扣减库存开始");
        storageDao.decrease(productId,count);
       
        log.info("------->扣减库存结束");
    }
}
