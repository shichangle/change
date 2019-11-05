package com.change.le.service;

import com.change.le.POJO.entity.UserDO;

/**
 * author shichangle
 * date 2019/11/4 0004 15:56
 */
public interface UserService {
    UserDO findUserByName(String name);
}
