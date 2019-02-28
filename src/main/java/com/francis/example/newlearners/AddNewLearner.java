package com.francis.example.newlearners;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddNewLearner {

    private List<Details> details = new ArrayList<Details>();
    private List<String> reference= new ArrayList<String>();
    private List<Details> details2 = new ArrayList<Details>();
    private List<String> newList= new ArrayList<String>();
    private String referenceText = "";
    private String newListText = "";

    public AddNewLearner() {
    }

    public List readReference(){
        try {


            FileReader file = new FileReader("C:\\Users\\mark.f.v.macandile\\IdeaProjects\\Tester\\src\\reference.csv");
            Scanner scanNew = new Scanner(file);
            while (scanNew.hasNext()) {
                String dataOfNewLearners = scanNew.next();

                String[] values = dataOfNewLearners.split(",");

                int batch = Integer.parseInt(values[1]);

                details.add(new Details(values[0], batch));
                reference.add(values[0] + " " + values[1]);

            }
            for(Details d: details){
                referenceText += d.getName() + " " + d.getBatch() + "\n";
            }
            System.out.println(referenceText);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return details;
    }

    public List readPresent(){
        try {


            FileReader file = new FileReader("C:\\Users\\mark.f.v.macandile\\IdeaProjects\\Tester\\src\\new.csv");
            Scanner scanNew = new Scanner(file);
            while (scanNew.hasNext()) {
                String dataOfNewLearners = scanNew.next();

                String[] values = dataOfNewLearners.split(",");

                int batch = Integer.parseInt(values[1]);

                details2.add(new Details(values[0], batch));
                newList.add(values[0] + " " + values[1]);

            }

            for(Details d: details2){
                newListText += d.getName() + " " + d.getBatch() + "\n";
            }
            System.out.println(newListText);


        }
        catch (IOException e){
            e.printStackTrace();
        }

        return details2;
    }

    public void addList(){
        for(int i =0;i<=newList.size()-1;i++) {
            if (!reference.contains(newList.get(i))) {
                reference.add(newList.get(i));
            }

        }
//        for(int i=0; i<details.size();i++){
//            for(int j=0;j<details2.size();j++){
//                if(!details.get(i).getName().equals(details2.get(j).getName())){
//                    details.add(details2.get(j));
//                }
//            }
//        }

        for (String d : reference){
            System.out.println(d);
        }
    }


}
