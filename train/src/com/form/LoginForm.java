package com.form;

import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 登录窗口
 */
public class LoginForm extends JFrame implements ActionListener {

    private JLabel loginName;
    private JLabel loginPwd;
    //登录按钮
    private JButton login, register;
    //用户名文本框
    private JTextField name;
    //密码输入框
    private JPasswordField pwd;

    public LoginForm() throws HeadlessException {
        super("登录");
        //设置窗口大小
        this.setBounds(600, 200, 400, 320);
        //关闭按钮
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //窗口初始化居中
        this.setLocationRelativeTo(null);

        //创建控件
        loginName = new JLabel("用户名：");
        loginPwd = new JLabel("密  码：");
        login = new JButton("登  录");
        register = new JButton("注  册");
        name = new JTextField(500);
        pwd = new JPasswordField(500);

        //创建容器
        Container c = this.getContentPane();
        //设置布局
        c.setLayout(new BorderLayout());
        /*标题部分靠上--North*/
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("火车票登录系统"));
        c.add(titlePanel, "North");
        /*输入部分居中--Center*/
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        //给容器添加控件
        fieldPanel.add(loginName);
        fieldPanel.add(loginPwd);
        fieldPanel.add(name);
        fieldPanel.add(pwd);
        c.add(fieldPanel, "Center");

        /*按钮部分靠下--South*/
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(login);
        buttonPanel.add(register);
        c.add(buttonPanel, "South");

        //设置字体
        loginName.setFont(new Font("宋体", Font.PLAIN, 16));
        loginPwd.setFont(new Font("宋体", Font.PLAIN, 16));
        login.setFont(new Font("宋体", Font.PLAIN, 16));
        name.setFont(new Font("宋体", Font.PLAIN, 16));
        pwd.setFont(new Font("宋体", Font.PLAIN, 16));
        register.setFont(new Font("宋体", Font.PLAIN, 16));

        //设置控件位置
        loginName.setBounds(80, 76, 80, 30);
        name.setBounds(170, 76, 120, 30);
        loginPwd.setBounds(80, 116, 80, 30);
        pwd.setBounds(170, 116, 120, 30);
        login.setBounds(150, 236, 100, 30);
        register.setBounds(180, 236, 100, 30);

        login.addActionListener(this);
        register.addActionListener(this);
    }

    /**
     * 点击按钮事件
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        UserService userService = new UserServiceImpl();
        //点击登录按钮
        if (e.getSource() == login) {
            String name = this.name.getText();
            String password = String.valueOf(pwd.getPassword());
            //判断输入的是否为空值
            if ("".equals(name) || "".equals(password)) {
                //弹框
                JOptionPane.showMessageDialog(new JPanel(), "请输入正确的用户名和密码", "错误", JOptionPane.WARNING_MESSAGE);
            } else { //不为空值查询数据库
                User user = userService.loginCheck(new User() {{
                    setName(name);
                    setPwd(password);
                }});
                if (user != null) {
                    //关闭当前窗口
                    this.dispose();
                    IndexForm indexForm = new IndexForm();
                    indexForm.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(new JPanel(), "用户名或密码输入错误", "错误", JOptionPane.WARNING_MESSAGE);
                }
            }

        }
        //点击注册按钮
        if (e.getSource() == register) {
            //关闭当前窗口
            this.dispose();
            //打开注册窗口
            RegisterForm registerForm = new RegisterForm();
            registerForm.setVisible(true);
        }

    }
}
