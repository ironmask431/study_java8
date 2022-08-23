package com.kevin.java8.CompletableFuture.Concurrent;



public class App {
    public static void main(String[] args) throws InterruptedException {
        //java concurrent programing 소개
        //기존의 java concurrent 프로그래밍 방식
        //1. 쓰레드1 사용 - Thread를 extend 한 클래스 생성
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("Hello Thread");

        //쓰레드2 사용 - Runnable인터페이스를 사용하여 쓰레드 클래스 구축
        Thread runnableThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread: "+Thread.currentThread().getName());
            }
        });
        runnableThread.start();

//        [실행결과]
//        Hello Thread
//        Thread:Thread-0
//        Thread - runnable: Thread-1

        //쓰레드의 주요기능
        //1. sleep 을 이용한 대기
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread: "+Thread.currentThread().getName());
        });
        thread1.start();
        System.out.println("Hello: "+Thread.currentThread().getName());

//        [실행결과]
//        Hello: main (2초후)
//        Thread: Thread-0

        //2. interrupt 를 사용하여 실행중인 쓰레드에 개입하기
        Thread thread2 = new Thread(() -> {
            while (true){
                System.out.println("Thread: "+Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) { //InterruptedException => 외부에서 Interrupted 시 실행
                    System.out.println("Interrupted!!");
                    return; //runnable 종료
                }
            }
        });
        thread2.start();
        System.out.println("Hello: "+Thread.currentThread().getName());
        Thread.sleep(3000L);
        thread2.interrupt();

//        [실행결과]
//        Thread - runnable: Thread-0
//        Hello: main
//        Thread - runnable: Thread-0
//        Thread - runnable: Thread-0
//        Interrupted!! // 3초후 interrupt 실행 - 쓰레드 종료

        //3.join 을 사용하여 다른 쓰레드의 종료를 기다리기
        Thread thread3 = new Thread(() -> {
                System.out.println("Thread: "+Thread.currentThread().getName());
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) { //InterruptedException => 외부에서 Interrupted 시 실행
                    throw new IllegalStateException();
                }
        });
        thread3.start();
        System.out.println("Hello: "+Thread.currentThread().getName());
        thread3.join();
        System.out.println(thread3 + " is finished");

        //[실행결과]
//       Hello: main
//       Thread: Thread-0
//       Thread[Thread-0,5,] is finished -- 3초 후 스레디가 종료될때까지 기다린후 실행됨.

        //기존의 쓰레드 구조는 너무복잡하다. 2개만 써도 이렇게 복잡한데 수십,,수백개의 스레드를 코딩으로 관리하는건 사실상 불가능하다.
        //그래서 java8에 excutors 와 Future 가 등장함. 다음시간에 확인 ㄱ ㄱ
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Thread: "+ Thread.currentThread().getName());
        }
    }
}
