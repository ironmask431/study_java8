package com.kevin.java8.CompletableFuture.CompletableFuture1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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
