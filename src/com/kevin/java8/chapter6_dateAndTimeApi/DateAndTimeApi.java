package com.kevin.java8.chapter6_dateAndTimeApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Date;

public class DateAndTimeApi {
    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date.getTime()); // 1654090738408 / 1654090775423 -> 1900년 1월1월 0시0분0초 기준 현재까지의 밀리초
        System.out.println(date); //Wed Jun 01 21:58:46 KST 2022

        Date date2 = new Date(117,8,21);
        System.out.println(date2); //Thu Sep 21 00:00:00 KST 2017

        //
        LocalDate localDate = LocalDate.of(2019,12,25);

        System.out.println(localDate.getYear()); // 2019
        System.out.println(localDate.getMonth()); // DECEMBER
        System.out.println(localDate.getDayOfMonth()); // 25
        System.out.println(localDate.getDayOfWeek()); // WEDNESDAY
        System.out.println(localDate.lengthOfMonth()); // 31 (달 일수)
        System.out.println(localDate.isLeapYear()); // false (윤년이 아님)

        LocalDate localDateToday = LocalDate.now();
        System.out.println(localDateToday); // 2022-06-01

        //
        LocalTime localTime = LocalTime.of(13,45,20);

        System.out.println(localTime); // 13:45:20
        System.out.println(localTime.getHour()); // 13
        System.out.println(localTime.getMinute()); // 45
        System.out.println(localTime.getSecond()); // 20

        LocalTime localTimeNow = LocalTime.now();

        System.out.println(localTimeNow); // 22:31:30.974735300
        System.out.println(localTimeNow.getHour()); // 22
        System.out.println(localTimeNow.getMinute()); // 31
        System.out.println(localTimeNow.getSecond()); // 30

        //
        LocalDateTime nowDateTime = LocalDateTime.now();
        LocalDateTime nowDateTime1 = LocalDateTime.of(2017, Month.APRIL,20,15,30,10);
        LocalDateTime nowDateTime2 = LocalDateTime.of(localDate, localTime);

        System.out.println(nowDateTime); // 2022-06-01T22:31:30.974735300
        System.out.println(nowDateTime1); // 2017-04-20T15:30:10
        System.out.println(nowDateTime2); // 2019-12-25T13:45:20




    }
}
