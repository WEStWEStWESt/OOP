package com.oop.examples;

public class Main {
    public static void main(String[] args) {
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
        SimpleInterface anInterface = new SimpleInterface() {
            @Override
            public void print() {
                System.out.println("anonymous class without lambda");
            }
        };
        anInterface.print();
        // ----------------------------------------------------------------
        SimpleInterface simpleLambda = () -> System.out.println("in lambda");
        simpleLambda.print();
        // ----------------------------------------------------------------

        SimpleClass jc = new SimpleClass();
        System.out.println(jc.instanceVar);

        SimpleInterface inner = new SimpleClass().new Inner();

        SimpleClass.Nested.printStatic();
        SimpleClass.Nested nestedPublicClass = new SimpleClass.Nested();
        nestedPublicClass.print();
        nestedPublicClass.print2();

        /* создание "экземпляра" (nestedPublic) интерфейса SimpleInterface.*/
        SimpleInterface nestedPublic = nestedPublicClass;
        nestedPublic.print();

        // ----------------------------------------------------------------
//        com.oop.examples.JustClass.Nested.printStatic();
        // ----------------------------------------------------------------

    }
}
