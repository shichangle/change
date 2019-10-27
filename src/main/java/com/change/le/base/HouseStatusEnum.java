package com.change.le.base;

/**
 * 房源状态
 * author shichangle
 * date 2019/10/23 0023 17:09
 */
public enum HouseStatusEnum {
    NOT_AUDITED(0),//未审核
    PASSES(1),//审核通过
    RENTED(2),//已出租
    DELETED(3);//逻辑删除

    private int value;

    HouseStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }}

