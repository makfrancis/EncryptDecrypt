package com.francis.example.addressbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    private static List<Details> list = new ArrayList<>();


    public AddressBook() {



    }

    public List<Details> readFile(String path){
        System.out.println("ReadFile Page where path is " + path);
        FileReader file;
        try {
            file = new FileReader(path);
            Scanner scanNew = new Scanner(file);
            while (scanNew.hasNext()){
                String dataOfNewLearners = scanNew.next();

                String[] values = dataOfNewLearners.split(",");

                this.list.add(new Details(values[0], values[1], values[2], values[3]));

            }
            for(Details d : this.list){
                System.out.println(d.getName() + "\t\t" + d.getLocation() + "\t\t" +  d.getContactNumber() + "\t\t" + d.getEmail());
            }
        }catch (IOException e){
            e.printStackTrace();
        }

            return this.list;
    }

    public List<Details> add(String name, String location, String contactNumber, String email){
        System.out.println("Add Page");
        list.add(new Details(name,location,contactNumber,email));

        for(Details d: this.list){
            System.out.println(d.getName() + "\t" + d.getLocation() + " \t" + d.getContactNumber() + " \t" + d.getEmail());
        }
        return this.list;

    }

    public List<Details> edit(String name, String location, String contactNumber, String email){
        System.out.println("Edit Page");
        for(int i=0;i<this.list.size();i++){
            if(this.list.get(i).getName().equalsIgnoreCase(name)){
                this.list.set(i,new Details(name,location,contactNumber,email));
            }
        }
        for(Details d: this.list){
            System.out.println(d.getName() + "\t" + d.getLocation() + " \t" + d.getContactNumber() + " \t" + d.getEmail());
        }
        return this.list;
    }

    public List<Details> delete(String name){
        System.out.println("Delete Page");
        for(int i=0;i<this.list.size();i++){
            if(this.list.get(i).getName().equalsIgnoreCase(name)){
                this.list.remove(i);
            }
        }
        for(Details d: this.list){
            System.out.println(d.getName() + "\t" + d.getLocation() + " \t" + d.getContactNumber() + " \t" + d.getEmail());
        }
        return this.list;

    }

    public void generateUpdatedReport(){
        System.out.println("GenerateUpdatedReport Page");
        String str ="";
        for(Details d: this.list){
            str+= d.getName() + "," + d.getLocation() + "," + d.getContactNumber() + "," + d.getEmail() + "\n";
        }
        System.out.println(str);

        File file = null;
        try{
            String filename = "AddressBook.csv";

            file = new File (filename);

            if(!file.exists()) {
                file.createNewFile();

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(str);
                bw.close();
                System.out.println("File Created");
            }else{


                file.delete();
                file.createNewFile();
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(str);
                bw.close();
                System.out.println("File already replaced");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Details> getList() {
        return list;
    }
}
