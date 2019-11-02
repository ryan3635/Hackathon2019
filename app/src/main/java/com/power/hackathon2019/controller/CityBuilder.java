package com.power.hackathon2019.controller;

import com.google.android.gms.maps.model.LatLng;
import com.power.hackathon2019.model.City;

import java.io.Serializable;

public class CityBuilder implements Serializable
{
    private City city;
    private final String streetName = "streetnames.csv";

    public CityBuilder()
    {
        this.city = new City();
    }

    public void initalizeCity(double lat, double lng)
    {
        LatLng latLng = new LatLng(lat, lng);
        city.setLatLng(latLng);
        city.initializeRoads();
    }
}
