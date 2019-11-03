package com.power.hackathon2019.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.power.hackathon2019.R;
import com.power.hackathon2019.controller.CityBuilder;
import com.power.hackathon2019.model.City;
import com.power.hackathon2019.model.Hydrant;
import com.power.hackathon2019.model.Marker;
import com.power.hackathon2019.model.MarkerStatus;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback
{
    private boolean cleared;
    private GoogleMap mMap;
    private CityBuilder cityBuilder;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button reportButton = findViewById(R.id.button);
        TextView hydrantInfo = findViewById(R.id.hydrantInfo);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        RadioButton clear = findViewById(R.id.radioButton2);
        RadioButton needsClearing = findViewById(R.id.radioButton);

        reportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cleared == true)
                    Toast.makeText(getApplicationContext(), R.string.youCleared, Toast.LENGTH_SHORT).show();
                else if (cleared == false)
                    Toast.makeText(getApplicationContext(), R.string.needsClearing, Toast.LENGTH_SHORT).show();
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        this.cityBuilder = new CityBuilder();
    }

    public void onRadioButtonClicked(View view)
    {
        boolean check = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton:
                if (check)
                    cleared = false;
                    break;
            case R.id.radioButton2:
                if (check)
                    cleared = true;
                    break;
        }
    }

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
