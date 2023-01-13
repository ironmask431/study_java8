package com.kevin.java8.chapter7_completableFuture.CompletableFuture1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
17. CompletableFuture 1

 자바에서 비동기(Asynchronous) 프로그래밍을 가능케하는 인터페이스.
    ● Future를 사용해서도 어느정도 가능했지만 하기 힘들 일들이 많았다.

 Future로는 하기 어렵던 작업들
    ● Future를 외부에서 완료 시킬 수 없다. 취소하거나, get()에 타임아웃을 설정할 수는 있다.
    ● 블로킹 코드(get())를 사용하지 않고서는 작업이 끝났을 때 콜백을 실행할 수 없다.
    ● 여러 Future를 조합할 수 없다, 예) Event 정보 가져온 다음 Event에 참석하는 회원 목록 가져오기
    ● 예외 처리용 API를 제공하지 않는다.

 CompletableFuture
    ● Implements Future
    ● Implements ​CompletionStage

 비동기로 작업 실행하기
    ● 리턴값이 없는 경우: runAsync()
    ● 리턴값이 있는 경우: supplyAsync()
    ● 원하는 Executor(쓰레드풀)를 사용해서 실행할 수도 있다. (기본은 ForkJoinPool.commonPool())

 콜백 제공하기
    ● thenApply(Function): 리턴값을 받아서 다른 값으로 바꾸는 콜백
    ● thenAccept(Consumer): 리턴값을 또 다른 작업을 처리하는 콜백 (리턴없이)
    ● thenRun(Runnable): 리턴값 받지 다른 작업을 처리하는 콜백
    ● 콜백 자체를 또 다른 쓰레드에서 실행할 수 있다.
 **/
public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //CompletableFuture-1
        //Future의 부족한 부분 보완
        //Executer를 사용하지 않아도 스레드풀 생성가능

        //비동기프로그래밍
        //리턴타입 없는 경우 = runAsync()
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Hello "+Thread.currentThread().getName());
        });
        future.get();
        //실행결과
        //Hello ForkJoinPool.commonPool-worker-3 - 별도스레드에서 동작된다.

        //리턴타입 있는 경우 = supplyAsync()
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello "+Thread.currentThread().getName());
            return "Hello";
        });
        System.out.println(future2.get());
        //실행결과
        //Hello ForkJoinPool.commonPool-worker-3
        //Hello

        //여기까지는 기존 future와 callable 으로도 가능한부분

        //콜백을 주는방법 - future 만 사용했을땐 콜백을 주는게 불가능했음.
        //thenApply() -> Functional 로 구현 -> 리턴타입있다.
        //thenAccept() -> Consumer 로 구현 -> 리턴타입없다.
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello "+Thread.currentThread().getName());
            return "Hello";
        }).thenApply((s) -> {
            System.out.println("Apply "+Thread.currentThread().getName());
            return s.toUpperCase();
        });

        System.out.println(future3.get());
        //실행결과
        //Hello ForkJoinPool.commonPool-worker-3
        //Apply main
        //HELLO
    }
}
