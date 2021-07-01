package com.oop.examples.scope;

import com.oop.examples.SimpleInterface;

public class ScopeClass {

    public static final ScopeTypes PUBLIC_CONST = ScopeTypes.PUBLIC;
    protected static final ScopeTypes PROTECTED_CONST = ScopeTypes.PROTECTED;
    static final ScopeTypes PACKAGE_CONST = ScopeTypes.PACKAGE;
    private static final ScopeTypes PRIVATE_CONST = ScopeTypes.PRIVATE;

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
