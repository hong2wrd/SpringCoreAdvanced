package me.whiteship.java8to11;

import java.util.function.*;

public class Foo {

    public static void main(String[] args) {
        int baseNumber = 10;
        //익명 내부 클래스 anonymous inner class
        RunSomething runSomething = new RunSomething() {
            @Override
            public int doIt(int number) {
                return number + baseNumber;
            }
        };
        System.out.println(runSomething.doIt(1));

        //함수형 인터페이스
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));

        Function<Integer, Integer> plus11 = (i) -> i +10;
        System.out.println(plus11.apply(1));

        Function<Integer, Integer> multiply2 = (i) -> i * 2;
        System.out.println(multiply2.apply(1));

        Function<Integer, Integer> multiply2AndPlus11= plus11.compose(multiply2); //입력값이 뒤에서 앞으로
        System.out.println(multiply2AndPlus11.apply(2));

        System.out.println(plus11.andThen(multiply2).apply(2)); //입력값이 앞에서 뒤로

        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10);

        Predicate<String> startsWithKeesun = (s) -> s.startsWith("keesun");
        Predicate<Integer> isEven = (i) -> i%2 == 0;

        UnaryOperator<Integer> plus12 = (i) -> i +10; //입력값과 결과값을 타입이 같을 경우에 사용(UnaryOperator)
        System.out.println(plus11.apply(1));


        //람다 표현식
        Supplier<Integer> get11 = () -> 11;
        Supplier<Integer> get12 = () -> {
            return 12;
        };

        BiFunction<Integer, Integer, Integer> sum1 = (a, b) -> a + b;
        BinaryOperator<Integer> sum2 = (a, b) -> a + b;
        BinaryOperator<Integer> sum3 = (Integer a, Integer b) -> a + b;

        Foo foo = new Foo();
        foo.run();

    }

    private void run() {
        int baseNumber = 10; // 사실상 final 선언됨

        // Local class start
        class LocalClass {
            int baseNumber = 11;
            void printBaseNumber() {
                System.out.println(baseNumber); // 11
            }
        }
        // Local class end

        // Anonymous class start
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer + baseNumber);
            }
        };
        // Anonymous class end

        /**
         * Local, Anonymous 는 변수가 쉐도잉(Shadowing)이 됨
         * Lambda 는 쉐도잉이 일어나지 않음(같은 스코프이기 때문에)
         */

        // Lambda
        Consumer<Integer> printInt1 = (i) -> System.out.println(i);
        IntConsumer printInt2 = (i) -> {
            System.out.println(i + baseNumber);
        };
        printInt2.accept(10);
    }
}
