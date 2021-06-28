import com.oop.examples.SimpleInterface;
    /*
       АНОМИМНЫЙ КЛАСС.
       0. Создаётся один раз в момент инициализации объекта. +-
       1. Не имеет имени. +-
       2. Не имеет явного конструктора(можно вызвать конструктор суперкласса!).
       3. Не доступен кслассам извне,за исключением
           неявного обращения посредством объектной ссылки
           на суперкласс или интерфейс.
       4. НИКОГДА не могут быть СТАТИЧЕСКИМИ или АБСТРАКТНЫМИ. +-
       5. Не может содержать статические переменные и методы.
       6. В конце ставится  ;  [точка с запятой].
          Одновременно объявляется класс (посредством фигурных скобок) и
          создаётся его объект с помощью   ();
       7. Каждый анонимный класс объявляется внутри выражения.
       8. Имеет доступ КО ВСЕМ ПОЛЯМ ВНЕШНЕГО КЛАССА (ДАЖЕ PRIVATE !!!!!)
       9. Может реализовывать только один интерфейс либо наследовать один класс.

       */
    /*
    ВНУТРЕННИЙ СТАТИЧЕСКИЙ класс назавется ВЛОЖЕННЫМ СТАТИЧЕСКИМ КЛАССОМ(NESTED).
    Такой класс(объект такого класса) НЕ ИМЕЕТ ССЫЛКУ на ВНЕШНИЙ класс(объект внешнего класса)!

    Статический ВЛОЖЕННЫЙ класс(Nested) реализует интрерфейс SimpleInterface и
    переопределяет его метод print().
    Также класс Nested может иметь и свои СТАТИЧЕСКИЕ МЕТОДЫ, как например printStatic().
    Простой пример:
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

public class Main {
    public static void main(String[] args) {

        SimpleInterface anInterface = new SimpleInterface() {
            @Override
            public void print() {
                System.out.println("anonymous class without lambda");
            }
        };
        anInterface.print();
// ----------------------------------------------------------------
        /* создание "экземпляра интерфейса" inner.*/
        SimpleInterface inner = new Nested();
        inner.print();
// ----------------------------------------------------------------
        Nested.printStatic();
// ----------------------------------------------------------------
        SimpleInterface simpleLambda = () -> System.out.println("in lambda");
        simpleLambda.print();
    }

    private static class Nested implements SimpleInterface {

        @Override
        public void print() {
            System.out.println("Override method in inner class.");
        }

//        --- ??? not static---
        public void printStatic2() {
            System.out.println("Not static method.");
        }

        static void printStatic() {
            System.out.println("Static method.");
        }
    }
}



