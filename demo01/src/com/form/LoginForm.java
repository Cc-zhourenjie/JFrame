package com.form;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {

    //��¼����ʾ
    private JLabel loginName;
    //������ʾ
    private JLabel loginPwd;
    //��¼��ť
    private JButton login;
    //�û���
    private JTextField name;

    public LoginForm() throws HeadlessException {
        super("��¼����");
        //���ڴ�С
        this.setSize(500, 500);
        //����ر�
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //��������Ļ����
        this.setLocationRelativeTo(null);

        //������Ӧ�ؼ�
        loginName = new JLabel("�û�����");
        loginPwd = new JLabel("��  �룺");
        login = new JButton("��  ¼");

        //��������
        Container c = this.getContentPane();
        //����û�в���
        c.setLayout(null);
        //��������ӿؼ�
        c.add(loginName);
        c.add(loginPwd);
        c.add(login);

        //��������
        loginName.setFont(new Font("����", Font.PLAIN, 16));//�����������壬��ʽ�����壬б��ȣ����ֺ�
        loginPwd.setFont(new Font("����", Font.PLAIN, 16));//�����������壬��ʽ�����壬б��ȣ����ֺ�

        //���ÿؼ�λ��
        loginName.setBounds(120, 126, 80, 20);
        loginPwd.setBounds(120, 186, 80, 20);
        login.setBounds(200, 226, 80, 30);
    }
}
