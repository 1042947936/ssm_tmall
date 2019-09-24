package com.entor.tmall.service.impl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entor.tmall.dao.UserMapper;
import com.entor.tmall.bean.User;
import com.entor.tmall.bean.UserExample;
import com.entor.tmall.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    UserMapper userMapper;
 
    @Override
    public void add(User u) {
        userMapper.insert(u);
    }
 
    @Override
    public void delete(int id) {
        userMapper.deleteByPrimaryKey(id);
    }
 
    @Override
    public void update(User u) {
        userMapper.updateByPrimaryKeySelective(u);
    }
 
    @Override
    public User get(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
 
    public List<User> list(){
        UserExample example =new UserExample();
        example.setOrderByClause("id desc");
        return userMapper.selectByExample(example);
 
    }


}

