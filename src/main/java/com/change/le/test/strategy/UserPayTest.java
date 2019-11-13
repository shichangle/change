package com.change.le.test.strategy;

import java.math.BigDecimal;

/**
 * author shichangle
 * date 2019/11/13 0013 9:56
 */
public class UserPayTest {


    /*
    入口：
     */
    public BigDecimal calPrice(BigDecimal orderPrice,User user){
        String vipType = user.getVipType();
        UserPayService userPayService = UserPayServiceStrategyFactory.getByUserType(vipType);
        return userPayService.quote(orderPrice);
    }
}
