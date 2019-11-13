package com.change.le.repository;

import com.change.le.POJO.entity.RoleDO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * author shichangle
 * date 2019/11/11 0011 18:58
 */
public interface RoleRepository extends CrudRepository<RoleDO,Long> {
    List<RoleDO> findRolesByUserId(Long userId);
}
