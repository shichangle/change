package com.change.le.repository;

import com.change.le.POJO.entity.HOuseSubscribeDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * author shichangle
 * date 2019/11/13 0013 14:00
 */
public interface HouseSubscribeRepository extends PagingAndSortingRepository<HOuseSubscribeDO,Long> {
    HOuseSubscribeDO findByHouseIdAndUserId(Long houseId,Long loginUserId);

    Page<HOuseSubscribeDO> findAllByUserIdAndStatus(Long userId, int status, Pageable pageable);

    Page<HOuseSubscribeDO> findAllByAdminIdAndStatus(Long adminId, int status, Pageable pageable);

    HOuseSubscribeDO findByHouseIdAndAdminId(Long houseId, Long adminId);

    @Modifying
    @Query("update HOuseSubscribeDO as subscribe set subscribe.status = :status where subscribe.id = :id")
    void updateStatus(@Param(value = "id") Long id, @Param(value = "status") int status);
}
