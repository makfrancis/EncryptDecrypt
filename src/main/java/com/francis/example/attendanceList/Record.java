package com.francis.example.attendanceList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Record {

    private List<Account> account = new ArrayList<Account>();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
    LocalDateTime now = LocalDateTime.now();
    String text = "";
    List<String> eids = new ArrayList<String>();


    public Record() {
    }



    public String enterLearner(String eid){
        String list = "";
        String message = "";


        if(eids.contains(eid)){
            message="User Already Exists";
        }
        else{
            eids.add(eid);
            account.add(new Account(eid,now));
            for(Account acc : account) {
                System.out.println(acc.getEid() + "\t\t" + dtf.format(acc.getNow()));
               // text += acc.getEid() + "\t\t" + dtf.format(acc.getNow()) + "\n";
            }
//            list += eid + "\t\t" + dtf.format(now) + "\n";
            message = "EID Successfully added";
        }
        return message;

    }



    public void addData(){
        System.out.println("Who do you want to add");
        Scanner scanner = new Scanner(System.in);
        String eid = scanner.nextLine();
        enterLearner(eid);
        choice();
    }

    public void choice(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to add more?(Y/N)");
        char yn = scanner.next().charAt(0);
        if((yn=='Y')||(yn=='y')){
            addData();
        }
        else if((yn=='N')||(yn=='n')){

        printResult(account);

        }
        else{
            System.out.println("Please input properly");
            choice();
        }
    }

    public File printResult(List<Account> account){
        File file = null;
        try{
            String filename = "result.csv";
            for(Account acc : account) {
                text += acc.getEid() + "," + dtf.format(acc.getNow()) + "\n";
            }
            file = new File (filename);

            if(!file.exists()) {
                file.createNewFile();

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(text);
                bw.close();
                System.out.println("File Created");
            }else{


                file.delete();
                file.createNewFile();
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(text);
                bw.close();
                System.out.println("File already replaced");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return file;

    }

    public List<Account> getAccount() {
        return account;
    }
}
