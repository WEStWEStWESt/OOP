package com.oop.examples;

public interface SimpleInterface {
    default void print() {
        System.out.println("inside [" + getClass() + "], method [" + Thread.currentThread().getStackTrace()[1].getMethodName() + "].");
    }
}
