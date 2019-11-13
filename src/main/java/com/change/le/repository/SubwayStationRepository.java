package com.change.le.repository;

import com.change.le.POJO.entity.SubwayStationDO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * author shichangle
 * date 2019/11/13 0013 14:12
 */
public interface SubwayStationRepository extends CrudRepository<SubwayStationDO,Long> {
    List<SubwayStationDO> findAllBySubwayId(Long subwayId);
}
