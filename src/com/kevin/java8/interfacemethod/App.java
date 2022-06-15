package com.kevin.java8.interfacemethod;

public class App {
    public static void main(String[] args) {
        Foo foo = new DefaultFoo("leesh");

        //구현클래스의 Overriding 된 메소드 사용
        foo.printName(); //name

        //인터페이스의 디폴트 메소드 사용
        foo.printNameUpperCase(); //LEESH

        //인터페이스의 스태틱 메소드 사용
        Foo.printAnything(); // Anything
    }
}
