package com.power.hackathon2019.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class City
{
    private ArrayList<Road> roads;
    private LatLng latLng;

    public City()
    {

    }

    public City(LatLng latLng)
    {
        this.latLng = latLng;
    }

    public void setLatLng(LatLng latLng)
    {
        this.latLng = latLng;
    }

    public LatLng getLatLng()
    {
        return latLng;
    }

    public ArrayList<Road> getRoads()
    {
        return this.roads;
    }

    public void initializeRoads()
    {
        this.roads = new ArrayList<>();
        //create roads
    }
}
