package com.itvdn.webservices.ex_003_SAX_with_object_2;

import com.itvdn.webservices.ex_003_SAX_with_object_2.entity.Country;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        CountryHandler countryHandler = new CountryHandler();

        File file = new File("E:\\XMLProject\\src\\com\\itvdn\\webservices" +
                "\\ex_003_SAX_with_object_2\\xml\\country.xml");

        if(file.exists()){
            parser.parse(file, countryHandler);

            List<Country> countries = countryHandler.getCountries();

            for (Country country: countries){
                System.out.println(country);
            }
        }

    }
}
