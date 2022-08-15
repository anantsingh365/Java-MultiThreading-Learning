package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Runnable runnable1 = new fileIo();
        Runnable runnable2 = new fileIO2();

        Thread thread1 = new Thread(runnable2);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

    }
}
