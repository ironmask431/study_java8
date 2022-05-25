package com.kevin.java8;

/**
 * 람다 표현식
 * 함수형 인터페이스의 인스턴스를 만드는 방법으로 쓰일 수 있다.
 * 코드의 길이를 줄일 수 있다.
 */
public class Main {

    public static void main(String[] args) {
        // 익명 내부 클래스(함수형 인터페이스) 원형
//        RunSomething runSomething = new RunSomething() {
//            @Override
//            public void doIt(){
//                System.out.println("Hello");
//            }
//        };
        // 익명 내부 클래스(함수형 인터페이스) > 인텔리제이에서 람다식으로 변경지원
        RunSomething runSomething = () -> {
            System.out.println("Hello");
            System.out.println("Hello2");
        };
        runSomething.doIt();
    }
}
