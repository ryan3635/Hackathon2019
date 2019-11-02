package com.power.hackathon2019.controller;

import com.google.android.gms.maps.model.LatLng;
import com.power.hackathon2019.model.City;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class CityBuilderTest
{
    @Test
    public void test()
    {
        CityBuilder cityBuilder = new CityBuilder();
        City city = cityBuilder.buildCity(new LatLng(0,0));
        Assert.assertThat(city.getStreets().size(), is(274));
    }

}