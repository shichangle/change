package com.change.le.repository;

import com.change.le.POJO.entity.SupportAddressDO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * author shichangle
 * date 2019/11/13 0013 14:14
 */
public interface SupportAddressRepository extends CrudRepository<SupportAddressDO,Long> {
    /**
     * 获取所有对应行政级别的信息
     * @return
     */
    List<SupportAddressDO> findAllByLevel(String level);

    SupportAddressDO findByEnNameAndLevel(String enName, String level);

    SupportAddressDO findByEnNameAndBelongTo(String enName, String belongTo);

    List<SupportAddressDO> findAllByLevelAndBelongTo(String level, String belongTo);

}
