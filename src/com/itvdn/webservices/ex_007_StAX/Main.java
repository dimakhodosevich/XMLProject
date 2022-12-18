package com.itvdn.webservices.ex_007_StAX;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();

        Reader reader = new FileReader("E:\\XMLProject\\src\\com\\itvdn" +
                "\\webservices\\ex_007_StAX\\books.xml");

        XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(reader);

        while(xmlStreamReader.hasNext()){

            switch (xmlStreamReader.next()){

                case XMLStreamReader.START_ELEMENT:
                {
                    String element = xmlStreamReader.getName().toString();
                    System.out.println(element);
                    switch (element){
                        case "book":{

                            for (int i = 0; i < xmlStreamReader.getAttributeCount(); i++) {
                                String attributeName = xmlStreamReader.getAttributeLocalName(i);
                                String attributeValue = xmlStreamReader.getAttributeValue(i);
                                System.out.println(attributeName + " " + attributeValue);
                            }
                        }
                        break;
                        case "title":{
                            System.out.println(xmlStreamReader.getElementText());
                            break;
                        }
                        case "author":{
                            System.out.println(xmlStreamReader.getElementText());
                            break;
                        }
                    }
                    break;
                }
                case XMLStreamConstants.END_ELEMENT:{

                    String endElement = xmlStreamReader.getName().toString();
                    System.out.println(endElement);
                    break;
                }

            }
        }

    }
}
