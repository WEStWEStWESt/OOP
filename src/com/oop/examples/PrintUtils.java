package com.oop.examples;

import com.oop.examples.scope.ScopeTypes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Set;

public final class PrintUtils {

    public static final String METHOD_PRINT_FORMAT = "type [%s] inside [%s], method [%s]%s%s\n";
    public static final Set<String> MODIFIERS = Set.of("private", "protected", "public");

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

    public static void print(ClassTypes classType, Method method) {
        String modifier = resolveModifier(method);
        System.out.printf(METHOD_PRINT_FORMAT, classType, method.getDeclaringClass(), method.getName(),
                String.format(" with modifier [%s].", modifier),
                classType.getDescription());
    }

    public static void print(Method method) {
        print(ClassTypes.CLASS, method);
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

    public static void printMethod(Class<?> type) {
        printMethod(ClassTypes.CLASS, type);
    }

    public static void printMethod(ClassTypes classTypes, Class<?> type) {
        String methodName = resolveMethodName();
        try {
            Method declaredMethod = type.getDeclaredMethod(methodName);
            print(classTypes, declaredMethod);
        } catch (NoSuchMethodException e) {
            System.out.println("Method [" + methodName + "] in class [" + type.getSimpleName() + "] is not found.");
        }
    }

    private static String resolveModifier(Method method) {
        String modifier = Modifier.toString(method.getModifiers());
        String firstModifier = modifier.contains(" ") ? modifier.substring(0, modifier.indexOf(" ")) : modifier;
        if ("".equals(modifier) || !MODIFIERS.contains(firstModifier)) {
            modifier = "package-private";
        } else {
            modifier = firstModifier;
        }
        return modifier;
    }

    private static String resolveMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements) {
            if (Thread.class.getName().equals(element.getClassName())) {
                continue;
            }
            if (!PrintUtils.class.getName().equals(element.getClassName())) {
                return element.getMethodName();
            }
        }
        return "Unknown method";
    }
}
