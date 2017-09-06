package com.client;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.ws.soap.SOAPFaultException;

import static com.client.SpeedUnit.CENTIMETERS_PERSECOND;
import static com.client.SpeedUnit.KILOMETERS_PERHOUR;

public class ConvertSpeedsTest {

    private JAXBClient jaxbClient = new JAXBClient();
    private ConvertSpeedsSoap convertClient = jaxbClient.client;

    @Test
    public void convertSpeedZeroTest(){
        double convertsSpeed1 = convertClient.convertSpeed(0, KILOMETERS_PERHOUR, CENTIMETERS_PERSECOND);
        Assert.assertEquals(0, convertsSpeed1, 1e-15);
    }

    @Test
    public void convertSpeedMaxValueTest(){
        double convertsSpeed2 = convertClient.convertSpeed(Double.MAX_VALUE, KILOMETERS_PERHOUR, KILOMETERS_PERHOUR);
        Assert.assertEquals(Double.MAX_VALUE, convertsSpeed2);
    }

    @Test
    public void convertSpeedMaxInfiniteTest(){
        double convertsSpeed3 = convertClient.convertSpeed(Double.MAX_VALUE, KILOMETERS_PERHOUR, CENTIMETERS_PERSECOND);
        Assert.assertTrue(Double.isInfinite(convertsSpeed3));
    }

    @Test
    public void convertSpeedIsNanTest(){
        double convertsSpeed4 = convertClient.convertSpeed(Double.NaN, KILOMETERS_PERHOUR, CENTIMETERS_PERSECOND);
        Assert.assertTrue(Double.isNaN(convertsSpeed4));
    }

    @Test
    public void convertSpeedPositiveInfinityTest(){
        double convertsSpeed5 = convertClient.convertSpeed(Double.POSITIVE_INFINITY, KILOMETERS_PERHOUR, CENTIMETERS_PERSECOND);
        Assert.assertTrue(Double.isInfinite(convertsSpeed5));
    }

    //Negative test
    @Test(expectedExceptions = SOAPFaultException.class)
    public void convertSpeedInvalidUnitTest(){
        try{
            convertClient.convertSpeed(999, KILOMETERS_PERHOUR, SpeedUnit.TEST);
        }catch(SOAPFaultException e){
            Assert.assertTrue(e.getMessage().contains("'test' is not a valid value for SpeedUnit"));
            throw e;
        }
    }

}
