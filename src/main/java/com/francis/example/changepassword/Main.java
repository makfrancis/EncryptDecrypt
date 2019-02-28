package com.francis.example.changepassword;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Process process = new Process();

//            Scanner scanner = new Scanner(System.in);
//            process.readFile("C:\\Users\\mark.f.v.macandile\\Desktop\\lol.txt");
//            System.out.println("Insert Username");
//            String username = scanner.nextLine();

        Scanner scan = new Scanner(System.in);

        System.out.println("ENTER 1 to register, ENTER 2 to Login");
        int choose = scan.nextInt();


        switch(choose){
            case 1:
                process.register();
            case 2:
                process.login();
        }


//        // Getting encoder
//        Base64.Encoder encoder = Base64.getEncoder();
//        // Creating byte array
//        byte byteArr[] = {1,2};
//        // encoding byte array
//        byte byteArr2[] = encoder.encode(byteArr);
//        System.out.println("Encoded byte array: "+byteArr2);
//        byte byteArr3[] = new byte[5];                // Make sure it has enough size to store copied bytes
//        int x = encoder.encode(byteArr,byteArr3);    // Returns number of bytes written
//        System.out.println("Encoded byte array written to another array: "+byteArr3);
//        System.out.println("Number of bytes written: "+x);
//
//        // Encoding string
//        String str = encoder.encodeToString("JavaTpoint".getBytes());
//        System.out.println("Encoded string: "+str);
//        // Getting decoder
//        Base64.Decoder decoder = Base64.getDecoder();
//        // Decoding string
//        String dStr = new String(decoder.decode(str));
//        System.out.println("Decoded string: "+dStr);

//        String originalInput = "test input";
//        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
//        System.out.println(encodedString);
//
//
//        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
//        String decodedString = new String(decodedBytes);
//        System.out.println(decodedString);
    }
}
