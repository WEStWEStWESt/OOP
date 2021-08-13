package com.oop.examples.scope;

import com.oop.examples.SimpleInterface;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ScopeClass implements SimpleInterface{

    public static final ScopeTypes PUBLIC_CONST = ScopeTypes.PUBLIC;
    protected static final ScopeTypes PROTECTED_CONST = ScopeTypes.PROTECTED;
    static final ScopeTypes PACKAGE_CONST = ScopeTypes.PACKAGE;
    private static final ScopeTypes PRIVATE_CONST = ScopeTypes.PRIVATE;

    @Override
    public void print() {
        try {
            Method print = getClass().getDeclaredMethod("print");
            Modifier.toString(print.getModifiers());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static class Nested implements SimpleInterface {

        @Override
        public void print() {
            System.out.println("Override method in nested class.");
        }

        void print2() {
            System.out.println("Not static method.");
        }

        static void printStatic() {
            System.out.println("Static method.");
        }
    }
}
