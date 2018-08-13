package com.example.codingtest.codingapplication.domainobject;

import com.google.gson.annotations.SerializedName;

/**
 * LocationMapData is a domain object to hold latitude and longitude details
 */
public class LocationMapData {
    @SerializedName("latitude")
    private float latitude;

    @SerializedName("longitude")
    private float longitude;

    public LocationMapData(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
