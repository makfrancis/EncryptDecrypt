package com.francis.example.changepassword;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;

public class Process {
    private List<Account> accounts = new ArrayList<>();

    public void readFile(String path){
        FileReader file;
        try {
            file = new FileReader(path);
            Scanner scanNew = new Scanner(file);
            while (scanNew.hasNext()){
                String dataOfNewLearners = scanNew.next();

                String[] values = dataOfNewLearners.split(",");

                this.accounts.add(new Account(values[0], values[1]));


            }
        }catch (IOException e){
            e.printStackTrace();
        }

        for(int i =0;i<accounts.size();i++){
            decryptPassword(accounts.get(i).getPassword());
            accounts.set(i,new Account(accounts.get(i).getUsername(),accounts.get(i).getPassword()));
        }
    }

    public String decryptPassword(String password){
        byte[] decodedBytes = Base64.getDecoder().decode(password);
        String decodedString = new String(decodedBytes);
        return decodedString;
    }

    public void encryptPassword(String password){
        String encodedString = Base64.getEncoder().encodeToString(password.getBytes());
        System.out.println(encodedString);
    }

    public void checkUsername(String username){

    }

    public void register(){
//        String username;
//        String password = null;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter Username:");
//        username = scanner.nextLine();
//
//        boolean sameUser = false;
//        for(int i =0;i<accounts.size();i++){
//            if(username.equals(accounts.get(i).getUsername())) {
//               sameUser=true;
//            }
//        }
//
//        if(sameUser==true){
//            System.out.println("Same User detected");
//        }else {
//            System.out.println("Enter Password:");
//            password = scanner.nextLine();
//        }
//
//        accounts.add(new Account(username,password));
//        System.out.println("Successfully added");



    }

    public void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Username");
        String username  = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();

        boolean hasUser = false;
        int getter=0;
        for(int i =0;i<accounts.size();i++){
            if(username.equals(accounts.get(i).getUsername())){
                hasUser = true;
                getter=i;
            }
        }

        if(hasUser==true){
            if(password==accounts.get(getter).getPassword()){
                System.out.println("Success Login");
            }
            else {
                System.out.println("Wrong password");
            }
        }else {
            System.out.println("wrong username");
        }
    }
}
