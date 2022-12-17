package com.itvdn.webservices.ex_myproject;

import com.itvdn.webservices.ex_myproject.entity.Student;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class StudentHandle extends DefaultHandler {
    private Student currentStudent;
    private String currentQName;
    private int currentCourse;
    private List<String> currentSubjects;

    private List<Student> students;

    public StudentHandle() {
        currentSubjects = new ArrayList<>();
        students = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentQName = qName;

        if (attributes.getLength() > 0 && qName.equals("student")) {
            currentCourse = Integer.parseInt(new String(attributes.getValue(0)));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentQName = "";

        if (qName.equals("student")) {
            currentStudent.setSubjects(currentSubjects);
            students.add(currentStudent);
            currentSubjects = new ArrayList<>();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        switch (currentQName) {
            case "student": {
                currentStudent = new Student();
                currentStudent.setCourse(currentCourse);
                break;
            }
            case "name": {
                currentStudent.setName(new String(ch, start, length));
                break;
            }
            case "last_name": {
                currentStudent.setLastName(new String(ch, start, length));
                break;
            }
            case "average_score": {
                String averageScore = new String(ch, start, length);
                Double d = Double.parseDouble(averageScore);
                currentStudent.setAverageScore(d);
                break;
            }
            case "favoirite_subject": {
                currentSubjects.add(new String(ch, start, length));
                break;
            }
        }
    }

    @Override
    public void endDocument() throws SAXException {
        currentSubjects = null;
        currentQName = null;
    }

    public List<Student> getStudents() {
        return students;
    }
}
