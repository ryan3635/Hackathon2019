package com.power.hackathon2019.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

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
        City mountPearl = cityBuilder.buildCity(new LatLng(47.519467, -52.800441));

        mMap = googleMap;

        // Add a marker in Mount Pearl and move the camera
        LatLng marker1 = new LatLng(47.520353, -52.806221);
        googleMap.addMarker(new MarkerOptions().position(marker1)
                .title("Fire Hydrant")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hydrant25)));

        //mMap.addMarker(new MarkerOptions().position(mountPearl).title("Marker in Mount Pearl"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mountPearl.getLatLng()));
        mMap.setMinZoomPreference(13.5f);
        mMap.setMaxZoomPreference(22.0f);
    }
}
