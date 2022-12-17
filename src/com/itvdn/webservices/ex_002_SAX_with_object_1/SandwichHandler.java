package com.itvdn.webservices.ex_002_SAX_with_object_1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SandwichHandler extends DefaultHandler {
    private Sandwich sandwich;
    private String currentQName;

    public SandwichHandler() {
        sandwich = new Sandwich();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentQName = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentQName = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        switch (currentQName) {
            case "name":
                sandwich.setName(new String(ch, start, length));
                break;
            case "ingridient":
                sandwich.addIngridient(new String(ch, start, length));
                break;
            case "cost":
                String cost = new String(ch, start, length);
                Double d = Double.parseDouble(cost);
                sandwich.setCost(d);
                break;
            case "weight":
                String weight = new String(ch, start, length);
                Double w = Double.parseDouble(weight);
                sandwich.setWeight(w);
                break;
        }
    }

    public Sandwich getSandwich(){
        return sandwich;
    }

}
