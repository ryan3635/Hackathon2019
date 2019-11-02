package com.power.hackathon2019.controller;

import com.google.android.gms.maps.model.LatLng;
import com.power.hackathon2019.model.City;

import java.io.Serializable;

public class CityBuilder implements Serializable
{
    private final String streetNames = "../app/resources/streetnames.csv";

    public CityBuilder()
    {
    }

    public City buildCity(LatLng latLng)
    {
        City city = new City(latLng);
        city.initalizeCity(streetNames);
        return city;
    }


}
