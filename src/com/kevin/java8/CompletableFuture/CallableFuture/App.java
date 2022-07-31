package com.kevin.java8.CompletableFuture.CallableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Callable 과 Future
        //Callable 과 Runnable 의 차이점은 Callable은 리턴타입이 있다. Runnable 은 void

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //Callable 선언
        Callable<String> callableHello = () -> {
            Thread.sleep(2000L);
            return "hello";
        };

        //executorService 에서 submit()의 인자로 Callable 을 넣게되면 Future 를 리턴함.
        Future<String> helloFuture = executorService.submit(callableHello);

        System.out.println(helloFuture.isDone()); // Future 가 종료되었는지 여부 조회 true, false
        System.out.println("Started!");
        System.out.println(helloFuture.get()); // 블록킹. get()으로 응답이 올때까지 기다림.
        System.out.println(helloFuture.isDone());
        System.out.println("End!!");
        executorService.shutdown();

        //실행결과
        //false
        //Started!
        //hello  -- 2초후 찍힘.
        //true
        //End!!


        System.out.println("Started 2 !");
        helloFuture.cancel(false); // Future 대기 강제종료. (true : 바로종료, false : 대기했다가 종료?)
        //cancel 하게되면 더이상 .get() 으로 결과가져오기 불가.
        System.out.println(helloFuture.get()); // 에러발생
        System.out.println("End 2!!");
        executorService.shutdown();

        //실행결과
        //Started 2 !
        //Exception in thread "main" java.util.concurrent.CancellationException


        //여러개의 callable 동시에 실행
        //3개 멀티스레드풀 생성
        ExecutorService executorService3 = Executors.newFixedThreadPool(3);

        //Callable 활용
        Callable<String> java = () -> {
            Thread.sleep(1000L);
            return "java";
        };

        Callable<String> spring = () -> {
            Thread.sleep(2000L);
            return "spring";
        };

        Callable<String> jpa = () -> {
            Thread.sleep(3000L);
            return "jpa";
        };

        List<Future<String>> futures = executorService3.invokeAll(Arrays.asList(java,spring,jpa));

        for(Future future : futures){
            System.out.println(future.get());
        }
        executorService3.shutdown();

        //실행결과
        //3초후 동시 출력됨. invokeAll 은 3개가 모두 완료될때까지 기다림. 하나가 먼저 완료되도 먼저출력 x
        //java
        //spring
        //jpa

        String s = executorService3.invokeAny(Arrays.asList(java,spring,jpa));
        System.out.println(s);
        executorService3.shutdown();

        //실행결과
        //가장빠른 java가 먼저 실행되고 종료 - invokeAny 는 가장빠른거 1개만 완료되고 끝?
        //java

    }
}
