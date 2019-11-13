package com.change.le.repository;

import com.change.le.POJO.entity.HouseTagDO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * author shichangle
 * date 2019/11/13 0013 14:05
 */
public interface HouseTagRepository extends CrudRepository<HouseTagDO,Long> {
    List<HouseTagDO> findAllByHouseId(Long id);

    List<HouseTagDO> findAllByHouseIdIn(List<Long> houseIds);

    HouseTagDO findByNameAndHouseId(String tag,Long houseId);
}
