package com.itvdn.webservices.ex_005_DOM_with_object;

import com.itvdn.webservices.ex_005_DOM_with_object.entity.Book;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        BookHelper bookHelper = new BookHelper();



        List<Book> list = bookHelper.getAll();

        for (Book book: list){
            System.out.println(book);
        }

    }
}
