package com.itvdn.webservices.ex_003_SAX_with_object_2;

import com.itvdn.webservices.ex_003_SAX_with_object_2.entity.Country;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class CountryHandler extends DefaultHandler {
    private String currentQName;
    private List<Country> countryList;
    private Country country;
    private String currentAttribute;

    public CountryHandler() {
        countryList = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentQName = qName;

        if (attributes.getLength() > 0) {
            currentAttribute = attributes.getValue(0);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        switch (currentQName) {
            case "country": {
                country = new Country();
                country.setCountryCode(currentAttribute);
                break;
            }
            case "name": {
                country.setName(new String(ch, start, length));
                break;
            }
            case "capital": {
                country.setCapital(new String(ch, start, length));
                break;
            }
            case "population": {
                country.setPopulation(Integer.parseInt(new String(ch, start, length)));
                break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentQName = "";

        if (qName.equals("country")) {
            countryList.add(country);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        country = null;
    }

    public List<Country> getCountries() {
        return countryList;
    }
}
