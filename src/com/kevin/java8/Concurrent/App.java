package com.kevin.java8.Concurrent;

public class App {
    public static void main(String[] args) {
        //java concurrent programing 소개
        //기존의 java concurrent 프로그래밍 방식
        //1. 쓰레드1 사용
//        MyThread myThread = new MyThread();
//        myThread.start();
//        System.out.println("Hello Thread");
//
//        //쓰레드2 사용
//        Thread runnableThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread - runnable: "+Thread.currentThread().getName());
//            }
//        });
//        runnableThread.start();

//        Hello Thread
//        Thread:Thread-0
//        Thread - runnable: Thread-1

        //쓰레드의 주요기능
        //1. 대기
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread - runnable: "+Thread.currentThread().getName());
        });
        thread.start();
        System.out.println("Hello: "+Thread.currentThread().getName());

//        Hello: main (2초후)
//        Thread - runnable: Thread-0
    }





    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Thread: "+ Thread.currentThread().getName());
        }
    }
}
