package com.kevin.java8.functionalInterfaceLamda;

import javax.annotation.processing.Generated;

/**
 * 강의 2 - 함수형 인터페이스와 람다 = 4.메소드 레퍼런스
 */
public class Greeting {
    private String name;

    public Greeting(){}

    public Greeting(String name){
        this.name = name;
    }

    public String hello(String name){
        return "hello "+name;
    }

    public static String hi(String name){
        return "hi "+name;
    }

    public String getName(){
        return name;
    }
}
