package com.change.le.repository;

import com.change.le.POJO.entity.SubwayDO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * author shichangle
 * date 2019/11/13 0013 14:10
 */
public interface SubwayRepository extends CrudRepository<SubwayDO,Long> {
    List<SubwayDO> findAllByCityEnName(String cityEnName);
}
