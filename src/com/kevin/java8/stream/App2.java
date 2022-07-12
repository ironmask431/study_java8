package com.kevin.java8.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream 예제 연습
 */
public class App2 {
    public static void main(String[] args) {

        List<OnlineClass> springClasses = new ArrayList<>();

        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api dev", false));

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
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .forEach(oc -> System.out.println(oc.getTitle()));

//        spring boot
//        spring data jpa
//        spring mvc
//        spring core

        System.out.println("2. close 되지않은 수업 명 출력");
        //to do
        springClasses.stream()
                        .filter(oc -> !oc.isClosed())
                        .forEach(oc -> System.out.println(oc.getTitle()));
//        spring mvc
//        spring core
//        rest api dev

        System.out.println("3. 수업 이름만 모아서 스트림 만들기");
        //to do
        springClasses.stream()
                        .map(oc -> oc.getTitle()) // map() = OnlineClass타입 스트림을 받아서 다른 타입(String)의 스트림으로 리턴함
                        .forEach(s -> System.out.println(s)); //여기선 forEach 에 String 스트림이 들어옴

        // 람다 메소드 레퍼런스로 자동 변경 가능.
        springClasses.stream()
                .map(OnlineClass::getTitle)
                .forEach(System.out::println);

        System.out.println("4. 두 수업 목록에 들어있는 모든 수업 아이디 출력");
        //to do
        //List 안에 들어있는 List 를 flat 한다. =  모두 하나의 리스트로 바꾼다.
        keesunEvents.stream().flatMap(Collection::stream) //flatMap 을 통해서 List 스트림이 OnlineClass 스트림으로 변형됨.
                        .forEach(onlineClass -> System.out.println(onlineClass.getTitle()));

//        spring boot
//        spring data jpa
//        spring mvc
//        spring core
//        rest api dev
//        The Java, Test
//        The Java, Code manipulation
//        The Java, 8 to 11

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
        boolean test = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println("test="+test);

        //test=true

        System.out.println("7.스프링 수업 중에 제목에 spring 이 들어간 것만 모아서 제목만으로 List 로 만들기");
        //to do
        List<String> newList = springClasses.stream()
                .filter(oc -> oc.getTitle().contains("spring"))
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());

        newList.stream().forEach(System.out::println);

//        spring boot
//        spring data jpa
//        spring mvc
//        spring core




    }
}
