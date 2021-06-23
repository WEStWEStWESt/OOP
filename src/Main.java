import com.oop.examples.SimpleInterface;

public class Main {
    public static void main(String[] args) {

        //TODO write the comments!!!

        SimpleInterface inner = new Nested();
        inner.print();

        Nested.printStatic();

        SimpleInterface normLambda = () -> System.out.println("in lambda");
        normLambda.print();

        SimpleInterface norm = new SimpleInterface() {
            @Override
            public void print() {
                System.out.println("anonimous class");
            }
        };
        norm.print();
    }

    private static class Nested implements SimpleInterface {

         static void printStatic() {
            System.out.println("in static inner");
        }

        @Override
        public void print() {
            System.out.println("in inner class");
        }
    }
}
