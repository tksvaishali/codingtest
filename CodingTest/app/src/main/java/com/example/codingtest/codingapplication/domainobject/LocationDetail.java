package com.example.codingtest.codingapplication.domainobject;

import com.google.gson.annotations.SerializedName;

/**
 * LocationDetail is a domain object to hold location data from webservice
 */
public class LocationDetail {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("fromcentral")
    private FromCentralLocationDetails fromCentral;

    @SerializedName("location")
    private LocationMapData location;

    public LocationDetail(int id, String name, FromCentralLocationDetails fromCentral, LocationMapData location) {
        this.id = id;
        this.name = name;
        this.fromCentral = fromCentral;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FromCentralLocationDetails getFromCentral() {
        return fromCentral;
    }

    public void setFromCentral(FromCentralLocationDetails fromCentral) {
        this.fromCentral = fromCentral;
    }

    public LocationMapData getLocation() {
        return location;
    }

    public void setLocation(LocationMapData location) {
        this.location = location;
    }
}
