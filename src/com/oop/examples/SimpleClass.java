package com.oop.examples;

/*
    ВНУТРЕННИЙ СТАТИЧЕСКИЙ класс назавется ВЛОЖЕННЫМ СТАТИЧЕСКИМ КЛАССОМ(NESTED).
    Такой класс(объект такого класса) НЕ ИМЕЕТ ССЫЛКУ на ВНЕШНИЙ класс(объект внешнего класса)!

    Статический ВЛОЖЕННЫЙ класс(Nested) реализует интрерфейс SimpleInterface и
    переопределяет его метод print().
    Также класс Nested может иметь и свои СТАТИЧЕСКИЕ МЕТОДЫ, как например printStatic().
    Пример "вложенных" классов:
          class Base {
          void method1() {
          }
          void method2() {
          }
        }

        class A { // нормальный класс

          static class B {
          } // статический вложенный класс

          class C {
          } // вложенный и внутренний класс

          void f() {
            class D {
            } // локальный внутренний класс
          }

          void g() {
            // анонимный класс
            Base bref = new Base() {
              void method1() {
              }
            };
          }
        }
     */

public class SimpleClass implements SimpleInterface {

    // КОНСТАНТА КЛАССА.
    public static final int CLASS_CONST = 1;

    // Переменная класса.
    public static int classVar = 2;

    //Константа экземпляра класса SimpleClass.
    public final int instanceConst = 3;

    // Переменная экземпляра.
    public int instanceVar = 4;

    /*
    Переопределение метода НЕ ОБЯЗАТЕЛЬНО, т.к. интерфейса уже есть реализация по умолчанию(default).
    Приведённое ниже переопределение метода НЕ ИМЕЕТ СМЫСЛА, т.к. полностью повторяет реализацию по умолчанию.

    @Override
    public void print() {
        System.out.println("in [" + getClass() + "], method [" + Thread.currentThread().getStackTrace()[1].getMethodName() + "].");
    }
    */

    public class Inner implements SimpleInterface {
        /*
        Нельзя создать СТАТИЧЕСКИЙ МЕТОД в НЕСТАТИЧЕСКОМ ВНУТРЕННЕМ классе,
        т.к.статический метод или класс НЕ ХРАНИТ СОСТОЯНИЕ ВНЕШНЕГО КЛАССА(не содержат ссылку на него).
        static void printStatic(){
        } */
    }

    public static class Nested implements SimpleInterface {

        /* В статическом методе невозможно обратиться к методу getClass(),
           т.к. СТАТИЧЕСКИЙ МЕТОД НЕ ИМЕЕТ СОСТОЯНИЯ(нет экземпляра [this.]).
           */
        public static void printStatic() {
            System.out.println("inside [" + Nested.class + "], method [" + Thread.currentThread().getStackTrace()[1].getMethodName() + "].");
        }
    }
}



