package com.francis.example.addressbook;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddressBookTest {

    @Test
    public void readFileTest() {


        //mark,a,a,a
        //nelle,b,b,b
        //francis,a,a,a
        //a,a,a,a
        //dj,a,a,a
        //b,b,b,b
        //c,c,c,c
        AddressBook addressBook = new AddressBook();
        Details details1 = new Details("mark","a","a","a");
        List<Details> expected = new ArrayList<>();
        expected.add(details1);

        List<Details> actual = addressBook.readFile("C:\\Users\\mark.f.v.macandile\\Desktop\\new.csv");

        assertEquals(expected.get(0).getName(),actual.get(0).getName());
        assertEquals(expected.get(0).getContactNumber(),actual.get(0).getContactNumber());
        assertEquals(expected.get(0).getEmail(),actual.get(0).getEmail());
        assertEquals(expected.get(0).getLocation(),actual.get(0).getLocation());


    }

    @Test
    public void addTest() {
        AddressBook addressBook = new AddressBook();
        Details details1 = new Details("mark","a","a","a");
        Details details2 = new Details("nelle","b","b","b");
        List<Details> expected = new ArrayList<>();
        expected.add(details1);
        expected.add(details2);


        addressBook.readFile("C:\\Users\\mark.f.v.macandile\\Desktop\\new.csv");
        addressBook.add("nelle","b","b","b");


        assertEquals(expected.get(1).getName(),addressBook.getList().get(1).getName());
        assertEquals(expected.get(1).getContactNumber(),addressBook.getList().get(1).getContactNumber());
        assertEquals(expected.get(1).getEmail(),addressBook.getList().get(1).getEmail());
        assertEquals(expected.get(1).getLocation(),addressBook.getList().get(1).getLocation());
    }

    @Test
    public void editTest() {
        AddressBook addressBook = new AddressBook();
        Details details1 = new Details("mark","c","c","c");
        List<Details> expected = new ArrayList<>();
        expected.add(details1);

        addressBook.readFile("C:\\Users\\mark.f.v.macandile\\Desktop\\new.csv");
        addressBook.edit("mark","c","c","c");

        assertEquals(expected.get(0).getName(),addressBook.getList().get(0).getName());
        assertEquals(expected.get(0).getContactNumber(),addressBook.getList().get(0).getContactNumber());
        assertEquals(expected.get(0).getEmail(),addressBook.getList().get(0).getEmail());
        assertEquals(expected.get(0).getLocation(),addressBook.getList().get(0).getLocation());

    }

    @Test
    public void deleteTest() {
        AddressBook addressBook = new AddressBook();
        Details details1 = new Details("nelle","b","b","b");
        List<Details> expected = new ArrayList<>();
        expected.add(details1);

        addressBook.readFile("C:\\Users\\mark.f.v.macandile\\Desktop\\new.csv");
        addressBook.add("nelle","b","b","b");
        addressBook.delete("mark");
        assertEquals(expected.get(0).getName(),addressBook.getList().get(0).getName());
        assertEquals(expected.get(0).getContactNumber(),addressBook.getList().get(0).getContactNumber());
        assertEquals(expected.get(0).getEmail(),addressBook.getList().get(0).getEmail());
        assertEquals(expected.get(0).getLocation(),addressBook.getList().get(0).getLocation());
    }


    @Test
    public void generateUpdatedReportTest() {
        AddressBook addressBook = new AddressBook();
        Details details1 = new Details("mark","a","a","a");
        List<Details> expected = new ArrayList<>();
        expected.add(details1);

        addressBook.readFile("C:\\Users\\mark.f.v.macandile\\Desktop\\new.csv");
        addressBook.generateUpdatedReport();

        assertEquals(expected.get(0).getName(),addressBook.getList().get(0).getName());
        assertEquals(expected.get(0).getContactNumber(),addressBook.getList().get(0).getContactNumber());
        assertEquals(expected.get(0).getEmail(),addressBook.getList().get(0).getEmail());
        assertEquals(expected.get(0).getLocation(),addressBook.getList().get(0).getLocation());



    }
}