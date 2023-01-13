package com.kevin.java8.chapter3_interfacemethod;

public interface Foo {

    void printName();

    String getName();

    /** 기본메소드 (디폴트 메소드).
     * 기존에는 인터페이스에 메소드를 추가하면 해당 인터페이스를 구현하는
     * 모든 클래스에 컴파일에러가 생김. (추가한 메소드를 구현클래스에도 모두 만들어줘야함)
     * 하지만 인터페이스 메소드앞에 default 를 달아주면, 컴파일에러없이 인터페이스에 내용이 있는 메소드 추가 가능.
     * 디폴트 메소드도 일반 인터페이스 메소드처럼 구현체에서 오버라이딩 해서 재정의 가능하다.
     */
    default void printNameUpperCase(){
        System.out.println(getName().toUpperCase());
    }

    /** static 메소드
     * 인터페이스에 스태틱 메소드로 추가하는 경우도 구현클래스들에 메소드 추가하지 않아도됨.
     * 스태틱 메소드는 구현클래스의 인스턴스를 생성할 필요없이 바로 사용가능함.
     */
    static void printAnything(){
        System.out.println("Anything");
    }
}
