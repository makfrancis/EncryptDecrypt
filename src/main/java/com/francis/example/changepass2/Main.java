package com.francis.example.changepass2;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EncryptDecrypt enc = new EncryptDecrypt();
        Scanner scan = new Scanner(System.in);
        enc.readFile("listOfAccounts.csv");


        boolean flag = true;
        while(flag){
            System.out.println("ENTER 1 to register, ENTER 2 to Login, ENTER 3 to exit");
            int choose = scan.nextInt();

            switch(choose){
                case 1:
                    enc.register();
                    break;
                case 2:
                    enc.login();
                    flag = false;
                    break;

                case 3:
                    enc.writeFile();
                    flag = false;
                    break;
            }
        }
    }
}
