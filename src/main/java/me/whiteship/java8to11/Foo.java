package me.whiteship.java8to11;

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
    }
}
