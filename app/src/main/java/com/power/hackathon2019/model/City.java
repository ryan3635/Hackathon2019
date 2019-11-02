package com.power.hackathon2019.model;

import com.google.android.gms.maps.model.LatLng;
import com.power.hackathon2019.controller.StreetBuilder;

import java.util.ArrayList;
import java.util.Collection;

public class City
{
    private ArrayList<Street> streets;
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

    public ArrayList<Street> getStreets()
    {
        return this.streets;
    }

    public void initalizeCity(String file)
    {
        this.initializeStreets(StreetBuilder.createStreetsFromCSV(file));
    }

    private void initializeStreets(Collection<Street> streets)
    {
        this.streets = new ArrayList<>(streets);
    }
}
