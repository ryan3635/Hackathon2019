package com.power.hackathon2019.model;

import com.google.android.gms.maps.model.LatLng;
import com.power.hackathon2019.controller.CSVReader;

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
        this.initializeStreets(CSVReader.readCSV(file));
    }

    private void initializeStreets(Collection<String> streetNames)
    {
        this.streets = new ArrayList<>();
        for (String streetName : streetNames)
        {
            this.streets.add(new Street(streetName));
        }
    }
}
