package com.sotogito.ioc.section01.xmlconfig;

public class Calculator {

    public void plus(int a, int b) {
        System.out.printf("%d + %d = %d\n", a, b, a+b);
    }

    public void minus(int a, int b) {
        System.out.printf("%d - %d = %d\n", a, b, a-b);
    }

    public void mul(int a, int b) {
        System.out.printf("%d * %d = %d\n", a, b, a*b);
    }

    public void div(int a, int b) {
        System.out.printf("%d / %d = %d\n", a, b, a/b);
    }

}

