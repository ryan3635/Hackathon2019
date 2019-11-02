package com.power.hackathon2019.controller;

import com.power.hackathon2019.model.Street;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;

public class StreetBuilderTest
{
    @Test
    public void test()
    {
        Collection<Street> streets =
                StreetBuilder.createStreetsFromCSV("../app/resources/streetnames.csv");

        Assert.assertThat(streets.size(), is(274));
    }

}