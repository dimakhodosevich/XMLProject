package com.itvdn.webservices.ex_009_x_path;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.xpath.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws XPathExpressionException, FileNotFoundException {
        XPathFactory factory = XPathFactory.newInstance();
        XPath xPath = factory.newXPath();
        XPathExpression xPathExpression = xPath.compile("//employee/@id");

        File xml =
                new File("E:\\XMLProject\\src\\com\\itvdn\\webservices\\ex_009_x_path\\employees.xml");

        InputSource source = new InputSource(new FileInputStream(xml));

        Object result = xPathExpression.evaluate(source, XPathConstants.NODESET);

        NodeList list = (NodeList) result;

        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            System.out.println(node.getNodeName());
            System.out.println(node.getFirstChild().getNodeValue());
        }

    }
}
