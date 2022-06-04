package com.kevin.java8.functionalInterfaceLamda;

import java.util.Date;

/**
 * java8 - Date와 Time 소개
 *
 * 자바 8에 새로운 날짜와 시간 API가 생긴 이유
 * ● 그전까지 사용하던 java.util.Date 클래스는 mutable 하기 때문에 thead safe하지 않다.
 * 여러 스레드가 동시제 자원에 접근가능함. 버그발생 가능성이 높음.
 * ● 클래스 이름이 명확하지 않다. Date인데 시간까지 다룬다.
 * ● 버그 발생할 여지가 많다. (타입 안정성이 없고, 월이 0부터 시작한다거나..)
 * ● 날짜 시간 처리가 복잡한 애플리케이션에서는 보통 Joda Time을 쓰곤했다.
 */
public class DateAndCalendar {

    public static void main(String[] args) {
        Date date = new Date();
        long time = date.getTime(); //Date 인데 시간까지 표시된다고? 이상하다.
        System.out.println("time="+time); //time = 1653661235206
        // 표시되는 시간도 이상하게보임. 1900년을 기준으로 지난 밀리세컨드 표시
        System.out.println("date="+date); // Fri May 27 23:22:38 KST 2022
    }
}
