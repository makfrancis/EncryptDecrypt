package com.francis.example.addressbook;

public class Main {

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        ScannerClass scannerClass = new ScannerClass();

        addressBook.readFile("C:\\Users\\mark.f.v.macandile\\IdeaProjects\\Tester\\AddressBook.csv");

        scannerClass.scannerChoices();

    }


}
