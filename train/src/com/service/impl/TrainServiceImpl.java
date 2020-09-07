package com.service.impl;

import com.dao.TrainDao;
import com.dao.impl.TrainDaoImpl;
import com.pojo.Train;
import com.service.TrainService;

import java.util.List;

/**
 * 车次服务层
 */
public class TrainServiceImpl implements TrainService {

    private TrainDao trainDao = new TrainDaoImpl();

    /**
     * 查询全部车次
     *
     * @return
     */
    @Override
    public List<Train> getTrains() {
        return trainDao.getTrains();
    }
}
