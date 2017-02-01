package karthik.com.caterit.Models;

import java.io.Serializable;

/**
 * Created by user on 17/01/2017.
 */

public class Location implements Serializable {

    Double latitude = 0.0,longitude = 0.0;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
