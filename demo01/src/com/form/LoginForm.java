package com.form;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {

    //登录名显示
    private JLabel loginName;
    //密码显示
    private JLabel loginPwd;
    //登录按钮
    private JButton login;
    //用户名
    private JTextField name;

    public LoginForm() throws HeadlessException {
        super("登录窗口");
        //窗口大小
        this.setSize(500, 500);
        //点击关闭
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //初花在屏幕中央
        this.setLocationRelativeTo(null);

        //创建对应控件
        loginName = new JLabel("用户名：");
        loginPwd = new JLabel("密  码：");
        login = new JButton("登  录");

        //创建容器
        Container c = this.getContentPane();
        //设置没有布局
        c.setLayout(null);
        //给容器添加控件
        c.add(loginName);
        c.add(loginPwd);
        c.add(login);

        //设置字体
        loginName.setFont(new Font("宋体", Font.PLAIN, 16));//设置字体字体，样式（粗体，斜体等），字号
        loginPwd.setFont(new Font("宋体", Font.PLAIN, 16));//设置字体字体，样式（粗体，斜体等），字号

        //设置控件位置
        loginName.setBounds(120, 126, 80, 20);
        loginPwd.setBounds(120, 186, 80, 20);
        login.setBounds(200, 226, 80, 30);
    }
}
