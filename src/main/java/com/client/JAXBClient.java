package com.client;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

import com.utils.JaxWsHandlerResolver;


public class JAXBClient {
    public ConvertSpeedsSoap client;

    public JAXBClient(){
        try {

            URL url = new URL("http://www.webservicex.net/ConvertSpeed.asmx?WSDL");

            //1st argument service URI, refer to wsdl document above
            //2nd argument is service name, refer to wsdl document above
            QName qname = new QName("http://www.webserviceX.NET/", "ConvertSpeeds");

            Service service = Service.create(url, qname);

            service.setHandlerResolver(new JaxWsHandlerResolver());

            client = service.getPort(ConvertSpeedsSoap.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
