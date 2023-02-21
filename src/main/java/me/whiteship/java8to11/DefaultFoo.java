package me.whiteship.java8to11;

import org.apache.tomcat.util.net.jsse.JSSEUtil;

public class DefaultFoo implements Foo1, Bar1{

    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    /**
     * implements 하는 인터페이스에 다 default method 가 있으면 어느걸 쓸지 정해줘야 함
     */
    @Override
    public void printNameUpperCase() {
        Bar1.super.printNameUpperCase();
    }

    @Override
    public String getName() {
        return this.name;
    }
}
