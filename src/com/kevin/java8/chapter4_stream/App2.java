package com.kevin.java8.chapter4_stream;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream 예제 연습하기
 * 
 * 9. Stream API
 * 걸러내기
 * Filter(Predicate)
 * 예) 이름이 3글자 이상인 데이터만 새로운 스트림으로
 *
 * 변경하기
 * Map(Function) 또는 FlatMap(Function)
 * 예) 각각의 Post 인스턴스에서 String title만 새로운 스트림으로
 * 예) List<Stream<String>>을 String의 스트림으로
 *
 * 생성하기
 * generate(Supplier) 또는 Iterate(T seed, UnaryOperator)
 * 예) 10부터 1씩 증가하는 무제한 숫자 스트림
 * 예) 랜덤 int 무제한 스트림
 *
 * 제한하기
 * limit(long) 또는 skip(long)
 * 예) 최대 5개의 요소가 담긴 스트림을 리턴한다.
 * 예) 앞에서 3개를 뺀 나머지 스트림을 리턴한다.
 *
 * 스트림에 있는 데이터가 특정 조건을 만족하는지 확인
 * anyMatch(), allMatch(), nonMatch()
 * 예) k로 시작하는 문자열이 있는지 확인한다. (true 또는 false를 리턴한다.)
 * 예) 스트림에 있는 모든 값이 10보다 작은지 확인한다.
 *
 * 개수 세기
 * count()
 * 예) 10보다 큰 수의 개수를 센다.
 *
 * 스트림을 데이터 하나로 뭉치기
 * reduce(identity, BiFunction), collect(), sum(), max()
 * 예) 모든 숫자 합 구하기
 * 예) 모든 데이터를 하나의 List 또는 Set에 옮겨 담기
 * 
 */
public class App2 {
    public static void main(String[] args) {

        List<OnlineClass> springClasses = new ArrayList<>();

        //spring 수업
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api dev", false));

        //JAVA 수업
        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);


        System.out.println("1. spring으로 시작하는 수업 명 출력");
        //to do
        springClasses.stream()
                .filter((onlineClass -> onlineClass.getTitle().startsWith("spring")))
                .forEach((onlineClass) -> System.out.println(onlineClass.getTitle()));
//        spring boot
//        spring data jpa
//        spring mvc
//        spring core

        System.out.println("2. close 되지않은 수업 명 출력");
        //to do
        keesunEvents.stream()
                .flatMap((classes) -> classes.stream())
                .filter(onlineClass -> !onlineClass.isClosed())
                .forEach((onlineClass -> System.out.println(onlineClass.getTitle())));
//        spring mvc
//        spring core
//        rest api dev
//        The Java, 8 to 11

        System.out.println("3. 수업 이름만 모아서 스트림 만들기");
        //to do
        keesunEvents.stream()
                .flatMap((classes) -> classes.stream())
                .map((onlineClass) -> onlineClass.getTitle())
                .forEach(System.out::println);
//        spring boot
//        spring data jpa
//        spring mvc
//        spring core
//        rest api dev
//        The Java, Test
//        The Java, Code manipulation
//        The Java, 8 to 11

        System.out.println("4. 두 수업 목록에 들어있는 모든 수업 아이디 출력");
        //to do
        keesunEvents.stream()
                .flatMap((classes) -> classes.stream())
                .forEach((onlineClass -> System.out.println(onlineClass.getId())));
//        1
//        2
//        3
//        4
//        5
//        6
//        7
//        8

        System.out.println("5. 10부터 1씩 증가하는 무제한 스트림중에서 앞에 10개 빼고 최대 10개 까지만");
        //to do
        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

//        20
//        21
//        22
//        23
//        24
//        25
//        26
//        27
//        28
//        29

        System.out.println("6. 자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        //to do
        boolean flag = javaClasses.stream()
                        .anyMatch((onlineClass -> onlineClass.getTitle().contains("Test")));
        System.out.println("flag = "+flag);
        //flag = true

        System.out.println("7.스프링 수업 중에 제목에 spring 이 들어간 것만 모아서 제목만으로 List 로 만들기");
        //to do
        List<String> titles2 =  springClasses.stream()
                .filter((onlineClass -> onlineClass.getTitle().contains("spring")))
                .map((onlineClass) -> onlineClass.getTitle())
                .collect(Collectors.toList());
        titles2.forEach((title) -> System.out.println(title));

//        spring boot
//        spring data jpa
//        spring mvc
//        spring core
    }
}
