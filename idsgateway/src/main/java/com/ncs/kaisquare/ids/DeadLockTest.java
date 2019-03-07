package com.ncs.kaisquare.ids;

public class DeadLockTest {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B.class){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (A.class){

                    }
                }


            }
        }).start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A.class){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B.class){

                    }
                }
            }
        }).start();
    }


    static class A{

    }

    static class B{

    }

}
