package com.kevin.java8.chapter7_completableFuture.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 14. 자바 Concurrent 프로그래밍 소개
 * Concurrent 소프트웨어
 *  ● 동시에 여러 작업을 할 수 있는 소프트웨어
 *  ● 예)웹브라우저로 유튜브를 보면서 키보드로 문서에 타이핑을 할 수 있다.
 *  ● 예)녹화를 하면서 인텔리J로 코딩을 하고 워드에 적어둔 문서를 보거나 수정할 수 있다.
 *
 * 자바에서 지원하는 컨커런트 프로그래밍 ● 멀티프로세싱 (ProcessBuilder)
 *  ● 멀티쓰레드
 *
 * 자바 멀티쓰레드 프로그래밍
 *  ● Thread / Runnable
 *
 * Thread 상속
 * public static void main(String[] args) {
 *     HelloThread helloThread = new HelloThread();
 *     helloThread.start();
 *     System.out.println("hello : " + Thread.currentThread().getName());
 * }
 *
 * static class HelloThread extends Thread {
 *      @Override
 *      public void run() {
 *         System.out.println("world : " + Thread.currentThread().getName());
 *      }
 * }
 *
 * Runnable 구현 또는 람다
 * Thread thread = new Thread(() -> System.out.println("world : " + Thread.currentThread().getName()));
 * thread.start();
 * System.out.println("hello : " + Thread.currentThread().getName());
 *
 * 쓰레드 주요 기능
 *  ● 현재 쓰레드 멈춰두기 (sleep): 다른 쓰레드가 처리할 수 있도록 기회를 주지만 그렇다고 락을 놔주진 않는다. (잘못하면 데드락 걸릴 수 있겠죠.)
 *  ● 다른 쓰레드 깨우기 (interupt): 다른 쓰레드를 깨워서 interruptedExeption을 발생 시킨다.
 *  그 에러가 발생했을 때 할 일은 코딩하기 나름. 종료 시킬 수도 있고 계속 하던 일 할 수도 있고.
 *  ● 다른 쓰레드 기다리기 (join): 다른 쓰레드가 끝날 때까지 기다린다.
 *
 */




/**
15. Executors
고수준 (High-Level) Concurrency 프로그래밍
    ● 쓰레드를 만들고 관리하는 작업을 애플리케이션에서 분리.
    ● 그런 기능을 Executors에게 위임.

 Executors가 하는 일
    ● 쓰레드 만들기: 애플리케이션이 사용할 쓰레드 풀을 만들어 관리한다.
    ● 쓰레드 관리: 쓰레드 생명 주기를 관리한다.
    ● 작업 처리 및 실행:쓰레드로 실행 할 작업을 제공 할 수 있는 API를 제공한다.

 주요 인터페이스
    ● Executor: execute(Runnable)
    ● ExecutorService: Executor 상속 받은 인터페이스로, Callable도 실행할 수 있으며,Executor를 종료 시키거나,
    여러 Callable을 동시에 실행하는 등의 기능을 제공한다.
    ● ScheduledExecutorService: ExecutorService를 상속 받은 인터페이스로 특정 시간 이후에
    또는 주기적으로 작업을 실행할 수 있다. ExecutorService로 작업 실행하기

 ExecutorService로 작업 실행하기
     ExecutorService executorService = Executors.newSingleThreadExecutor();
     executorService.submit(() -> {
        System.out.println("Hello :" + Thread.currentThread().getName());
     });

 ExecutorService로 멈추기
    executorService.shutdown(); // 처리중인 작업 기다렸다가 종료
    executorService.shutdownNow(); // 당장 종료

 Fork/Join 프레임워크
    ● ExecutorService의 구현체로 손쉽게 멀티 프로세서를 활용할 수 있게끔 도와준다.

 **/

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
