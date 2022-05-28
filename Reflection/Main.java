package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException,
            IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException,
            InstantiationException {

        Person person = new Person();

        Class<? extends Person> classObj = person.getClass();

        Class<?> classObj2 = Class.forName("Reflection.Person");

        Field[] fields = classObj.getDeclaredFields();

        for (Field field : fields) {

            System.out.println("Name: " + field.getName());
            System.out.println("Type: " + field.getType());

            if (field.getType() == Integer.TYPE) {

                System.out.println("Ein Integer!");

            }
        }

        Field SField = classObj.getDeclaredField("age");

        SField.set(person, 56);
        System.out.println("set age: " + person);

        Object value = SField.get(person);

        System.out.println(value);

        SField = classObj.getDeclaredField("name");

        int modifier = SField.getModifiers();

        System.out.println("Modifier: " + modifier);
        System.out.println("dekodiert: " + Modifier.toString(modifier));

        SField.setAccessible(true);
        SField.set(person, "Hello");

        System.out.println(person);

        Method[] methods = classObj.getDeclaredMethods();

        for (Method method : methods) {

            // 1
            System.out.println("Name: " + method.getName());
            System.out.println("ParameterCount: " + method.getParameterCount());
            System.out.println("Return Types: " + method.getReturnType());

            // 2

            System.out.println("Param Types: " +
                    Arrays.toString(method.getParameterTypes()));

        }

        Method method = classObj.getDeclaredMethod("hello", null);

        method.invoke(person);

        Method method2 = classObj.getDeclaredMethod("greet", String.class);

        method2.invoke(person, "Domenic");

        Method method3 = classObj.getDeclaredMethod("add", Integer.TYPE, Integer.TYPE);

        System.out.println(method3.invoke(person, 5, 9));

        Constructor<?>[] constructor = classObj.getDeclaredConstructors();

        for (Constructor<?> constructor2 : constructor) {

            System.out.println("Name: " + constructor2.getName());
            System.out.println("ParameterCount: " + constructor2.getParameterCount());
        }

        Constructor<? extends Person> constructor2 = classObj.getDeclaredConstructor();

        constructor2.newInstance();

        Constructor<? extends Person> constructor3 = classObj.getDeclaredConstructor(String.class);

        constructor3.newInstance("Domenic");

        Constructor<? extends Person> constructor4 = classObj.getDeclaredConstructor(String.class, Integer.TYPE);

        constructor4.newInstance("Domenic", 19);

    }
}