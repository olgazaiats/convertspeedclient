package com.utils;

import com.client.ConvertSpeedsSoap;
import com.client.SpeedUnit;

import javax.xml.ws.WebServiceRef;

public class JAXBAnnotClient {

    @WebServiceRef(wsdlLocation =
            "http://www.webservicex.net/ConvertSpeed.asmx?WSDL")
    private static ConvertSpeedsSoap convertSpeedsSoap;

  public static void main(String[] args) {
      System.out.println(convertSpeedsSoap.convertSpeed(0, SpeedUnit.KILOMETERS_PERHOUR, SpeedUnit.CENTIMETERS_PERSECOND));
  }
}
