package com.power.hackathon2019.model;

import com.google.android.gms.maps.model.LatLng;

public class Marker
{
    private LatLng latlng;
    private String markerName = "Fire Hydrant";

    public Marker (String markerName, LatLng latlng)
    {
        this.markerName = markerName;
        this.latlng = latlng;
    }

    public Marker (LatLng latlng)
    {
        this.latlng = latlng;
    }

    public Marker (double lat, double lng)
    {
        this.latlng = new LatLng(lat, lng);
    }

    public LatLng getLatlng()
    {
        return latlng;
    }

    public String getMarkerName()
    {
        return markerName;
    }
}
