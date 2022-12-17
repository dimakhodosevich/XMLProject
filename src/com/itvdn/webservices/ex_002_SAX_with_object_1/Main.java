package com.itvdn.webservices.ex_002_SAX_with_object_1;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SandwichHandler sandwichHandler = new SandwichHandler();

        File file = new File("E:\\XMLProject\\src\\com\\itvdn\\webservices\\ex_002_SAX_with_object_1\\sandwich.xml");

        if(file.exists()){

            parser.parse(file,sandwichHandler);

            Sandwich sandwich = sandwichHandler.getSandwich();

            System.out.println(sandwich);
        }
    }
}
