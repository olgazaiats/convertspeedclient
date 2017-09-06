package com.client;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.mappers.CsvWithHeaderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.testng.Assert;


@RunWith(JUnitParamsRunner.class)
public class ConvertSpeedsDDTest {

    private JAXBClient jaxbClient = new JAXBClient();
    private ConvertSpeedsSoap convertClient = jaxbClient.client;

    @Test
    @FileParameters(value="src/test/resources/convert_speeds_test_data.csv", mapper=CsvWithHeaderMapper.class)
    public void convertSpeedsWithDDTest(double speed, String speedUnitFrom, String speedUnitTo, double expRes){
        double actRes = convertClient.convertSpeed(speed, SpeedUnit.valueOf(speedUnitFrom), SpeedUnit.valueOf(speedUnitTo));
        Assert.assertEquals(expRes, actRes);
    }

}
