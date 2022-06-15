package com.kevin.java8.functionalInterfaceLamda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * 강의 2 - 함수형 인터페이스와 람다 = 4.메소드 레퍼런스
 */
public class MethodReference {
    public static void main(String[] args) {
        //UnaryOperator = Function 함수형 인터페이스중 입력,리턴이 같은 타입일때 하나의 타입만 명시해서 사용가능
        UnaryOperator<String> hi1 = (s) -> "hi "+s;
        //위 함수인터페이스는 Greeting.hi() 와 같은 기능
        System.out.println(hi1.apply("test"));

        //아래와 같이 변경 가능  :: 는 메소드레퍼런스를 뜻함. 함수형인터페이스의 구현체로
        //특정 클래스의 메소드를 사용하고자 할때 "클래스명(인스턴스명)::메소드명" 이렇게 사용할 수 있다.
        //스태틱 메소드를 사용
        UnaryOperator<String> hi2 = Greeting::hi;
        System.out.println(hi2.apply("test"));

        //구현체로 인스턴스 메소드를 사용하고자 할때는
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("test"));

        /**
         * 구현체로  Greeting::new 를 똑같이 썻지만, 함수형인터페이스가 각각
         * Supplier 와 Function 으로 입력,리턴값형태가 서로 다르기때문에 각각 다른 생성자가 실행됨.
         */
        //구현체로 클래스의 생성자를 사용할때는
        Supplier<Greeting> newGreeting = Greeting::new;
        System.out.println("getName()="+newGreeting.get().getName());

        //구현체로 클래스의 생성자2를 사용할때는
        Function<String, Greeting> newGreeting2 = Greeting::new;
        System.out.println("getName()="+newGreeting2.apply("test").getName());


        //임의 객체의 인스턴스 메소드 참조 예시
        String[] names = {"chakyung","chawon","naeun","yena","rachel","jinsol"};

        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        //위 형태를 람다로 변경
        Arrays.sort(names, (o1, o2) -> 0);

        //위 람다식 함수형 인터페이스의 구현체를 String 클래스의 compareToIgnoreCase 메소드를 사용해
        //메소드레퍼런스를 사용해서 구현해봄. (*compareToIgnoreCase : 대소문자 무시 정렬)
        Arrays.sort(names, String::compareToIgnoreCase);

        System.out.println(Arrays.toString(names));

    }
}
