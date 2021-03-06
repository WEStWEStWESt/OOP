package com.oop.examples.basics;

import com.oop.examples.ClassTypes;
import com.oop.examples.PrintUtils;
import com.oop.examples.SimpleInterface;

public class Basics {

    public static void main(String[] args) {
        /*
        ЛОКАЛЬНЫЙ КЛАСС.
        1. Объявляется в рамках одного метода.
        2. Не может быть статическим.
        3. Может быть абстрактным.
        4. Объект локального класса не может создаваться за пределами метода или блока, в котором его объявили.
        5. В локальных классах нельзя объявлять статические инициализаторы (блоки инициализации) или интерфейсы.
           Но у локальных классов могут быть статические члены при условии, что они постоянные переменные(static final).

        ПРИМЕНЕНИЕ:
        - для обработки сложно-структурированных данных(коллекции, массивы, CSV-файлы, таблицы БД...),
        приходящих в метод.
         - для улучшения читабельности кода, его масштабируемости и для обработки данных в максимально понятном виде.
         ПРИМЕЧАНИЕ: ПО ВОЗМОЖНОСТИ НЕ ДОПУСКАТЬ НЕОБХОДИМОСТИ СОЗДАНИЯ ЛОКАЛЬНЫХ КЛАССОВ.
        */
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
       3. Не доступен классам извне,за исключением
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

        ПРИМЕНЕНИЕ:
        - для описания специфической(особенной) реализции известного ранее поведения(интерфейс, класс).
         Есть известное ранее поведение(например SimpleInterface()). Требуется описать его
         специфичную реализацию, обрабатывающую данные, котрорые передать в SimpleInterface() невозможно, при
         штатном его использовании. Например, необходимы данные из массива String[] args метода main().
         В обычном режиме передать их в SimpleInterface() невозможно(метод print() не принимает никаких параметров).
       */
        SimpleInterface anonymous = new SimpleInterface() {

            @Override
            public void print() {
                PrintUtils.print(ClassTypes.ANONYMOUS, getClass());
            }
        };
        anonymous.print();
        // ----------------------------------------------------------------
        /*
        ЛЯМБДА-ВЫРАЖЕНИЕ предствленное ниже, делает тоже самое, что и АНОНИМНЫЙ КЛАСС, описанный выше.
        Разница лишь в упрощении(уменьшении) написания кода.
        */
        SimpleInterface lambda = () -> PrintUtils.print(ClassTypes.LAMBDA, Basics.class);
        lambda.print();
        // ----------------------------------------------------------------

        new EmptyClass().print();

        SimpleInterface simpleClass = new SimpleClass();
        simpleClass.print();

        /*  INNER - ВНУТРЕННИЙ класс.



         ПРИМЕНЕНИЕ:
         - иногда разумно описывать класс в пространстве имен внешнего класса(как член внешнего класса),
           особенно когда он будет использоваться в рамках данного внешнего класса.
         - внешние классы имеют специальный доступ к переменным/полям содержащихся в них внутренних классов И НАОБОРОТ!
           (переменные/поля зависят от типа вложенного класса:
            статические переменные/поля внутреннего класса могут обарщаться только к статич.пер/полям внешнего).
         - исчезает необходимость создания отдельного нового файла для такого вида класса,
           т.к. он будет использован только в контексте внешнего класса.
           */

        SimpleInterface inner = new SimpleClass().new Inner();
        inner.print();

        /* NESTED - ВЛОЖЕННЫЙ (всегда STATIC)



         ПРИМЕНЕНИЕ:
         - иногда разумно описывать класс в пространстве имен внешнего класса(как член внешнего класса),
           особенно когда он будет использоваться в рамках данного внешнего класса.
         - СТАТИЧЕСКИЕ МЕТОДЫ ВЛОЖЕННОГО КЛАССА ИМЕЮТ ДОСТУП И РАБОТАЮТ ТОЛЬКО СО СТАТИЧЕСКИМИ МЕТОДАМИ и ПЕРЕМЕННЫМИ
           ВНЕШНЕГО КЛАССА.
           НО: ЭКЗЕМПЛЯР ВНЕШНЕГО КЛАССА ИМЕЕТ ДОСТУП К СТАТИЧЕСКИМ И НЕ СТАТИЧЕСКИМ МЕТОДАМ И ПЕРЕМЕННЫМ ВЛОЖЕННОГО КЛ!
         - исчезает необходимость создания отдельного нового файла для такого вида класса,
           т.к. он будет использован только в контексте внешнего класса.
        */

        //создание "экземпляра" (nested) интерфейса SimpleInterface.
        SimpleInterface nested = new SimpleClass.Nested();
        nested.print();

        // ----------------------------------------------------------------
        SimpleClass.Nested.printStatic();
        // ----------------------------------------------------------------
    }
}
