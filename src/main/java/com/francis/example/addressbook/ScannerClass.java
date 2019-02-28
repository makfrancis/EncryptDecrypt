package com.francis.example.addressbook;

import java.util.ConcurrentModificationException;
import java.util.Scanner;

public class ScannerClass{

    private AddressBook addressBook=new AddressBook();
    Scanner scanner = new Scanner(System.in);
    private String name;
    private String location;
    private String contactNumber;
    private String email;
    public ScannerClass() {
    }



    public void scannerChoices(){
        boolean flag = false;
        while(flag!=true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select a choice\n" +
                    "1 - Add\n" +
                    "2 - Edit\n" +
                    "3 - Delete\n" +
                    "4 - Generate Report");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scannerAdd();
                    break;
                case 2:
                    scannerEdit();
                    break;
                case 3:
                    scanDelete();
                    break;
                case 4:
                    addressBook.generateUpdatedReport();
                    flag=true;
                    break;
            }
        }
    }

    public void scannerAdd(){


        try {


            System.out.println("Insert name you want to add");
            name = scanner.nextLine();
            for (Details detail : addressBook.getList()) {
                if (name.equalsIgnoreCase(detail.getName())) {
                    System.out.println("Error");
                    scannerChoices();
                } else {
                    System.out.println("Success");
                }
            }
            System.out.println("Insert Location");
            location = scanner.nextLine();
            System.out.println("Insert number");
            contactNumber = scanner.nextLine();
            System.out.println("Insert email");
            email = scanner.nextLine();


            addressBook.add(name, location, contactNumber, email);
        }catch (ConcurrentModificationException e){
            e.printStackTrace();
        }
    }

    public void scannerEdit(){
        System.out.println("Select name to edit");
        name = scanner.nextLine();
        for(Details detail : addressBook.getList()){
            if(!name.equalsIgnoreCase(detail.getName())){
                System.out.println("Name doesn't exist");
                scannerChoices();
            }else {
                System.out.println("Select new location");
                location = scanner.nextLine();
                System.out.println("Select new number");
                contactNumber = scanner.nextLine();
                System.out.println("Select new email");
                email = scanner.nextLine();

                addressBook.edit(name,location,contactNumber,email);
                System.out.println("Success");
                scannerChoices();
            }
        }


    }

    public void scanDelete(){
        System.out.println("Select name to delete");
        name = scanner.nextLine();
        for(Details detail : addressBook.getList()){
            if(name.equalsIgnoreCase(detail.getName())){
                System.out.println("Success");
                addressBook.delete(name);
                scannerChoices();
            }else {
                System.out.println("Name doesn't exist");
                scannerChoices();
            }
        }

    }
}
