package com.sb.test.java8;

public class AnnotationRunner {

    public void method1() {
        System.out.println("method1");
    }

    @CustomAnnotation(author = "uranium", canRun = false)
    public void method2() {
        System.out.println("method2");
    }

    public void method3() {
        System.out.println("method3");
    }

    @CustomAnnotation(author = "muraniu")
    public void method4() {
        System.out.println("method4");
    }

}