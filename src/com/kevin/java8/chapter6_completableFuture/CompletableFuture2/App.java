package com.kevin.java8.chapter6_completableFuture.CompletableFuture2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
/**
        CompletableFuture-2
        조합하기
        - thenCompose(): 두 작업이 서로 이어서 실행하도록 조합
        - thenCombine(): 두 작업을 독립적으로 실행하고 둘 다 종료 했을 때 콜백 실행
        - allOf(): 여러 작업을 모두 실행하고 모든 작업 결과에 콜백 실행
        - anyOf(): 여러 작업 중에 가장 빨리 끝난 하나의 결과에 콜백 실행

        예외처리
        - exeptionally(Function)
        - handle(BiFunction):
 **/

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello "+Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("World "+Thread.currentThread().getName());
            return "World";
        });

        //1. hello 가 끝난다음 world 를 하려면?
        //thenCompose(): 두 작업이 서로 이어서 실행하도록 조합, 두 future 가 연관관계가 있어서 하나가 완료되고나서 나머지가 실행되야 할때
        CompletableFuture<String> future = hello.thenCompose((s) -> {
            return getWorld(s);
        });
        System.out.println(future.get());

        //실행결과
//        Hello ForkJoinPool.commonPool-worker-3
//        World ForkJoinPool.commonPool-worker-5
//        HelloWorld

        //2. 두 future가 연관관계가 없을때는? 각각 따로실행
        //thenCombine(): 두 작업을 독립적으로 실행하고 둘 다 종료 했을 때 콜백 실행
        CompletableFuture<String> future2 = hello.thenCombine(world, (h, w) -> {
            return h + "," + w;
        });
        System.out.println(future2.get());
        //실행결과
//        World ForkJoinPool.commonPool-worker-5
//        Hello ForkJoinPool.commonPool-worker-3
//        Hello,World

        //allOf(), anyOf() - 복잡해서 실습은 생략.. ㅎㅎ
    }

    public static CompletableFuture<String> getWorld(String msg){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World "+Thread.currentThread().getName());
            return msg + "World";
        });
    }
}
