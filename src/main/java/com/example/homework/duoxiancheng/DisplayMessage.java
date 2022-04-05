package com.example.homework.duoxiancheng;

public class DisplayMessage implements Runnable {
    private String message;

    public DisplayMessage(String message) {
        this.message = message;
    }

    public void run() {
        while (true) {
            System.out.println(this.message + message);
        }
    }
}
