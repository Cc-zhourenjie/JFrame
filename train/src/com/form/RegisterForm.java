package com.form;

import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 注册窗口
 */
public class RegisterForm extends JFrame implements ActionListener {

    private JLabel registerName, registerPwd, registerId, registerPhone;
    //登录按钮
    private JButton login, register;
    //用户名文本框
    private JTextField name, id, phone;
    //密码输入框
    private JPasswordField pwd;

    public RegisterForm() throws HeadlessException {
        super("注册");
        //设置窗口大小
        this.setBounds(600, 200, 400, 320);
        //关闭按钮
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //窗口初始化居中
        this.setLocationRelativeTo(null);

        //创建控件
        registerName = new JLabel("用户名：");
        registerPwd = new JLabel("密  码：");
        registerId = new JLabel("身份证号：");
        registerPhone = new JLabel("手机号：");

        login = new JButton("去登录");
        register = new JButton("注  册");

        name = new JTextField(500);
        id = new JTextField(500);
        phone = new JTextField(500);
        pwd = new JPasswordField(500);

        //创建容器
        Container c = this.getContentPane();
        //设置布局
        c.setLayout(new BorderLayout());

        /*标题部分靠上--North*/
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("火车票注册系统"));
        c.add(titlePanel, "North");

        /*输入部分居中--Center*/
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        //给容器添加控件
        fieldPanel.add(registerName);
        fieldPanel.add(registerId);
        fieldPanel.add(registerPwd);
        fieldPanel.add(registerPhone);
        //添加输入框控件
        fieldPanel.add(name);
        fieldPanel.add(pwd);
        fieldPanel.add(id);
        fieldPanel.add(phone);
        c.add(fieldPanel, "Center");

        /*按钮部分靠下--South*/
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(login);
        buttonPanel.add(register);
        c.add(buttonPanel, "South");

        //设置字体
        registerName.setFont(new Font("宋体", Font.PLAIN, 16));
        registerPwd.setFont(new Font("宋体", Font.PLAIN, 16));
        registerId.setFont(new Font("宋体", Font.PLAIN, 16));
        registerPhone.setFont(new Font("宋体", Font.PLAIN, 16));
        name.setFont(new Font("宋体", Font.PLAIN, 16));
        pwd.setFont(new Font("宋体", Font.PLAIN, 16));
        id.setFont(new Font("宋体", Font.PLAIN, 16));
        phone.setFont(new Font("宋体", Font.PLAIN, 16));
        login.setFont(new Font("宋体", Font.PLAIN, 16));
        register.setFont(new Font("宋体", Font.PLAIN, 16));

        //设置控件位置
        registerName.setBounds(80, 36, 80, 30);
        name.setBounds(170, 36, 120, 30);
        registerPwd.setBounds(80, 76, 80, 30);
        pwd.setBounds(170, 76, 120, 30);
        registerId.setBounds(80, 116, 1120, 30);
        id.setBounds(170, 116, 120, 30);
        registerPhone.setBounds(80, 156, 1120, 30);
        phone.setBounds(170, 156, 120, 30);

        login.setBounds(150, 236, 100, 30);
        register.setBounds(180, 236, 100, 30);
        login.addActionListener(this);
        register.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UserService userService = new UserServiceImpl();
        if (e.getSource() == login) {
            //关闭当前窗口
            this.dispose();
            //打开注册窗口
            LoginForm loginForm = new LoginForm();
            loginForm.setVisible(true);
        }
        //点击注册按钮
        if (e.getSource() == register) {
            //获取输入的注册信息
            String name = this.name.getText();
            String password = String.valueOf(pwd.getPassword());
            String id = this.id.getText();
            String phone = this.phone.getText();
            if ("".equals(name) || "".equals(password) || "".equals(id) || "".equals(phone)) {
                JOptionPane.showMessageDialog(new JPanel(), "请完善用户信息", "错误", JOptionPane.WARNING_MESSAGE);
            } else {
                User registerUser = userService.register(new User() {{
                    setName(name);
                    setPwd(password);
                    setIdentity(id);
                    setPhone(phone);
                }});
                //注册成功返回登录页面
                if (registerUser != null) {
                    JOptionPane.showMessageDialog(new JPanel(), "注册成功", "成功", JOptionPane.WARNING_MESSAGE);
                    //关闭当前窗口
                    this.dispose();
                    //打开注册窗口
                    LoginForm loginForm = new LoginForm();
                    loginForm.setVisible(true);
                }
            }
        }


    }
}
