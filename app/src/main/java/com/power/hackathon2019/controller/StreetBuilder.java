package com.power.hackathon2019.controller;

import com.google.android.gms.maps.model.LatLng;
import com.power.hackathon2019.model.Street;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class StreetBuilder
{
    public static Collection<Street> createStreetsFromCSV(String fileName)
    {
        Collection<Street> streets = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try
        {
            br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null)
            {
                String[] streetLine = line.split(cvsSplitBy);

                String streetName = streetLine[0];
                Double streetLat =  Double.parseDouble(streetLine[1]);
                Double streetLng = Double.parseDouble(streetLine[2]);

                streets.add(new Street(streetName, new LatLng(streetLat, streetLng)));
            }

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

        return streets;
    }
}
