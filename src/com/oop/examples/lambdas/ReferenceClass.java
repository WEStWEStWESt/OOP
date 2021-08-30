package com.oop.examples.lambdas;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ReferenceClass implements Reference{

    private final String value;

    public ReferenceClass(String value) {
        this.value = value;
    }

    @Override
    public String apply(Function<String, String> function) {
        return function.apply(value);
    }

    @Override
    public void consume(Consumer<String> consumer) {
        consumer.accept(value);
    }

    @Override
    public String supply(Supplier<String> supplier) {
        return supplier.get();
    }

    @Override
    public boolean predicate(Predicate<String> predicate) {
        return predicate.test(value);
    }
}
