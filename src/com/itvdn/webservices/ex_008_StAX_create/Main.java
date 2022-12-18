package com.itvdn.webservices.ex_008_StAX_create;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, XMLStreamException {
        XMLOutputFactory factory = XMLOutputFactory.newFactory();
        XMLStreamWriter writer = factory.createXMLStreamWriter(
                new FileWriter("E:\\XMLProject\\src\\com\\itvdn\\webservices\\ex_008_StAX_create\\output.xml"));

        writer.writeStartDocument();
        writer.writeStartElement("books");
        writer.writeStartElement("book");
        writer.writeAttribute("id", "035");
        writer.writeAttribute("isdn", "3232");

        writer.writeStartElement("title");
        writer.writeCharacters("Java Core");
        writer.writeEndElement();

        writer.writeStartElement("author");
        writer.writeCharacters("Blox");
        writer.writeEndElement();

        writer.writeEndElement();
        writer.writeEndElement();
        writer.writeEndDocument();

        writer.flush();
        writer.close();


    }
}
