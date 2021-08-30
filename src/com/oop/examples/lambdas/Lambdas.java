package com.oop.examples.lambdas;

public class Lambdas {
    public static void main(String[] args) {

        String initial = "value";

        Reference reference = new ReferenceClass(initial);
        String actual = reference.apply(value -> value);// = reference.apply(Function.identity());
        System.out.println(initial.equals(actual));

        String actual2 = reference.apply(value -> value + value);
        System.out.println(initial.equals(actual2));

        String actual3 = reference.apply(Lambdas::transform);
        System.out.println(initial.equals(actual3));
        System.out.println(actual2.equals(actual3));

    }

    private static String transform(String value) {
        return value + value;
    }
}
