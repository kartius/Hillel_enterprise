package org.hillel.lesson_3_4_multithreading_basics.debug;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {


        Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(100);
                    list.add(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " index " + i);
            }
        };


        Thread thread = new Thread(runnable);
        thread.start();


        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
                list.add(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " index " + i);
        }


    }
}
