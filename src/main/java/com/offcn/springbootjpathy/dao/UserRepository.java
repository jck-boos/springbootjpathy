package com.offcn.springbootjpathy.dao;

import com.offcn.springbootjpathy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jinchuangke
 * @email 1814214586@qq.com
 * @data 2020/5/11
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);
    User findByNameAndAge(String name,Integer age);

}
