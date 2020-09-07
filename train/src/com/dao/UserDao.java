package com.dao;

import com.pojo.User;

/**
 * 用户的数据库操作接口
 */
public interface UserDao {

    /**
     * 登录检查
     *
     * @param user
     * @return
     */
    User loginCheck(User user);

    /**
     * 注册
     *
     * @param user
     * @return
     */
    User register(User user);
}
