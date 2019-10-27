package com.change.le.base;

/**
 * 预约状态码
 * author shichangle
 * date 2019/10/23 0023 17:13
 */
public enum HouseSubscribeStatusEnum {
    NO_SUBSCRIBE(0),//未预约
    IN_ORDER_LIST(1),//已加入待看清单
    IN_ORDER_TIME(2),//已经预约看房时间
    FINISH(3);//已完成预约

    private int value;

    HouseSubscribeStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static HouseSubscribeStatusEnum of(int value){
        for (HouseSubscribeStatusEnum houseSubscribeStatusEnum : HouseSubscribeStatusEnum.values()) {
            if(houseSubscribeStatusEnum.getValue()==value){
                return houseSubscribeStatusEnum;
            }
        }
        return HouseSubscribeStatusEnum.NO_SUBSCRIBE;
    }
}
