package com.itvdn.webservices.ex_myproject;

import com.itvdn.webservices.ex_myproject.entity.Student;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        StudentHandle studentHandle = new StudentHandle();

        File file = new File("E:\\XMLProject\\src\\com\\itvdn" +
                "\\webservices\\ex_myproject\\xml\\student.xml");

        if (file.exists()){
            parser.parse(file, studentHandle);

            List<Student> students = studentHandle.getStudents();
            System.out.println(students);
        }

    }
}
