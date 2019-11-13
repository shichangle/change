package com.change.le.test.strategy;

import org.springframework.beans.factory.InitializingBean;

import java.math.BigDecimal;

/**
 * author shichangle
 * date 2019/11/13 0013 10:45
 */
public class SuperVipPayService implements UserPayService, InitializingBean {
    @Override
    public BigDecimal quote(BigDecimal orderPrice) {

        return orderPrice.multiply(new BigDecimal(0.8));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        UserPayServiceStrategyFactory.register("SuperVip", this);
    }
}
