package com.change.le.base;

import com.google.common.collect.Sets;
import org.springframework.data.domain.Sort;

import java.util.Set;

/**
 * 房屋的排序生成器
 * author shichangle
 * date 2019/10/23 0023 16:24
 */
public class HouseSort {

    public static final String DEFAULT_SORT_KEY = "lastUpdateTime";
    public static final String DISTANCE_TO_SUBWEY_KEY = "distanceToSubway";

    private static final Set<String> SORT_KEYS = Sets.newHashSet(
            DEFAULT_SORT_KEY,
            "createTime",
            "price",
            "area",
            DISTANCE_TO_SUBWEY_KEY
    );

    public static Sort generateSort(String key,String directionKey){
        key = getSortKey(key);
        Sort.Direction direction = Sort.Direction.fromString(directionKey);
        if(direction==null){
            direction = Sort.Direction.DESC;
        }
        return new Sort(direction,key);
    }

    private static String getSortKey(String key) {
        if (!SORT_KEYS.contains(key)) {
            key = DEFAULT_SORT_KEY;
        }
        return key;
    }


}
