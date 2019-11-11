package com.change.le.service.serviceImpl;

import com.change.le.POJO.entity.UserDO;
import com.change.le.repository.UserRepository;
import com.change.le.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author shichangle
 * date 2019/11/4 0004 15:57
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDO findUserByName(String name) {
        UserDO byName = userRepository.findByName(name);
        return byName;
    }


}
