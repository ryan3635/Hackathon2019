package com.power.hackathon2019.controller;

import org.junit.Test;

public class CSVReaderTest
{
    @Test
    public void test()
    {
        //URL url = getClass().getResource("streetnames.csv");
        //File file = new File(url.getPath());
        CSVReader.readCSV("../app/resources/streetnames.csv");
    }

}