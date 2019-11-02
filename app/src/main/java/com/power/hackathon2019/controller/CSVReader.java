package com.power.hackathon2019.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CSVReader //../app/resouirces/streetnames.csv
{
    public static Collection<String> readCSV(String fileName)
    {
        Collection<String> strings = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try
        {
            br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null)
            {
                String[] streets = line.split(cvsSplitBy);

                Collections.addAll(strings, streets);
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

        return strings;
    }
}
