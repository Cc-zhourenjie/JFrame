package com.util;

import java.sql.*;

public class DBUtil {
    private static String DRIVER = "com.mysql.jdbc.Driver";  //连接数据库的类信息
    private static String URL = "jdbc:mysql://127.0.0.1:3306/demo";  //数据库地址
    private static String USER = "root";  //用户名
    private static String PASSWORD = "123456";  //密码

    /**
     * 创建数据库的连接
     *
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    /**
     * 增、删、改数据库信息
     *
     * @param sql
     * @param obj
     * @return
     */
    public static int upDate(String sql, Object... obj) {
        int result = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++)
                stmt.setObject(i + 1, obj[i]);
            result = stmt.executeUpdate();      //本句话有一个异常
        } catch (SQLException e) {
            System.out.println("数据已存在");
            throw new RuntimeException(e.getMessage());
        } finally {
            closeAll(null, conn, stmt);
        }
        return result;
    }


    /**
     * 关闭所有缓冲
     *
     * @param rs
     * @param conn
     * @param stmt
     */
    public static void closeAll(ResultSet rs, Connection conn, Statement stmt) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
