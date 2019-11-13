package com.change.le.repository;

import com.change.le.POJO.entity.HousePicDO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * author shichangle
 * date 2019/11/13 0013 13:52
 */
public interface HousePictureReposity extends CrudRepository<HousePicDO,Long> {
    List<HousePicDO> findAllByHouseId(Long id);
}
