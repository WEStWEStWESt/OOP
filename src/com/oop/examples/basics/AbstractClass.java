package com.oop.examples.basics;

import com.oop.examples.ClassTypes;
import com.oop.examples.PrintUtils;
import com.oop.examples.SimpleInterface;

public abstract class AbstractClass implements SimpleInterface {

    @Override
    public void print() {
        PrintUtils.print(ClassTypes.ABSTRACT, getClass());
    }
}
