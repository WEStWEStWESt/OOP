package com.oop.examples.lambdas;

public class Lambdas {
    public static void main(String[] args) {

        String initial = "value";

        Reference reference = new ReferenceClass(initial);
        String actual = reference.apply(referenceClassField -> referenceClassField);// = reference.apply(Function.identity());
        System.out.println(actual);

        String actual2 = reference.apply(referenceClassField -> referenceClassField + referenceClassField);
        System.out.println(initial.equals(actual2));

        String actual3 = reference.apply(Lambdas::transform);
        System.out.println(initial.equals(actual3));
        System.out.println(actual2.equals(actual3));

        reference.consume(Lambdas::print);
        reference.consume(referenceClassField ->
                System.out.println("result [" + referenceClassField + "] printed via Consumer."));

    }

    private static String transform(String value) {
        return value + value;
    }

    private static void print(String value) {
        System.out.println("result [" + value + "] printed via method print() of Lambdas.");
    }

}
