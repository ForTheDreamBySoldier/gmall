package com.atguigu.gmall.user.service.impl;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.user.mapper.UserAdressMapper;
import com.atguigu.gmall.user.mapper.UserInfoMapper;
import com.atguigu.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserInfoMapper userInfoMapper;
private UserAdressMapper userAdressMapper;


    @Override
    public List<UserInfo> getUserInfoListAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
    }

    @Override
    public void updateUser(String id, UserInfo userInfo) {
        userInfoMapper.updateByExample(userInfo,id);
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        return userAdressMapper.selectByExample(userId);
    }

    @Override
    public UserInfo login(UserInfo userInfo) {
        return userInfoMapper.selectOne(userInfo);
    }

    @Override
    public UserInfo verify(String userId) {
        return userInfoMapper.selectByPrimaryKey(userId);
    }
}
