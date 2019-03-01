package com.francis.example.attendanceSummary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Process {

    private List<Account> list = new ArrayList<Account>();
    private List<Account> onTime = new ArrayList<Account>();
    private List<Account> late = new ArrayList<Account>();
    private String onTimeText = "";
    private String lateText = "";
    public Process() {
    }
    public void readFile(String s){
        String text = "";
        Scanner scanner = null;
        FileReader file;
        BufferedReader reader;
        try {
            file = new FileReader(s);
            reader = new BufferedReader(file);

            String line = reader.readLine();

            while(line!=null){
                text+=line + "\n";
                line = reader.readLine();
            }

            scanner = new Scanner(text);
            scanner.useDelimiter(",");
            boolean isBefore = false;

            while(scanner.hasNext()){

                String eid = scanner.next();
                scanner.skip(scanner.delimiter());
                String strTime = scanner.nextLine();

                LocalTime d = LocalTime.parse(strTime);
                if(d.isBefore(LocalTime.parse("08:00"))){
                    isBefore=true;
                }
                list.add(new Account(eid,d,isBefore));
            }


            for(Account a : list){
                if(a.getOnTime()==true){
                    onTime.add(a);
                }else if(a.getOnTime()==false){
                    late.add(a);
                }
            }

            System.out.println("Ontime");
            for(Account ont: onTime){
                //System.out.println(ont.getEid() + "\t\t" + ont.getDate());
                onTimeText+=ont.getEid() + "\t\t" + ont.getDate();
            }
            System.out.println(onTimeText);


            System.out.println("Late");
            for(Account latet: late){
                //System.out.println(latet.getEid() + "\t\t" + latet.getDate());
                lateText+=latet.getEid() + "\t\t" + latet.getDate();
            }
            System.out.println(lateText);
            file.close();
            reader.close();


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            scanner.close();

        }

    }

    public String getOnTimeText(){
        return onTimeText;
    }

    public String getLateText(){
        return lateText;
    }



}
