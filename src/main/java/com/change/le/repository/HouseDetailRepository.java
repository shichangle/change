package com.change.le.repository;

import com.change.le.POJO.entity.HouseDetailDO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * author shichangle
 * date 2019/11/13 0013 13:49
 */
public interface HouseDetailRepository extends CrudRepository<HouseDetailDO,Long> {
    HouseDetailDO findByHouseId(Long houseId);
    List<HouseDetailDO> findAllByHouseIdIn(List<Long> houseIds);
}
