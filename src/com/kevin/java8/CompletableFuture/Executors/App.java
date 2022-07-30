package com.kevin.java8.CompletableFuture.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        //Executors 싱글스레드 선언
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //1.executor 싱글스레드 실행방법1
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("1. Thread:"+Thread.currentThread().getName());
            }
        });

        //람다식으로 변경
        executorService.submit(() -> {
            System.out.println("2. Thread:"+Thread.currentThread().getName());
        });

        //실행결과 : 싱글스레드가 실행됨.
//        1. Thread:pool-1-thread-1
//        2. Thread:pool-1-thread-1

        //shutdown 을 해줘야 스레드 종료됨.
        executorService.shutdown();

        //다중스레드 구현
        ExecutorService executorService1 = Executors.newFixedThreadPool(2); //2개 스레드 구현

        executorService1.submit(getRunnable("a"));
        executorService1.submit(getRunnable("b"));
        executorService1.submit(getRunnable("c"));
        executorService1.submit(getRunnable("d"));
        executorService1.submit(getRunnable("e"));

        executorService1.shutdown();

        //실행결과 - 두개의 스레드로 동시 실행됨.
//        b : pool-1-thread-2
//        a : pool-1-thread-1
//        c : pool-1-thread-2
//        e : pool-1-thread-2
//        d : pool-1-thread-1

    }

    public static Runnable getRunnable (String msg){
        return () -> {
            System.out.println(msg +" : " + Thread.currentThread().getName());
        };
    }

}
