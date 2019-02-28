package com.francis.example.changepass2;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class EncryptDecrypt {
    private List<Account> accounts = new ArrayList<>();

    public List<Account> register() {

        Scanner scan = new Scanner(System.in);

        System.out.println("REGISTER FORM" + "\n\n");
        System.out.println("Enter Username");
        String username = scan.nextLine();

        for (Account checkUsername : readFile("listOfAccounts.csv")) {
            if (username.equals(checkUsername.getUsername())) {
                System.out.println("Sorry Username Already exist");
                return null;
            } else {
                System.out.println("Enter Password");
                boolean flag = true;
                while (flag) {
                    String password = scan.nextLine();
                    if (password.equals(null)) {
                        System.out.println("Kindly Enter a password");
                    } else {
                        flag = false;
                        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
                        accounts.add(new Account(username, encodedPassword));
                        System.out.println("Added new Account");

                    }
                }
            }
        }
        writeFile();
        return accounts;
    }


    public void login(){

        Scanner scan = new Scanner(System.in);

        System.out.println("LOGIN FORM"+ "\n\n");

        System.out.println("Enter Username");
        String username = scan.nextLine();

        System.out.println("Enter Password");
        String password = scan.nextLine();



        for(Account checkAccount : readFile("listOfAccounts.csv")){
            byte[] decodedBytes = Base64.getDecoder().decode(checkAccount.getPassword());
            String decodedPassword = new String(decodedBytes);

            if(username.equals(checkAccount.getUsername()) && password.equals(decodedPassword)){
                System.out.println("SUCCESSFULLY LOGIN");
                System.out.println("username: " + checkAccount.getUsername());
                System.out.println("Encrypted Password: " + checkAccount.getPassword());
            }else{
                System.out.println("No Accounts Found");
            }
        }

    }












    public List<Account> readFile(String listOfAccounts){
        FileReader file;
        try {
            file = new FileReader(listOfAccounts);
            Scanner scanNew = new Scanner(file);

            while (scanNew.hasNext()){
                String dataOfAllAccounts = scanNew.next();

                String[] values = dataOfAllAccounts.split(",");

                accounts.add(new Account(values[0], values[1]));

            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return accounts;

    }


    public void writeFile(){
       File file = null;
        try{
            String filename = "listOfAccounts.csv";

            file = new File (filename);

            if(!file.exists()) {
                file.createNewFile();

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                for(Account str: accounts) {
                    bw.write(str.getUsername()+","+str.getPassword());
                }

                bw.close();
                System.out.println("File Created");
            }else{


                file.delete();
                file.createNewFile();
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                for(Account str: accounts) {
                    bw.write(str.getUsername()+","+str.getPassword());
                }
                bw.close();
                System.out.println("File replaced");

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
