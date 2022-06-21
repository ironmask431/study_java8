package com.kevin.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream - Stream 소개
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

        System.out.println("-----");

        names.stream().map(s -> {
            System.out.println(s);
            return s.toUpperCase(); //stream 은 실제 데이터를 바꾸진 않는다.
        }).collect(Collectors.toList()); //실제로 출력이 됨.

        System.out.println("-----");

        names.forEach(System.out::println); //변경없이 그대로 출력됨을 확인함

        //중개형 오퍼레이터
        //중개형 오퍼레이터는 0개 또는 여러개가능.
        //중개형 오퍼레이터는 종료형 오퍼레이터가 오기전에는 실행되지 않음. (정의만 함)
        //.map() , filter, limit, skip, sorted ...

        //종료형 오퍼레이터
        //반드시 1개가 있어야됨.
        //.collect() 등, count, forEach, min, max, allMatch...

        System.out.println("-----");

        //기존 병렬처리
        for(String name : names){
            if(name.startsWith("c")){
                System.out.println(name.toUpperCase());
            }
            //여러가지 추가 조건이 들어갈수록 복잡해짐.
        }

        System.out.println("-----");

        //stream 사용하여 병렬처리
        List<String> collect = names.parallelStream().map(String::toUpperCase)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

        //stream() : 같은스레드에서 순차적으로 처리가됨.
        //parallelStream() : 여러 스레드에서 동시진행. 그러나 무조건 빨라지는건 아니다. 여러 스레드들을 만들때도 리소스가 들기때문.
        //처리 데이터의 양이 방대할 경우는 속도상 이점이 있을 수도 있음.








    }
}
