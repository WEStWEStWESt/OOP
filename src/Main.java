import com.oop.examples.SimpleInterface;

public class Main {
    public static void main(String[] args) {

        //TODO write the comments!!!

        SimpleInterface inner = new Nested();
        inner.print();

        Nested.printStatic();

        SimpleInterface simpleLambda = () -> System.out.println("in lambda");
        simpleLambda.print();

        /*
        АНОМИМНЫЙ КЛАСС.
        */
        SimpleInterface anInterface = new SimpleInterface() {
            @Override
            public void print() {
                System.out.println("anonymous class");
            }
        };
        anInterface.print();
    }

    /*
    ВНУТРЕННИЙ СТАТИЧЕСКИЙ класс назавется ВЛОЖЕННЫМ СТАТИЧЕСКИМ КЛАССОМ(NESTED).
    Такой класс(объект такого класса) НЕ ИМЕЕТ ССЫЛКУ на ВНЕШНИЙ класс(объект внешнего класса)!

    Статический ВЛОЖЕННЫЙ класс(Nested). Реализует интрерфейс SimpleInterface и
    переопределяет его метод print().
    Также класс Nested может иметь и свои СТАТИЧЕСКИЕ МЕТОДЫ, как например printStatic().

     */

    private static class Nested implements SimpleInterface {

        @Override
        public void print() {
            System.out.println("in inner class");
        }

        static void printStatic() {
            System.out.println("in static inner");
        }
    }
}
