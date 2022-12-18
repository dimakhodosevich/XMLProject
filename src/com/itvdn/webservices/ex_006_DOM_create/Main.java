package com.itvdn.webservices.ex_006_DOM_create;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, FileNotFoundException, TransformerException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);


        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        Document document = documentBuilder.newDocument();
        Element root = document.createElement("books");

        Element book = document.createElement("book");
        Element title = document.createElement("title");
        Element author = document.createElement("author");

        book.setAttribute("id", "04");
        book.setAttribute("isbn", "333555");
        title.setTextContent("Lukomore");
        author.setTextContent("Alexandr Pushkin");

        book.appendChild(title);
        book.appendChild(author);

        root.appendChild(book);
        document.appendChild(root);

        DOMSource source = new DOMSource(document);
        String fileName = "E:\\XMLProject\\src\\com\\itvdn\\webservices\\ex_006_DOM_create\\books_edit.xml";

        StreamResult result = new StreamResult(new FileOutputStream(fileName));

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(source, result);

    }
}
