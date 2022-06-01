package morderJavaInAction;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class DateAndTimeApi {
    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date); //Wed Jun 01 21:58:46 KST 2022

        Date date2 = new Date(117,8,21);
        System.out.println(date2); //Thu Sep 21 00:00:00 KST 2017

        LocalDate localDate = LocalDate.of(2022,6,1);

        System.out.println(localDate.getYear()); // 2022
        System.out.println(localDate.getMonth()); // JUNE
        System.out.println(localDate.getDayOfMonth()); // 1
        System.out.println(localDate.getDayOfWeek()); // WEDNESDAY
        System.out.println(localDate.lengthOfMonth()); // 30 (이번달 일수)
        System.out.println(localDate.isLeapYear()); // false (윤년이 아님)

        LocalDate today = LocalDate.now();
        System.out.println(today); // 2022-06-01

        LocalTime time = LocalTime.of(13,45,20);

        System.out.println(time.getHour()); // 13
        System.out.println(time.getMinute()); // 45
        System.out.println(time.getSecond()); // 20

        LocalTime nowTime = LocalTime.now();

        System.out.println(nowTime.getHour()); // 22
        System.out.println(nowTime.getMinute()); // 15
        System.out.println(nowTime.getSecond()); // 31


    }
}
