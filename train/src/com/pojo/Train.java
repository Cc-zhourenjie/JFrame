package com.pojo;


import java.util.Date;

public class Train {

    private String id;

    private String trainNum;

    private String trainDeparture;

    private String trainBourn;

    private Date trainDate;

    private Double trainPrice;

    private String trainRemain;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(String trainNum) {
        this.trainNum = trainNum;
    }

    public String getTrainDeparture() {
        return trainDeparture;
    }

    public void setTrainDeparture(String trainDeparture) {
        this.trainDeparture = trainDeparture;
    }

    public String getTrainBourn() {
        return trainBourn;
    }

    public void setTrainBourn(String trainBourn) {
        this.trainBourn = trainBourn;
    }

    public Date getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }

    public Double getTrainPrice() {
        return trainPrice;
    }

    public void setTrainPrice(Double trainPrice) {
        this.trainPrice = trainPrice;
    }

    public String getTrainRemain() {
        return trainRemain;
    }

    public void setTrainRemain(String trainRemain) {
        this.trainRemain = trainRemain;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id='" + id + '\'' +
                ", trainNum='" + trainNum + '\'' +
                ", trainDeparture='" + trainDeparture + '\'' +
                ", trainBourn='" + trainBourn + '\'' +
                ", trainDate=" + trainDate +
                ", trainPrice=" + trainPrice +
                ", trainRemain='" + trainRemain + '\'' +
                '}';
    }
}
