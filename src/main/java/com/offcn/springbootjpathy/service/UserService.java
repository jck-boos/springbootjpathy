package com.offcn.springbootjpathy.service;

import com.offcn.springbootjpathy.model.User;

import java.util.List;

/**
 * @author jinchuangke
 * @email 1814214586@qq.com
 * @data 2020/5/11
 */
public interface UserService {
    //获取全部用户数据
    List<User> getUserList();
    //新增用户数据
    void createUser(User user);
    //获取指定id用户信息
    User getUser(Long id);
    //更新指定id用户信息
    void updateUser(Long id,User user);
    //删除指定id用户
    void deleteUser(Long id);

}
