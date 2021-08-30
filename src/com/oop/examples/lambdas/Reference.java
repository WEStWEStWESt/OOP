package com.oop.examples.lambdas;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface Reference {

    String apply(Function<String, String> function);

    void consume(Consumer<String> consumer);

    String supply(Supplier<String> supplier);

    boolean predicate(Predicate<String> predicate);
}
