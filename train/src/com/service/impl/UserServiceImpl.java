package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.pojo.User;
import com.service.UserService;

/**
 * 用户服务层
 */
public class UserServiceImpl implements UserService {
    //数据库层对象
    private UserDao userDao = new UserDaoImpl();

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @Override
    public User loginCheck(User user) {
        //判断输入的是否为空
        if (user != null && user.getName() != null && user.getPwd() != null) {
            User resultUser = userDao.loginCheck(user);
            //查到了用户表示输入正确，否侧返回空值
            if (resultUser != null) {
                return resultUser;
            }
        }
        return null;
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @Override
    public User register(User user) {
        return userDao.register(user);
    }
}
