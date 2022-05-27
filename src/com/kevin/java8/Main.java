package com.kevin.java8;

import java.util.function.*;

/**
 * 람다 표현식
 * 함수형 인터페이스의 인스턴스를 만드는 방법으로 쓰일 수 있다.
 * 코드의 길이를 줄일 수 있다.
 *
 * 함수형 프로그래밍
 * 함수를 class object로 사용할 수 있다.
 * 순수함수 - 사이드 이펙트 만들수없다. 함수밖에있는 값 변경불가 + 외부의값을 참조하지 않는다.
 * 고차함수 : 함수가 함수를 매개변수로 받을 수 있고, 함수를 리턴할 수도 있다.
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

        /**
         * java8에서 기본제공하는 주요 함수형 인터페이스
         * Function<T,R>        = T타입 받아서 R 리턴 / R apply(T);
         * BiFunction<T,U,R>    = 두개의 값 T,U 받아서 R 리턴 / R apply(T,U);
         * Consumer<T>          = T타입 받아서 리턴X / void Accept(T);
         * Supplier<T>          = T타입 리턴만. / T get();
         * Predicate<T>         = T타입 받아서 BOOLEAN 리턴 / boolean test(T)
         */

        //Function 함수형 인터페이스 예시
        Function<Integer, Integer> plus10 = (i) -> i+10;
        System.out.println(plus10.apply(1)); //11

        //BiFunction 함수형 인터페이스 예시
        BiFunction<Integer, Integer, Integer> test = (i,j) -> i+j;
        System.out.println(test.apply(1,2)); // 3

        //Consumer 함수형 인터페이스 예시
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(1); //1

        //Supplier 함수형 인터페이스 예시
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get()); //10

        //Predicate 함수형 인터페이스 예시
        Predicate<Integer> isEven = (i) -> i%2 == 0;
        System.out.println(isEven.test(4)); //true


    }

}
