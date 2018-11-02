package com.patttern.bio;

public class test {
    public static void main(String[] args) throws InterruptedException{
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Server.start();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(200L);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Client.send();
            }
        }).start();
    }
}
