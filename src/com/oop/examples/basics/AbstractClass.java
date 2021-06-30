package com.oop.examples.basics;

import com.oop.examples.SimpleInterface;

public class AbstractClass implements SimpleInterface {

    @Override
    public void print() {
        PrintUtils.print(ClassTypes.ABSTRACT, getClass());
    }
}
