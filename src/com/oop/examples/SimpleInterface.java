package com.oop.examples;

public interface SimpleInterface {

    default void print() {
        PrintUtils.print(getClass());
    }
}
