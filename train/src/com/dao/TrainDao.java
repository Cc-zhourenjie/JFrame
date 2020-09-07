package com.dao;

import com.pojo.Train;

import java.util.List;

/**
 * 用户的数据库操作接口
 */
public interface TrainDao {

    /**
     * 获取全部车次信息
     *
     * @return
     */
    List<Train> getTrains();
}
