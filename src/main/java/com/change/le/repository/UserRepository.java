package com.change.le.repository;

import com.change.le.POJO.entity.UserDO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * author shichangle
 * date 2019/11/4 0004 16:11
 */
public interface UserRepository extends CrudRepository<UserDO,Long> {

    UserDO findByName( String username);
}
