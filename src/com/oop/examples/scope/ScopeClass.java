package com.oop.examples.scope;

import com.oop.examples.SimpleInterface;

public class ScopeClass {

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
