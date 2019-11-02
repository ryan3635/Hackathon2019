package com.power.hackathon2019.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class Street
{
    private LatLng latLng;
    private ArrayList<Marker> markers;
    private String streetName;

    public Street(String streetName)
    {
        this.streetName = streetName;
    }

    public Street(String streetName, LatLng latLng)
    {
        this.streetName = streetName;
        this.latLng = latLng;
        this.markers = new ArrayList<>();
    }

    public LatLng getLatLng()
    {
        return latLng;
    }

    public ArrayList<Marker> getMarkers()
    {
        return markers;
    }

    public void addMarker(Marker marker)
    {
        this.markers.add(marker);
    }

    public void setMarkers(ArrayList<Marker> markers)
    {
        this.markers = markers;
    }
}
