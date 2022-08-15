package com.company;

import java.io.*;
import java.util.Scanner;

public class fileIO2 implements Runnable {

    @Override
    public void run(){
        try {
            choice();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void  choice() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 for reading and 2 for writing"+Thread.currentThread().getName());
        int choice = scanner.nextInt();
        switch(choice){
            case(1): Reading();
                break;

            case(2): writing();
                break;

            default:
                System.out.println("Enter Valid choice");
        }
    }

    public void Reading(){
        try{
            File file = new File("text.txt");
            // FileInputStream inputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String i;
            while((i=reader.readLine())!=null){
                System.out.println("Contents of the file "+i+" Read by "+ Thread.currentThread().getName());
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public synchronized void writing() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputText = reader.readLine();
            System.out.println(inputText);
            File file = new File("text.txt");
            FileWriter writer = new FileWriter(file,true);

            writer.append(inputText).append("Written by Thread ").append(Thread.currentThread().getName());
            writer.close();
            System.out.println("exiting method " +Thread.currentThread().getName());

        }catch(Exception e){
            System.out.println(e);
        }
    }
}

