package com.oop.examples.lambdas;

import java.util.Objects;

public class Lambdas {
    public static void main(String[] args) {
        String initial = "value";
        Reference reference = new ReferenceClass(initial);
        String actual = reference.apply(referenceClassField -> {
            return referenceClassField;
        });
        // = reference.apply(Function.identity());
        System.out.println(actual);

        /*
        1. Объявление и инициализация локальной переменной initial типа String, строковым литералом "value".
        2. Объявление и инициализация локальной переменной reference типа Reference, экземпляром ReferenceClass,
           в конструктор которого передается значение преременной initial.
        3. Конструктор ReferenceClass инициализирует поле класса value значением, переданным в конструктор.
        4. Объявление и инициализация локальной переменной actual типа String, вызовом метода apply
           экземпляра ReferenceClass.
        4.1 В метод apply передается ЛЯМБДА-ВЫРАЖЕНИЕ, соответствующее типу Function<String, String>.
            ДЖЕНЕРИК интерфейса Function описывает тип входящего и исходящего значений <вх, вых>.
        4.2 В момент выполнения ЛЯМБДА-ВЫРАЖЕНИЯ, ЗНАЧЕНИЕ ВХОДЯЩЕГО ПАРАМЕТРА БЕРЁТСЯ ИЗ АРГУМЕНТА,
            ПЕРЕДАВАЕМОГО В МЕТОД APPLY() ИНТЕРФЕЙСА Function ВЫЗЫВАЕМОГО В МЕТОДЕ APPLY КЛАССА ReferenceClass.
        !!! РЕЗУЛЬТАТ ПРЕОБРАЗОВАНИЯ ЗНАЧЕНИЯ: ("result [" + value + "] obtained via Function")
            ОСУЩЕСТВЛЁННОГО В МЕТОДЕ APPLY() КЛАССА ReferenceClass,
            ИЗВЕСТЕН ЛЯМБДА-ВЫРАЖЕНИЮ ДО ФОРМАЛЬНОГО ЗАХОДА В ЭТОТ МЕТОД !!!!!

            По сути, при отработке ЛЯМБДА-ВЫРАЖЕНИЯ происходит обращение к функциональному интерфейсу Function
             и его методу R apply(T var1);
             Т.к. для реализации этого метода в этот момент уже необходимо иметь некое значение,
             то ЛЯМБДА-ВЫРАЖЕНИЕ ПРОХОДИТ ПО КОДУ ВПЕРЁД И
             ИЗВЛЕКАЕТ РЕЗУЛЬТАТ ПРЕОБРАЗОВАНИЯ ЗНАЧЕНИЯ: ("result [" + value + "] obtained via Function"),
             ОСУЩЕСТВЛЁННОГО В МЕТОДЕ APPLY() КЛАССА ReferenceClass ДО ФОРМАЛЬНОГО ЗАХОДА В ЭТОТ МЕТОД...


        4.3  В теле метода apply() класса ReferenceClass,
             осуществляется фактически возврат значения: ("result [" + value + "] obtained via Function")
             из ЛЯМБДА-ВЫРАЖЕНИЯ(см.выше !!!!) и это значение возвращается из метода apply() КЛАССА ReferenceClass.

        5. Даннго типа ЛЯМБДА-ВЫРАЖЕНИЕ: (referenceClassField -> referenceClassField),
           описывается методом интерфеса Function.identity(). Аргумент переданный в ЛЯМБДА-ВЫРАЖЕНИЕ
           возвращается без изменений!
           */

        String actual2 = reference.apply(referenceClassField -> referenceClassField + referenceClassField);
        System.out.println(initial.equals(actual2));

        String actual3 = reference.apply(Lambdas::transform);
        System.out.println(initial.equals(actual3));
        System.out.println(actual2.equals(actual3));

        reference.consume(Lambdas::print);
        reference.consume(referenceClassField ->
                System.out.println("result [" + referenceClassField + "] printed via Consumer."));

        reference.supply(String::new);
        reference.supply(() -> new String());

        System.out.println(reference.predicate(referenceClassField -> referenceClassField == null));
        /*System.out.println(reference.predicate(Objects::nonNull));
        System.out.println(reference.predicate(initial::equals));*/

    }

    private static String transform(String value) {
        return value + value;
    }

    private static void print(String value) {
        System.out.println("result [" + value + "] printed via method print() of Lambdas.");
    }

}
