package com.dao.impl;

import com.dao.TrainDao;
import com.pojo.Train;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 车次信息数据库层
 */
public class TrainDaoImpl implements TrainDao {

    /**
     * 获取全部车次信息
     *
     * @return
     */
    @Override
    public List<Train> getTrains() {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        List<Train> list = new ArrayList<>();
        Train resultDO = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            conn = DBUtil.getConnection();
            StringBuilder sql = new StringBuilder("select * from train");

            //输入条件不为空
//            if (!StringUtils.isNullOrEmpty(value)) {
//                sql.append(" and " + name + "  like  " + "'%" + value + "%'");
//            }

            stmt = conn.prepareStatement(sql.toString());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String trainNum = rs.getString("train_num");
                String trainDeparture = rs.getString("train_departure");
                String trainBourn = rs.getString("train_bourn");
                String date = rs.getString("train_date");
                float trainPrice = rs.getFloat("train_price");
                String trainRemain = rs.getString("train_remain");

                resultDO = new Train();
                //组合数据
                resultDO.setId(id);
                resultDO.setTrainNum(trainNum);
                resultDO.setTrainDeparture(trainDeparture);
                resultDO.setTrainBourn(trainBourn);
                resultDO.setTrainDate(simpleDateFormat.parse(date));
                resultDO.setTrainPrice((double) trainPrice);
                resultDO.setTrainRemain(trainRemain);

                list.add(resultDO);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, conn, stmt);
        }
        return list;
    }
}
