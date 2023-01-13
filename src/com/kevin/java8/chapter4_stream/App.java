package com.kevin.java8.chapter4_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 8. Stream 소개
 * - Stream
 * 데이터를 담고 있는 저장소 (컬렉션)이 아니다.
 * Funtional in nature, 스트림이 처리하는 데이터 소스를 변경하지 않는다.
 * 스트림으로 처리하는 데이터는 오직 한번만 처리한다.
 * 무제한일 수도 있다. (Short Circuit 메소드를 사용해서 제한할 수 있다.)
 * 중개 오퍼레이션은 근본적으로 lazy 하다.
 * 손쉽게 병렬 처리할 수 있다.
 *
 * - 스트림 파이프라인
 * 0 또는 다수의 중개 오퍼레이션 (intermediate operation)과 한개의 종료 오퍼레이션
 * (terminal operation)으로 구성한다.
 * 스트림의 데이터 소스는 오직 터미널 오퍼네이션을 실행할 때에만 처리한다.
 *
 * - 중개 오퍼레이션
 * Stream을 리턴한다.
 * Stateless / Stateful 오퍼레이션으로 더 상세하게 구분할 수도 있다. (대부분은
 * Stateless지만 distinct나 sorted 처럼 이전 이전 소스 데이터를 참조해야 하는
 * 오퍼레이션은 Stateful 오퍼레이션이다.)
 * filter, map, limit, skip, sorted, ...
 * 
 * - 종료 오퍼레이션
 * Stream을 리턴하지 않는다.
 * collect, allMatch, count, forEach, min, max, ...
 */
public class App {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("chawon");
        names.add("jinsol");
        names.add("yena");
        names.add("naeun");
        names.add("rachel");
        names.add("chakyung");

        names.stream().map(s -> {
            System.out.println(s);
            return s.toUpperCase();
        }); // 이상태에서는 출력이 실행되지 않음. 종료형 오퍼레이터가 오지 않았기때문에.

        System.out.println("-----1");

        names.stream().map(s -> {
            System.out.println(s);
            return s.toUpperCase(); //stream 은 실제 데이터를 바꾸진 않는다.
        }).collect(Collectors.toList()); //실제로 출력이 됨.

//        chawon
//        jinsol
//        yena
//        naeun
//        rachel
//        chakyung

        System.out.println("-----2");

        names.forEach(System.out::println); //변경없이 그대로 출력됨을 확인함

//        chawon
//        jinsol
//        yena
//        naeun
//        rachel
//        chakyung


        //중개형 오퍼레이터 - stream 을 리턴함. **
        //중개형 오퍼레이터는 0개 또는 여러개가능.
        //중개형 오퍼레이터는 종료형 오퍼레이터가 오기전에는 실행되지 않음. (정의만 함)
        //.map() , filter, limit, skip, sorted ...

        //종료형 오퍼레이터 - stream 을 리턴하지 않음 **
        //반드시 1개가 있어야됨.
        //.collect() 등, count, forEach, min, max, allMatch...

        System.out.println("-----3");

        //기존 병렬처리
        for(String name : names){
            if(name.startsWith("c")){
                System.out.println(name.toUpperCase());
            }
            //여러가지 추가 조건이 들어갈수록 복잡해짐.
        }

//        CHAWON
//        CHAKYUNG

        System.out.println("-----4");

        //stream 사용하여 병렬처리
        List<String> collect = names.parallelStream().map(String::toUpperCase)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

//        CHAWON
//        JINSOL
//        YENA
//        NAEUN
//        RACHEL
//        CHAKYUNG

        //stream() : 같은스레드에서 순차적으로 처리가됨.
        //parallelStream() : 여러 스레드에서 동시진행. 그러나 무조건 빨라지는건 아니다. 여러 스레드들을 만들때도 리소스가 들기때문.
        //처리 데이터의 양이 방대할 경우는 속도상 이점이 있을 수도 있음.
    }
}
