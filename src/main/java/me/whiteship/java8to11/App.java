package me.whiteship.java8to11;

import java.util.*;
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


        //인터페이스 기본 메서드와 스태틱 메서드
        Foo1 foo1 = new DefaultFoo("hong");
        foo1.printName();
        foo1.printNameUpperCase();

        Foo1.printAnything();

        //자바8 API의 기본 메소드와 스태틱 메소드
        List<String> names1 = new ArrayList<>();
        names1.add("hong");
        names1.add("whiteship");
        names1.add("toby");
        names1.add("foo");

        names1.forEach(System.out::println);
        System.out.println("==============");

        Spliterator<String> spliterator = names1.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("=================");
        while (spliterator1.tryAdvance(System.out::println));
        System.out.println("=================");

        long h = names1.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("H"))
                .count();
        System.out.println(h);
        System.out.println("=================");

//        names1.removeIf(s -> s.startsWith("h"));
//        names1.forEach(System.out::println);
//        System.out.println("=================");

        names1.sort(String::compareToIgnoreCase);
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;;
        names1.sort(compareToIgnoreCase.reversed());
        names1.forEach(System.out::println);


    }
}