package com.itvdn.webservices.ex_005_DOM_with_object;

import com.itvdn.webservices.ex_005_DOM_with_object.entity.Book;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        BookHelper bookHelper = new BookHelper();

        Book newBook = new Book();
        newBook.setTitle("Dima Khodosevich");
        newBook.setAuthor("Khodosevich");
        newBook.setIsdn(777L);
        newBook.setId("777");
        bookHelper.addBook(newBook);
        bookHelper.addBook(newBook);

        List<Book> list = bookHelper.getAll();

        for (Book book: list){
            System.out.println(book);
        }

    }
}
