package com.francis.example.crudtext;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrudText {

    List<Details> details = null;
    public CrudText() {

    }

    public void readText(String s) {
        List<String> nameList = new ArrayList<String>();
        List<String> locationList = new ArrayList<String>();

        try{
            FileReader file = new FileReader(s);
            int legend = 0;
            String[] name={};
            String [] location={};
            String nameText = "";
            String locationText = "";

            Scanner scanNew = new Scanner(file);
            legend = Integer.parseInt(scanNew.nextLine());

            if(counter(s)>3){
                System.out.println("Too many lines");
            }
            else if(counter(s)==2){
                if(legend==3){
                    System.out.println("legend is " + legend);
                    String nameCondition = scanNew.nextLine();
//                    if(nameCondition.contains(",")){
//                        deleteData(nameCondition.split(","));
//                    }else if(!nameCondition.contains(",")){
//                        String[] n = {};
//                        n[0] = scanNew.nextLine();
//                        deleteData(n);
//                    }
                    deleteData(nameCondition);
                }
            }
            else if(counter(s)<2){
                System.out.println("too few lines");
            }
            else{
                name = scanNew.nextLine().split(",");
                for(int i=0;i<name.length;i++){
                    nameList.add(name[i]);
                }
                location = scanNew.nextLine().split(",");
                for(int j=0;j<location.length;j++){
                    locationList.add(location[j]);
                }
                System.out.println(legend);
                for(String str: nameList){
                    nameText += str + ",";
                }
                System.out.println(nameText);
                for(String str: locationList){
                    locationText += str + ",";
                }
                System.out.println(locationText);

                if(name.length==location.length){
                    System.out.println("Equal");
                    condition(legend,nameList,locationList);

                }
                else if(name.length!=location.length){
                    System.out.println("not equal");
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    public int counter(Scanner s) throws Exception {
//        File file = new File("C:\\Users\\mark.f.v.macandile\\IdeaProjects\\Tester\\src\\crud.txt");
//        FileInputStream fis = new FileInputStream(file);
//        byte[] byteArray = new byte[(int)file.length()];
//        fis.read(byteArray);
//        String data = new String(byteArray);
//        String[] stringArray = data.split("\r\n");
//        System.out.println("Number of lines in the file are ::"+stringArray.length);
//        return stringArray.length;
//    }
    public int counter(String s){

        int lineNumberCounter = 0;
        try{
            FileReader file = new FileReader(s);
            LineNumberReader lnr = new LineNumberReader(file);

            try{
                while(lnr.readLine()!=null){
                    lineNumberCounter++;
                }
//                System.out.println("totla number of lines " + lineNumberCounter);
            }catch (IOException e){
                e.printStackTrace();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return lineNumberCounter;
    }



    public List<Details> condition(int legend,List<String> nameList, List<String> locationList){

        switch (legend){
            case 1: details = addData(nameList,locationList);
                System.out.println("Successfully added");
                for(Details d: details){
                    System.out.println(d.getName() + "\t\t" + d.getLocation());
                }
                break;

        }

        return details;
    }

    public List<Details> addData(List<String> nameList, List<String> locationList){
        List<Details> details = new ArrayList<>();
        for(int i=0;i<nameList.size();i++){
            details.add(new Details(nameList.get(i),locationList.get(i)));
        }

        return details;
    }

    public List<Details> deleteData(String name){
        String[] names = {};


            for(int j =0;j<details.size();j++){
                if(name.equals(details.get(j).getName())){
                    details.remove(j);
                }
            }




        //result
        for(Details d: details){
            System.out.println(d.getName() + "\t\t" + d.getLocation());
        }
        return details;
    }

}
