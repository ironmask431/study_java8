package com.kevin.java8.java8method;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * 자바 8에서 추가한 기본 메소드로 인한 API 변화
 * - Iterable의 기본 메소드
 * forEach()
 * spliterator()
 *
 * - Collection의 기본 메소드
 * stream() / parallelStream()
 * removeIf(Predicate)
 * spliterator()
 *
 * - Comparator의 기본 메소드 및 스태틱 메소드
 * reversed()
 * thenComparing()
 * static reverseOrder() / naturalOrder()
 * static nullsFirst() / nullsLast()
 * static comparing()
 */
public class App {
    public static void main(String[] args) {

        List<String> name = new ArrayList<String>();
        name.add("chawon");
        name.add("jinsol");
        name.add("yena");
        name.add("naeun");
        name.add("rachel");
        name.add("chawon");

        //Iterable 의 기본메소드 : forEach();
        //forEach 는 매개변수로 Consumer 함수형 인터페이스가 들어감.
        name.forEach(new Consumer<String>() {
           @Override
           public void accept(String s) {
                System.out.println(s);
            }
        });

        //실행결과
        //chawon
        //jinsol
        //yena
        //naeun
        //rachel
        //chawon

        //위 코드를 람다식으로 변경 (인텔리제이 자동변경)
        name.forEach(s -> {
            System.out.println(s);
        });

        //위코드를 메소드 레퍼런스를 사용하여 변경 (인텔리제이 자동 변경)
        name.forEach(System.out::println);


        //Collection 의 기본메소드 stream() : 다음장에 제대로 다울 예정

        //removeIf() : 특정요소 제거
        name.removeIf(s -> s.startsWith("c")); //c로 시작하는 요소 제거
        name.forEach(s -> System.out.println(s));
        //실행결과
        //jinsol
        //yena
        //naeun
        //rachel

        //sort() 는 Comparator 함수형 인터페이스 사용
        name.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //return -1 은 o1을 앞으로
                //return 1 은 o2를 앞으로 함.
                if(o1.length() > o2.length()){
                    return -1;
                }else if(o1.length() < o2.length()){
                    return 1;
                }
                //같으면 0 리턴 변화없음
                return 0;
            }
        });
        name.forEach(s -> System.out.println(s));
        //실행결과  - 글자길이 순으로 정렬됨.
        //jinsol
        //rachel
        //naeun
        //yena

    }
}
