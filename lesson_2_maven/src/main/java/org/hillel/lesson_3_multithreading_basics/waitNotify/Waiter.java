package org.hillel.lesson_3_multithreading_basics.waitNotify;

import org.hillel.lesson_3_multithreading_basics.Main;

public class Waiter implements Runnable {

    private Message msg;


    public Waiter(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        synchronized (msg) {
            try {
                System.out.println("Waiting until notifying");
                msg.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
