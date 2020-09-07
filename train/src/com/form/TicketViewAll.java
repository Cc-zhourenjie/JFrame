package com.form;

import com.pojo.Train;
import com.service.TrainService;
import com.service.impl.TrainServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 查询车票和订票
 */
public class TicketViewAll extends JFrame {

    private JLabel searchNum, buyNum;
    private JTextField numSearch, numBuy;
    private JButton sell;


    public TicketViewAll() {

        this.setBounds(200, 200, 800, 600);
        this.setTitle("浏览车次信息");
        //窗口初始化居中
        this.setLocationRelativeTo(null);
        //创建控件
        searchNum = new JLabel("请输入班次");
        searchNum.setBounds(165, 100, 120, 30);
        numSearch = new JTextField(15);
        numSearch.setBounds(295, 100, 120, 30);

        buyNum = new JLabel("请输入购票数量");
        buyNum.setBounds(165, 150, 120, 30);
        numBuy = new JTextField(15);
        numBuy.setBounds(295, 150, 120, 30);

        sell = new JButton("购票");
        sell.setBounds(239, 200, 120, 30);
        //创建容器
        Container c = this.getContentPane();
        c.setLayout(new GridLayout(3, 1));
        JPanel title = new JPanel(new GridLayout(1, 6));
        JLabel num = new JLabel("班次", SwingConstants.CENTER);
        JLabel time = new JLabel("发车时间", SwingConstants.CENTER);
        JLabel start = new JLabel("起点站", SwingConstants.CENTER);
        JLabel end = new JLabel("终点站", SwingConstants.CENTER);
        JLabel remain = new JLabel("余票", SwingConstants.CENTER);
        JLabel price = new JLabel("票价", SwingConstants.CENTER);

        title.add(num);
        title.add(time);
        title.add(start);
        title.add(end);
        title.add(remain);
        title.add(price);


        JPanel tick = new JPanel();
        tick.add(searchNum);
        tick.add(numSearch);
        tick.add(buyNum);
        tick.add(numBuy);
        tick.add(sell);

        //查询全部车次信息
        TrainService trainService = new TrainServiceImpl();
        List<Train> trains = trainService.getTrains();

        JPanel content1 = new JPanel(new GridLayout(trains.size(), 6));

        for (int i = 0; i < trains.size(); i++) {
            JLabel tempNum = new JLabel(trains.get(i).getTrainNum(), SwingConstants.CENTER);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            JLabel tempDate;
            String trainDate = df.format(trains.get(i).getTrainDate());
            if (df.format(new Date()).compareTo(trainDate) < 0) {
                tempDate = new JLabel(trainDate, SwingConstants.CENTER);
            } else
                tempDate = new JLabel("此班已发出", SwingConstants.CENTER);
            JLabel tempDeparture = new JLabel(trains.get(i).getTrainDeparture(), SwingConstants.CENTER);
            JLabel tempBourn = new JLabel(trains.get(i).getTrainBourn(), SwingConstants.CENTER);
            JLabel tempRemain = new JLabel(trains.get(i).getTrainRemain(), SwingConstants.CENTER);
            JLabel tempPrice = new JLabel(String.valueOf(trains.get(i).getTrainPrice()), SwingConstants.CENTER);

            content1.add(tempNum);
            content1.add(tempDate);
            content1.add(tempDeparture);
            content1.add(tempBourn);
            content1.add(tempRemain);
            content1.add(tempPrice);
        }

        JScrollPane content2 = new JScrollPane(content1);

        c.add(tick);
        c.add(title);
        c.add(content2);

    }

//    public TicketViewAll(String num) {
//        Container c = this.getContentPane();
//        c.setLayout(new GridLayout(2, 1));
//        JPanel title = new JPanel(new GridLayout(1, 8));
//        JLabel Num = new JLabel("班次", SwingConstants.CENTER);
//        JLabel Time = new JLabel("发车时间", SwingConstants.CENTER);
//        JLabel Start = new JLabel("起点站", SwingConstants.CENTER);
//        JLabel End = new JLabel("终点站", SwingConstants.CENTER);
//        JLabel During = new JLabel("行车时间", SwingConstants.CENTER);
//        JLabel Max = new JLabel("额定载量", SwingConstants.CENTER);
//        JLabel Person = new JLabel("已定票人数", SwingConstants.CENTER);
//
//        title.add(Num);
//        title.add(Time);
//        title.add(Start);
//        title.add(End);
//        title.add(During);
//        title.add(Max);
//        title.add(Person);
//
//        int cnt = 0;
//
//        for (int i = 0; i < TrainTicket.TrainList.size(); i++) {
//            if (TrainTicket.TrainList.get(i).getNum().equals(num) || TrainTicket.TrainList.get(i).getEnd().equals(num))
//                cnt++;
//        }
//        JPanel content1 = new JPanel(new GridLayout(cnt, 7));
//
//        for (int i = 0; i < TrainTicket.TrainList.size(); i++) {
//            if (TrainTicket.TrainList.get(i).getNum().equals(num) || TrainTicket.TrainList.get(i).getEnd().equals(num)) {
//                JLabel Temp1 = new JLabel(TrainTicket.TrainList.get(i).getNum(), SwingConstants.CENTER);
//                SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");//设置日期格式
//                JLabel Temp2;
//                if (df.format(new Date()).compareTo(TrainTicket.TrainList.get(i).getTime()) < 0) {
//                    Temp2 = new JLabel(TrainTicket.TrainList.get(i).getTime(), SwingConstants.CENTER);
//                } else
//                    Temp2 = new JLabel("此班已发出", SwingConstants.CENTER);
//                JLabel Temp3 = new JLabel(TrainTicket.TrainList.get(i).getStart(), SwingConstants.CENTER);
//                JLabel Temp4 = new JLabel(TrainTicket.TrainList.get(i).getEnd(), SwingConstants.CENTER);
//                JLabel Temp5 = new JLabel(TrainTicket.TrainList.get(i).getDuring(), SwingConstants.CENTER);
//                JLabel Temp6 = new JLabel(TrainTicket.TrainList.get(i).getMax(), SwingConstants.CENTER);
//                JLabel Temp7 = new JLabel(TrainTicket.TrainList.get(i).getPerson() + "", SwingConstants.CENTER);
//                JLabel Temp8;
//                if (df.format(new Date()).compareTo(TrainTicket.TrainList.get(i).getTime()) < 0
//                        && (Integer.valueOf(TrainTicket.TrainList.get(i).getMax()).intValue() >
//                        Integer.valueOf(TrainTicket.TrainList.get(i).getPerson())))
//                    Temp8 = new JLabel("是", SwingConstants.CENTER);
//                else
//                    Temp8 = new JLabel("否", SwingConstants.CENTER);
//                content1.add(Temp1);
//                content1.add(Temp2);
//                content1.add(Temp3);
//                content1.add(Temp4);
//                content1.add(Temp5);
//                content1.add(Temp6);
//                content1.add(Temp7);
//                content1.add(Temp8);
//            }
//        }
//
//        JScrollPane content2 = new JScrollPane(content1);
//        c.add(title);
//        c.add(content2);
//
//        this.setBounds(200, 200, 800, 400);
//        this.setVisible(true);
//        this.setTitle("浏览班次信息");
//    }


}