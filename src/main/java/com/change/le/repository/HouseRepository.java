package com.change.le.repository;

import com.change.le.POJO.entity.HouseDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * author shichangle
 * date 2019/11/13 0013 13:54
 */
public interface HouseRepository extends PagingAndSortingRepository<HouseDO,Long>, JpaSpecificationExecutor<HouseDO> {
    @Modifying
    @Query("update HouseDO as house set house.cover = :cover where house.id = :id")
    void updateCover(@Param(value = "id")Long id,@Param(value = "cover")String cover);

    @Modifying
    @Query("update HouseDO as house set house.status = :status where house.id = :id")
    void updateStatus(@Param(value = "id")Long id, @Param(value = "status")int status);

    @Modifying
    @Query("update HouseDO as house set house.watchTimes = house.watchTimes + 1 where house.id = :houseId")
    void updateWatchTimes(@Param(value = "id") Long houseId);
}
