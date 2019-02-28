package com.francis.example.bootcampspan;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Process {

    public void method(){
        String oldDate = "2019-01-01";
        System.out.println("Date before Addition: "+oldDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try{
            c.setTime(sdf.parse(oldDate));
        }catch(ParseException e){
            e.printStackTrace();
        }
        //Incrementing the date by 1 day

        int counter = 0;
        List<String> holidays = new ArrayList<>();
        List<String> city = new ArrayList<>();

        FileReader file;
        try {
            file = new FileReader("C:\\Users\\mark.f.v.macandile\\Desktop\\Holidays.txt");
            Scanner scanNew = new Scanner(file);

            while (scanNew.hasNext()){
                String dataOfNewLearners = scanNew.next();

                String[] values = dataOfNewLearners.split(",");

                holidays.add(values[0]);
                city.add(values[1]);
            }
        }catch (IOException e){
            e.printStackTrace();
        }



        while (counter<5){


            int dayofWeek = c.get(Calendar.DAY_OF_WEEK);
            if(!((dayofWeek==1) || (dayofWeek ==7))){

                if(holidays.contains(sdf.format(c.getTime()))){
                    System.out.println(sdf.format(c.getTime()) + " holiday");

                }
                else {
                    System.out.println(sdf.format(c.getTime()) + " not holiday");
                    counter++;
                }
            }
            if(counter!=5){
                c.add(Calendar.DAY_OF_MONTH, 1);
            }
        }
        String newDate = sdf.format(c.getTime());
        System.out.println("Date Incremented by One: "+newDate);
    }
}
