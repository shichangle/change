package com.change.le.test.strategy;





import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * author shichangle
 * date 2019/11/13 0013 9:49
 */


/**
 * 为了方便我们从Spring中获取UserPayService各个策略类，我们创建一个工厂类
 */

public class UserPayServiceStrategyFactory {
    private static Map<String,UserPayService> service = new ConcurrentHashMap<String,UserPayService>();

    public static UserPayService getByUserType(String type){
        return service.get(type);

    }

    public static void register(String userType,UserPayService userPayService){
        //Assert.notNull(userType,"usertype can't be null");
        service.put(userType,userPayService);

    }
}
