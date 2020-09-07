package com.service;

import com.pojo.User;

/**
 * 用户服务层接口
 */
public interface UserService {

    /**
     * 登录
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
