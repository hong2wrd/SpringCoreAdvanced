package me.whiteship.java8to11;

public interface Bar extends Foo1{

    /**
     * Foo1에 있는 default 메소드를 사용하지 않으려면
     * 추상메소드로 정의해주면 됨
     */
    void printNameUpperCase();

}
