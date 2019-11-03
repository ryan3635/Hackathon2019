package com.power.hackathon2019.view;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import com.power.hackathon2019.R;
import android.widget.Toast;


public class MainActivity extends Activity {

    Button reportButton;
    TextView hydrantInfo;
    RadioGroup radioGroup;
    RadioButton clear;
    RadioButton needsClearing;
    boolean cleared;
    //initialize map

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reportButton = findViewById(R.id.button);
        hydrantInfo = findViewById(R.id.hydrantInfo);
        radioGroup = findViewById(R.id.radioGroup);
        clear = findViewById(R.id.radioButton2);
        needsClearing = findViewById(R.id.radioButton);
        //initialize map

        //~~~~~~UPDATING HYDRANT STATUS TEXT~~~~~~~~~
        //if (hydrant is selected on map)
            //hydrantInfo = *hydrant name* + "\n" + "Coordinates: " + LatLng
            // + "\n" + *hydrant status? i.e. Clear, Needs Clearing*



        reportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cleared == true)
                    Toast.makeText(getApplicationContext(), R.string.youCleared, Toast.LENGTH_SHORT).show();
                else if (cleared == false)
                    Toast.makeText(getApplicationContext(), R.string.needsClearing, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onRadioButtonClicked(View view) {
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
}
