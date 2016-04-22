package htp.personaltravelapplication.bean;

import java.io.Serializable;

/**
 * Created by phuchtgc60244 on 4/20/2016.
 */
public class MapObject implements Serializable {
    private String address;
    private double Lat;
    private double Lng;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLat() {
        return Lat;
    }

    public void setLat(double lat) {
        Lat = lat;
    }

    public double getLng() {
        return Lng;
    }

    public void setLng(double lng) {
        Lng = lng;
    }

    public MapObject(String address, double lat, double lng) {
        this.address = address;
        Lat = lat;
        Lng = lng;
    }
}
