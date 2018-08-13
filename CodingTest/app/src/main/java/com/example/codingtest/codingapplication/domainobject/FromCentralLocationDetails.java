package com.example.codingtest.codingapplication.domainobject;

import com.google.gson.annotations.SerializedName;

/**
 * FromCentralLocationDetails is a domain object to hold details of car and train distance from central location
 */
public class FromCentralLocationDetails {

    @SerializedName("car")
    private String car;

    @SerializedName("train")
    private String train;

    public FromCentralLocationDetails(String car, String train) {
        this.car = car;
        this.train = train;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getTrain() {
        return train;
    }

    public void setTrain(String train) {
        this.train = train;
    }
}
