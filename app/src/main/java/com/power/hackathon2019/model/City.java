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

    public Collection<Marker> getAllMarkers()
    {
        Collection<Marker> allMarkers = new ArrayList<>();
        for (Street street : this.streets)
        {
            allMarkers.addAll(street.getMarkers());
        }
        return allMarkers;
    }

    public void initalizeCity()
    {
        this.initializeStreets(StreetBuilder.createStreetsFromCSV());
    }

    private void initializeStreets(Collection<Street> streets)
    {
        this.streets = new ArrayList<>(streets);
    }
}
