package com.jh.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jh.mapper.UserMapper;
import com.jh.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(timeout = 3000)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    private void info() {
        System.out.println("提供者1！！");
    }

    @Override
    public int saveUser(User user) {
        info();
        return userMapper.insert(user);
    }

    @Override
    public int deleteUser(User user) {
        info();
        Map<String, Object> userMap = new HashMap<String, Object>();
        if (user.getId()!=null){
            userMap.put("id", user.getId());
        }
        if (user.getName()!=null){
            userMap.put("name", user.getName());
        }
        if (user.getAge()!=null){
            userMap.put("age", user.getAge());
        }
        if (user.getSex()!=null){
            userMap.put("sex", user.getSex());
        }
        return userMapper.deleteByMap(userMap);
    }

    @Override
    public List<User> find() {
        info();
        return userMapper.selectList(null);
    }

    @Override
    public int updateUser(User user) {
        info();
        return userMapper.updateById(user);
    }
}
