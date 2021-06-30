package com.oop.examples.basics;

import com.oop.examples.SimpleInterface;

public class Main {
    public static void main(String[] args) {
        class Local extends AbstractClass {

            @Override
            public void print() {
                PrintUtils.print(ClassTypes.LOCAL, getClass());
            }
        }
        new Local().print();
        /*
       АНОМИМНЫЙ КЛАСС.
       0. Создаётся один раз в момент инициализации объекта.
       1. Не имеет имени.
       2. Не имеет явного конструктора(можно вызвать конструктор суперкласса!).
       3. Не доступен кслассам извне,за исключением
           неявного обращения посредством объектной ссылки
           на суперкласс или интерфейс.
       4. НИКОГДА не могут быть СТАТИЧЕСКИМИ или АБСТРАКТНЫМИ.
       5. Не может содержать статические переменные и методы.
       6. В конце ставится  ;  [точка с запятой].
          Одновременно объявляется класс (посредством фигурных скобок) и
          создаётся его объект с помощью   ();
       7. Каждый анонимный класс объявляется внутри выражения.
       8. Имеет доступ КО ВСЕМ ПОЛЯМ ВНЕШНЕГО КЛАССА (ДАЖЕ PRIVATE !!!!!)
       9. Может реализовывать только один интерфейс либо наследовать один класс.

       */
        SimpleInterface anonymous = new AbstractClass() {

            @Override
            public void print() {
                PrintUtils.print(ClassTypes.ANONYMOUS, getClass());
            }
        };
        anonymous.print();
        // ----------------------------------------------------------------
        SimpleInterface lambda = () -> PrintUtils.print(ClassTypes.LAMBDA, Main.class);
        lambda.print();
        // ----------------------------------------------------------------

        new EmptyClass().print();

        SimpleInterface simpleClass = new SimpleClass();
        simpleClass.print();


        SimpleInterface inner = new SimpleClass().new Inner();
        inner.print();

        /* создание "экземпляра" (nested) интерфейса SimpleInterface.*/
        SimpleInterface nested = new SimpleClass.Nested();
        nested.print();

        // ----------------------------------------------------------------
        SimpleClass.Nested.printStatic();
        // ----------------------------------------------------------------
    }
}
