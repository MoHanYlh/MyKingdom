package io.imking.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.imking.core.domain.User;
import io.imking.core.domain.UserExample;
import io.imking.core.domain.UserExample.Criteria;
import io.imking.core.mapper.UserMapper;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User login(String username, String password) {

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(username).andPwdEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

}
