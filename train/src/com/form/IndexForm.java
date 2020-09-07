package com.form;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 系统首页
 */
public class IndexForm extends JFrame implements ActionListener {

    JButton add, viewAll, serach, sellTicket, returnTicket, delete;


    public IndexForm() {
        super("主界面");
        setBounds(400, 100, 700, 500);
        //窗口初始化居中
        this.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);
        JLabel label = new JLabel("欢迎进入车票管理系统");
        label.setFont(new Font("BOLD", Font.BOLD, 28));
        panel.add(label);
        label.setBounds(200, 20, 400, 100);

        add = new JButton("录入");
        panel.add(add);
        add.setBounds(50, 200, 80, 50);

        viewAll = new JButton("浏览");
        panel.add(viewAll);
        viewAll.setBounds(150, 200, 80, 50);

        serach = new JButton("查询");
        panel.add(serach);
        serach.setBounds(250, 200, 80, 50);

        sellTicket = new JButton("售票");
        panel.add(sellTicket);
        sellTicket.setBounds(350, 200, 80, 50);

        returnTicket = new JButton("退票");
        panel.add(returnTicket);
        returnTicket.setBounds(450, 200, 80, 50);

        delete = new JButton("删除");
        panel.add(delete);
        delete.setBounds(550, 200, 80, 50);

        add.addActionListener(this);
        viewAll.addActionListener(this);
        serach.addActionListener(this);
        sellTicket.addActionListener(this);
        returnTicket.addActionListener(this);
        delete.addActionListener(this);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == viewAll){
            //关闭当前窗口
            this.dispose();
            TicketViewAll viewAll = new TicketViewAll();
            viewAll.setVisible(true);
        }
    }
}
