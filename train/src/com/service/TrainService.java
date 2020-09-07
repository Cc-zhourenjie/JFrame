package com.service;

import com.pojo.Train;

import java.util.List;

/**
 * 车次服务接口
 */
public interface TrainService {


    /**
     * 获取全部车次
     *
     * @return
     */
    List<Train> getTrains();


}
