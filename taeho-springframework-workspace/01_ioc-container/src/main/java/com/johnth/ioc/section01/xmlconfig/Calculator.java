package com.johnth.ioc.section01.xmlconfig;

public class Calculator {
    public void plus(int x, int y) {
        System.out.printf("%d + %d = %d\n", x, y, x+y);
    }
    public void minus(int x, int y) {
        System.out.printf("%d - %d = %d\n", x, y, x-y);
    }
    public void multiply(int x, int y) {
        System.out.printf("%d * %d = %d\n", x, y, x*y);
    }
    public void divide(int x, int y) {
        System.out.printf("%d / %d = %d\n", x, y, x/y);
    }

}
