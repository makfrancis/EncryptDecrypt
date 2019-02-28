package com.francis.example.encrypter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("C:\\Users\\mark.f.v.macandile\\Desktop\\lol.txt");
            Base64.Encoder file;
//            file = (Base64.Encoder) Base64.getUrlEncoder(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
