package com.power.hackathon2019.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class Road
{
    private LatLng latLng;
    private ArrayList<Marker> markers;

    public Road(LatLng latLng)
    {
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
