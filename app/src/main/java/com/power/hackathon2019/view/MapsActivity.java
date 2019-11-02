package com.power.hackathon2019.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.power.hackathon2019.R;
import com.power.hackathon2019.controller.CityBuilder;
import com.power.hackathon2019.model.City;
import com.power.hackathon2019.model.Hydrant;
import com.power.hackathon2019.model.Marker;
import com.power.hackathon2019.model.MarkerStatus;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private CityBuilder cityBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        this.cityBuilder = new CityBuilder();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;

        City mountPearl = cityBuilder.buildCity(new LatLng(47.519467, -52.800441));

        moveCamera(mountPearl);

        displayMarkers(googleMap, mountPearl);
    }

    private void moveCamera(City mountPearl)
    {
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mountPearl.getLatLng()));
        mMap.setMinZoomPreference(12.0f);
        mMap.setMaxZoomPreference(22.0f);
    }

    private void displayMarkers(GoogleMap googleMap, City mountPearl)
    {
        for (Marker marker : mountPearl.getAllMarkers())
        {
            googleMap.addMarker(new MarkerOptions().position(marker.getLatLng())
                    .title(marker.getMarkerName())
                    .icon(BitmapDescriptorFactory.fromResource(getBitmap(marker))));
        }
    }

    private int getBitmap(Marker marker)
    {
        MarkerStatus status = marker.getMarkerStatus();

        if (Hydrant.class.equals(marker.getClass()))
        {
            if (MarkerStatus.CLEAR.equals(status))
            {
                return R.drawable.hydrant25;
            }
            else if (MarkerStatus.SNOW_COVERED.equals(status))
            {
                return R.drawable.hydrant25snowy;
            }
            else if (MarkerStatus.CLEAR_HIGHLIGHTED.equals(status))
            {
                return R.drawable.hydrant25highlighted;
            }
        }
        return R.drawable.hydrant25;
    }
}
