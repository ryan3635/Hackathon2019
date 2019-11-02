package com.power.hackathon2019.controller;

import org.junit.Test;

import java.io.File;
import java.net.URL;

public class CSVReaderTest
{
    @Test
    public void test()
    {
        URL url = getClass().getResource("streetnamnes.csv");
        File file = new File(url.getPath());
        CSVReader.readCSV("../controller/streetnames.csv");
    }

}