package com.change.le.service.serviceImpl;

import com.change.le.POJO.entity.UserDO;
import com.change.le.repository.UserRepository;
import com.change.le.service.UserService;

/**
 * author shichangle
 * date 2019/11/4 0004 15:57
 */
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDO findUserByName(String name) {
        return userRepository.findByName(name);
    }
}
