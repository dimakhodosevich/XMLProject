package com.itvdn.webservices.ex_005_DOM_with_object;

import com.itvdn.webservices.ex_005_DOM_with_object.entity.Book;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookHelper {
    private Document document;

    public BookHelper() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);

        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        document = documentBuilder.parse(
                "E:\\XMLProject\\src\\com\\itvdn\\webservices\\ex_005_DOM_with_object\\book.xml");

    }

    public List<Book> getAll(){
       List<Book> books =new ArrayList<>();
        Element root = document.getDocumentElement();
        NodeList list = root.getElementsByTagName("book");

        for (int i = 0; i < list.getLength(); i++) {
            Book book  = new Book();
            String title = root.getElementsByTagName("title").item(i).getFirstChild().getTextContent();
            String author = root.getElementsByTagName("author").item(i).getFirstChild().getTextContent();
            String id = list.item(i).getAttributes().item(0).getNodeValue();
            long isbn = Long.parseLong(list.item(i).getAttributes().item(1).getNodeValue());
            book.setTitle(title);
            book.setAuthor(author);
            book.setId(id);
            book.setIsdn(isbn);
            books.add(book);
        }
        return books;
    }

    public void addBook(Book newBook) throws FileNotFoundException, TransformerException {
        Element root= document.getDocumentElement();

        Element book = document.createElement("book");
        Element author = document.createElement("author");
        Element title = document.createElement("title");

        book.setAttribute("id", newBook.getId());
        book.setAttribute("isbn", String.valueOf(newBook.getIsdn()));
        author.setTextContent(newBook.getAuthor());
        title.setTextContent(newBook.getTitle());

        book.appendChild(title);
        book.appendChild(author);

        root.appendChild(book);

        DOMSource source = new DOMSource(document);
        String file = "E:\\XMLProject\\src\\com\\itvdn\\webservices\\ex_005_DOM_with_object\\book.xml";
        StreamResult result = new StreamResult(new FileOutputStream(file));

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(source, result);
    }

}
