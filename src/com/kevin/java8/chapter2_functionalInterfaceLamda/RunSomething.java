package com.kevin.java8.chapter2_functionalInterfaceLamda;

/**
 *  강의 2-1. 함수형 인터페이스와 람다표현식 소개
 *
 *  함수형 인터페이스 (Functional Interface)
 *      추상메소드를 딱 하나만 가지고 있는 인터페이스
 */
//함수형인터페이스 일경우 어노테이션 명시
@FunctionalInterface
public interface RunSomething {
    //JAVA8에서 추가된 함수형 인터페이스
    //추상메서드를 딱 1개 가지는 인터페이스를 말함.
    void doIt();
}
