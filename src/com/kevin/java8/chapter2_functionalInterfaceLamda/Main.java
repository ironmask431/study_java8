package com.kevin.java8.chapter2_functionalInterfaceLamda;

import java.util.function.*;

/**
 * 강의 2 - 함수형 인터페이스와 람다
 *
 * - 함수형 인터페이스 (Functional Interface)
 * 추상메소드를 딱 하나만 가지고 있는 인터페이스
 *
 * - 람다 표현식
 * 함수형 인터페이스의 인스턴스를 만드는 방법으로 쓰일 수 있다.
 * 코드의 길이를 줄일 수 있다.
 * 메소드 매개변수, 리턴타입, 변수로 만들어 사용할 수도 있다.
 *
 * - 자바에서 함수형 프로그래밍
 * 함수를 First class object로 사용할 수 있다.
 * 순수함수
 *      사이드 이펙트가 없다. (함수 밖에 있는 값을 변경하지 않는다.)
 *      상태가 없다. (함수 밖에 있는 값을 사용하지 않는다.)
 * 고차함수
 *      함수가 함수를 매개변수로 받을 수 있고, 함수를 리턴할 수도 있다.
 */
public class Main {

    public static void main(String[] args) {

        /**
         * 강의 2-3.람다 표현식
         * 람다
         *  ● (인자 리스트) -> {바디}
         * 인자 리스트
             * ● 인자가없을때:()
             * ● 인자가 한개일 때: (one) 또는 one
             * ● 인자가 여러개 일 때: (one, two)
             * ● 인자의 타입은 생략 가능, 컴파일러가 추론(infer)하지만 명시할 수도 있다. (Integer one, Integer two)
         * 바디
             * ● 화상표 오른쪽에 함수 본문을 정의한다.
             * ● 여러 줄 인경우에{}를사용해서묶는다.
             * ● 한 줄인 경우에 생략 가능, return도 생략 가능.
         */
        // 익명 내부 클래스(함수형 인터페이스) 원형
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt(){
                System.out.println("Hello");
            }
        };
        runSomething.doIt();

        // 익명 내부 클래스(함수형 인터페이스) > 인텔리제이에서 람다식으로 변경지원
        RunSomething runSomething2 = () -> {
            System.out.println("Hello");
            System.out.println("Hello2");
        };
        runSomething2.doIt();

        /**
         * 강의 2-2. java8 에서 제공하는 주요 함수형 인터페이스
         *
         * Function<T,R>        = T타입 받아서 R 리턴 / R apply(T);
         * UnaryOperator<T>     = Function<T, R>의 특수한 형태로, 입력값 하나를 받아서 동일한 타입을 리턴
         * BiFunction<T,U,R>    = 두개의 값 T,U 받아서 R 리턴 / R apply(T,U);
         * BinaryOperator<T>    = BiFunction<T, U, R>의 특수한 형태로, 동일한 타입의 입력값 두개를 받아 리턴
         * Consumer<T>          = T타입 받아서 리턴X / void Accept(T);
         * Supplier<T>          = T타입 리턴만. / T get();
         * Predicate<T>         = T타입 받아서 BOOLEAN 리턴 / boolean test(T)
         */

        //Function 함수형 인터페이스 예시 = T타입 받아서 R 리턴 / R apply(T);
        Function<Integer, Integer> plus10 = (i) -> i+10;
        System.out.println(plus10.apply(1)); // 11

        //BiFunction 함수형 인터페이스 예시 = 두개의 값 T,U 받아서 R 리턴 / R apply(T,U);
        BiFunction<Integer, Integer, Integer> test = (i,j) -> i+j;
        System.out.println(test.apply(1,2)); // 3

        //Consumer 함수형 인터페이스 예시 = T타입 받아서 리턴X / void Accept(T);
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(1); //1

        //Supplier 함수형 인터페이스 예시 = T타입 리턴만. / T get();
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get()); //10

        //Predicate 함수형 인터페이스 예시 = T타입 받아서 BOOLEAN 리턴 / boolean test(T)
        Predicate<Integer> isEven = (i) -> i%2 == 0;
        System.out.println(isEven.test(4)); //true

    }

}
