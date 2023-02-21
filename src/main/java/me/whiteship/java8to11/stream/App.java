package me.whiteship.java8to11.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("hong");
        names.add("whiteship");
        names.add("toby");
        names.add("foo");

        names.stream().map((s) -> {
            System.out.println(s);
            // 출력되지않음, 중개형은 출력은 안하고, 종료형이 와야함.
            return s.toUpperCase();
        });
        System.out.println("=================");
        List<String> collect = names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());

        collect.forEach(System.out::println);
        System.out.println("=================");

        names.forEach(System.out::println);
        System.out.println("=================");

        List<String> collect1 = names.parallelStream().map(String::toUpperCase)
                .collect(Collectors.toList());
        collect1.forEach(System.out::println);

        /**
         * parallelStream() 멀티스레드를 이용
         *  병렬처리가 무조건 좋은 거는 아님, 무수히 방해한 자료 처리에 유용
         *  상황에 맞춰서 해야하며 실직적인 성능 차이를 구해보는것이 좋음
         */
        List<String> collect2 = names.parallelStream().map((s) ->{
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
                }).collect(Collectors.toList());
        collect2.forEach(System.out::println);

        List<String> collect3 = names.stream().map((s) ->{
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect3.forEach(System.out::println);
    }
}
