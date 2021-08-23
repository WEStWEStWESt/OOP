package com.oop.examples;

import com.oop.examples.scope.ScopeTypes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public final class PrintUtils {

    public static final String METHOD_PRINT_FORMAT = "type [%s] inside [%s], method [%s]%s%s\n";

    public static void print(Class<?> type) {
        print(ClassTypes.CLASS, type);
    }

    public static void print(ClassTypes classType, Class<?> type) {
        System.out.printf(METHOD_PRINT_FORMAT, classType, type,
                Thread.currentThread().getStackTrace()[2].getMethodName(), ".", classType.getDescription());
    }

    /* Т.к getClass() не хранит состояния объекта(экземпляра), чтобы получить имя ТЕКУЩЕГО метода,
   необходимо обращаться к стеку. Экземпляры классов Thread, Exception или Throwable
   содержат очередь вызова методов в стеке(через вызов метода getStackTrace ...
   Exception и Throwable исключают сам метод getStackTrace).
          Thread.currentThread().getStackTrace()[0]  - getStackTrace();
          Thread.currentThread().getStackTrace()[1]  - PrintUtils.print();
          Thread.currentThread().getStackTrace()[2]  - SimpleInterface.print().
*/
    public static void print(Object scopeType, Class<?> type) {
        System.out.println("[" + scopeType + "] variable of [" + type + "].");
    }

    /**
     * Т.к. получить значение у приватного поля обычными способами невозможно,
     * применяется Рефлексия.
     *
     * @param privateField private field name.
     * @param type         target object type.
     */
    public static void printStaticPrivate(String privateField, Class<?> type) {
        String value;
        try {
            //По имени поля осуществляется его поиск в переданном типе.
            //Если вхождение найдено, то из getDeclaredField возвращаются метаданные поля.
            //В противном случае выбрасывается NoSuchFieldException.
            Field declaredField = type.getDeclaredField(privateField);
            /*
              В метаданных поля меняестя флаг доступности, т.е. становится НЕ PRIVATE !
              ПРИ ЭТОМ МОДИФИКАТОР ДОСТУПА САМОГО ПОЛЯ НЕ ИЗМЕНЯЕТСЯ!*/
            declaredField.setAccessible(true);
            /*
              По метаданным поля получается его действительное значение.
              Метод get() принимает экземпляр объекта,
              значение поля которого требуется извлечь. При этом, если поле статическое,
              то get() принимает null.
            */
            Object object = declaredField.get(null);
            if (object instanceof ScopeTypes) {
                value = object.toString();
            } else {
                value = "Wrong type";
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            value = "Unknown field";
        }
        print(value, type);
    }

    public static void print(ClassTypes classType, Method method) {
        String modifier = Modifier.toString(method.getModifiers());
        if ("".equals(modifier) //TODO add a condition to verify package-private static
         ) {
            modifier = "package-private";
        }
        System.out.printf(METHOD_PRINT_FORMAT, classType, method.getDeclaringClass(), method.getName(),
                String.format(" with modifier [%s].", modifier),
                classType.getDescription());
    }

    public static void print(Method method) {
        print(ClassTypes.CLASS, method);
    }

    public static void printMethod(Class<?> type) {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        try {
            Method declaredMethod = type.getDeclaredMethod(methodName);
            print(declaredMethod);
        } catch (NoSuchMethodException e) {
            System.out.println("Method [" + methodName + "] in class [" + type.getSimpleName() + "] is not found.");
        }
    }
}
