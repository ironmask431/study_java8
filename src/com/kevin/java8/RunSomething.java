package com.kevin.java8;

//함수형인터페이스 일경우 어노테이션 명시
@FunctionalInterface
public interface RunSomething {
    //JAVA8에서 추가된 함수형 인터페이스
    //추상메서드를 딱 1개 가지는 인터페이스를 말함.
    void doIt();
}
