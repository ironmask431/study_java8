package com.kevin.java8.optional;

import com.kevin.java8.stream.OnlineClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App2 {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api dev", false));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        boolean present = optional.isPresent();
        System.out.println(present); //true

        optional.ifPresent(oc -> System.out.println(oc.getTitle()));

        OnlineClass onlineClass;

        //onlineClass = optional.get(); //optional 내부에 값 없을때 에러발생

        onlineClass = optional.orElse(createOnlineClass()); // optional 내부값 이 없을때 else의 개체 가져옴.
        //orElse 는 optional 내부값 이 있든없든 무조건 실행됨.

        onlineClass = optional.orElseGet(App2::createOnlineClass);// optional 내부값 이 없을때 elseGet 의 개체 가져옴.
        //orElseGet 은  optional 내부값 이 없을때만 실행됨.

        onlineClass = optional.orElseThrow(()-> new RuntimeException("없어"));
        //exception 발생시키고자 할때
    }

    private static OnlineClass createOnlineClass(){
        System.out.println("createOnlineClass 실행");
        return new OnlineClass(1,"new", true);
    }
}
