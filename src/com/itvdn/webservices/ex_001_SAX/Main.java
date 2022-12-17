package com.itvdn.webservices.ex_001_SAX;

import org.xml.sax.HandlerBase;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser parser = saxParserFactory.newSAXParser();

        File file = new File("E:\\XMLProject\\src\\com\\itvdn" +
                "\\jdbcandhibernate\\ex_002_formatting_and_validation_XML\\country.xml");

        if(file.exists()){
            parser.parse(file, new MyHandler());
        }
    }
}
