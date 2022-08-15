package com.company;

import java.io.*;
import java.util.Scanner;

public class fileIo implements Runnable {

    @Override
    public void run(){
        try {
            choice();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void choice() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 for reading and 2 for writing"+Thread.currentThread().getName());
        System.out.println("\n");
        int choice = scanner.nextInt();
       if(choice == 2){
           writing();
           return;
       }else if (choice == 1){
           Reading();
           return;
       }
       return;
    }

    public void Reading(){
        try{
            File file = new File("text.txt");
            // FileInputStream inputStream = new FileInputStream(file);
            FileReader reader = new FileReader(file);
            int i = 0;
            while((i=reader.read())!=-1){
                System.out.println("Contents of the file "+(char)i+" Read by "+ Thread.currentThread().getName());
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void writing() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputText = reader.readLine();
            System.out.println(inputText);
            File file = new File("text.txt");
            FileWriter writer = new FileWriter(file);
            System.out.println("Inside the writing method of "+ Thread.currentThread().getName());
            writer.append(inputText+"Written by Thread "+Thread.currentThread().getName());
            writer.close();
            System.out.println("exiting method " +Thread.currentThread().getName());

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
    
