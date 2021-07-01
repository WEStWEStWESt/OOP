package com.oop.examples.basics;

public final class PrintUtils {

    public static void print(Class<?> type) {
        print(ClassTypes.CLASS, type);
    }

    public static void print(ClassTypes classType, Class<?> type) {
        System.out.println("type [" + classType + "] inside [" + type + "], method [" + Thread.currentThread().getStackTrace()[2].getMethodName() + "].");
    }
        /* Т.к getClass() не хранит состояния объекта(экземпляра), чтобы получить имя ТЕКУЩЕГО метода,
       необходимо обращаться к стеку. Экземпляры классов Thread, Exception или Throwable
       содержат очередь вызова методов в стеке(через вызов метода getStackTrace ...
       Exception и Throwable исключают сам метод getStackTrace).
              Thread.currentThread().getStackTrace()[0]  - getStackTrace();
              Thread.currentThread().getStackTrace()[1]  - PrintUtils.print();
              Thread.currentThread().getStackTrace()[2]  - SimpleInterface.print().
    */
}
