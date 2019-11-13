package com.change.le.test.strategy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * author shichangle
 * date 2019/11/13 0013 10:04
 */
@Service
public class ParticularlyVipPayService implements UserPayService, InitializingBean {
    @Override
    public BigDecimal quote(BigDecimal orderPrice) {
        if (orderPrice.compareTo(new BigDecimal(30)) == 1) {
            return orderPrice.multiply(new BigDecimal(0.7));
        } else {
            return orderPrice;
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        UserPayServiceStrategyFactory.register("ParticularlyVip",this);
    }
}
