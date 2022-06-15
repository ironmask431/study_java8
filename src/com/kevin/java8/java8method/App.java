package com.kevin.java8.java8method;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class App {
    public static void main(String[] args) {

        List<String> name = new ArrayList<String>();
        name.add("chawon");
        name.add("jinsol");
        name.add("yena");
        name.add("naeun");

        //forEach 는 매개변수로 Consumer 함수형 인터페이스가 들어감.
        name.forEach(new Consumer<String>() {
           @Override
           public void accept(String s) {
                System.out.println(s);
            }
        });

        //위 코드를 람다식으로 변경
        name.forEach(s -> {
            System.out.println(s);
        });

        //위코드를 메소드 레퍼런스를 사용하여 변경
        //(인텔리제이 자동 변경)
        name.forEach(System.out::println);
    }
}
