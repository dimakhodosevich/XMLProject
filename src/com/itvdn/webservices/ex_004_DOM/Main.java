package com.itvdn.webservices.ex_004_DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);

        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse("E:\\XMLProject\\src\\com\\itvdn\\webservices\\ex_004_DOM\\books.xml");

        Element root = document.getDocumentElement();

        System.out.println(root.getNodeName());
        System.out.println(root.getNodeType());

        NodeList list = root.getElementsByTagName("book");

        for(int i = 0; i<list.getLength(); i++){
            System.out.println("-------------------------------------------");
            Node node = list.item(i);
            System.out.println(root.getElementsByTagName("title").item(i).getFirstChild().getTextContent());
            System.out.println(root.getElementsByTagName("author").item(i).getFirstChild().getTextContent());
            System.out.println(node.getAttributes().item(0).getNodeValue());
            System.out.println(node.getAttributes().item(1).getNodeValue());
        }

    }
}
