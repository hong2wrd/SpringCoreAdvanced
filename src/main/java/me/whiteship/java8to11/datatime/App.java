package me.whiteship.java8to11.datatime;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {
    public static void main(String[] args) throws InterruptedException {
        //Date 지만 TimeStamp 임
        Date date = new Date();
        long time = date.getTime();
        System.out.println(date);
        System.out.println(time);

        //Mutable 한 객체, 객체의 상태를 바뀔 수 있음, 이 객체는 멀티쓰레트에서 안전하게 쓰기 어려움
        Thread.sleep(1000 * 3);
        Date after3Seconds = new Date();
        System.out.println(after3Seconds);
        after3Seconds.setTime(time);
        System.out.println(after3Seconds);

        // type safety 가 없음(타입 안정성), Mutable
        Calendar calendar = new GregorianCalendar(2023, Calendar.FEBRUARY, 22);
        System.out.println(calendar.getTime());
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        System.out.println(calendar.getTime());

        SimpleDateFormat dateFormat = new SimpleDateFormat();
    }
}
