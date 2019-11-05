package com.change.le.repository;

import com.change.le.POJO.entity.UserDO;
import org.springframework.data.repository.CrudRepository;

/**
 * author shichangle
 * date 2019/11/4 0004 16:11
 */
public interface UserRepository extends CrudRepository {
    UserDO findByName(String username);
}
