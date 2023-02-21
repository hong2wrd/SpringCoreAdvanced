package me.whiteship.java8to11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {

        Greeting greeting = new Greeting();
        //인스턴스 메소드를 사용하려면
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("1"));

        //static method 사용 방법
        UnaryOperator<String> hi = Greeting::hi;
        System.out.println(hi.apply("2"));

        //기본생성자를 접근하려면
        Supplier<Greeting> newGreeting = Greeting::new;
        newGreeting.get();

        //생성자를 접근하려면 (타입으로 생성자를 골라서 사용)
        Function<String, Greeting> keesunGreeting = Greeting::new;
        Greeting keesun = keesunGreeting.apply("keesun");
        System.out.println(keesun.getName());

        String[] names = {"keesun", "whiteship", "toby"};
        Arrays.sort(names, String::compareToIgnoreCase);
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
    }
}