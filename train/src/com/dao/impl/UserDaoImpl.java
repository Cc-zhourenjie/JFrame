package com.dao.impl;

import com.dao.UserDao;
import com.pojo.User;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.UUID;

/**
 * 用户数据库操作服务层
 */
public class UserDaoImpl implements UserDao {

    /**
     * 检查登录
     *
     * @param user
     * @return
     */
    @Override
    public User loginCheck(User user) {
        Connection conn = null;  //链接信息
        ResultSet rs = null;  //结果集
        PreparedStatement stmt = null;  //sql执行
        User resultUser = new User();

        try {
            conn = DBUtil.getConnection();
            String sql = "select * from user where name = '" + user.getName() + "' and pwd = '" + user.getPwd() + "'";
            stmt = conn.prepareStatement(sql);  //执行方法
            rs = stmt.executeQuery();  //数据库查询
            while (rs.next()) {  //检查结果里下一个是否有值
                String id = rs.getString("id");
                String name = rs.getString("name");
                String pwd = rs.getString("pwd");
                String identity = rs.getString("identity");
                String phone = rs.getString("phone");

                resultUser.setId(id);
                resultUser.setName(name);
                resultUser.setPwd(pwd);
                resultUser.setIdentity(identity);
                resultUser.setPhone(phone);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, conn, stmt);
        }
        return resultUser;
    }


    /**
     * 注册
     *
     * @param user
     * @return
     */
    @Override
    public User register(User user) {
        int result;
        try {
            String sql = "insert into user values(?,?,?,?,?)";
            String id = UUID.randomUUID().toString();
            result = DBUtil.upDate(
                    sql,
                    id,
                    user.getName(),
                    user.getPwd(),
                    user.getIdentity(),
                    user.getPhone());
            if (result != 0) {
                user.setId(id);
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
