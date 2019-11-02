package com.power.hackathon2019.model;

import com.google.android.gms.maps.model.LatLng;

public class Marker
{
    private LatLng latLng;
    private String markerName;
    private MarkerStatus markerStatus;


    public Marker(String markerName, LatLng latLng)
    {
        this.markerName = markerName;
        this.latLng = latLng;
        this.markerStatus = MarkerStatus.SNOW_COVERED;
    }

    public LatLng getLatLng()
    {
        return latLng;
    }

    public String getMarkerName()
    {
        return markerName;
    }

    public MarkerStatus getMarkerStatus()
    {
        return markerStatus;
    }
}
