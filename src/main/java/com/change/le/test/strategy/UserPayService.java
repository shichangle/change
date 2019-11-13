package com.change.le.test.strategy;

import java.math.BigDecimal;

/**
 * author shichangle
 * date 2019/11/13 0013 9:52
 */
public interface UserPayService {
    /*
    计算应付价格
     */
    public BigDecimal quote(BigDecimal orderPrice);
}
