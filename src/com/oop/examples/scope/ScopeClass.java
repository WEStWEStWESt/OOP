package com.oop.examples.scope;

import com.oop.examples.PrintUtils;
import com.oop.examples.SimpleInterface;

public class ScopeClass implements SimpleInterface {

    public static final ScopeTypes PUBLIC_CONST = ScopeTypes.PUBLIC;
    protected static final ScopeTypes PROTECTED_CONST = ScopeTypes.PROTECTED;
    static final ScopeTypes PACKAGE_CONST = ScopeTypes.PACKAGE;
    private static final ScopeTypes PRIVATE_CONST = ScopeTypes.PRIVATE;

    @Override
    public void print() {
        PrintUtils.printMethod(getClass());
    }

    protected void printProtected() {
        PrintUtils.printMethod(getClass());
    }

    void printPackagePrivate() {
        PrintUtils.printMethod(getClass());
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
