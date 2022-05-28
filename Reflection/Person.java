package Reflection;

public class Person {

    private String name;
    int age;

    public Person() {
        System.out.println("New person created!");
    }

    public Person(String name) {
        System.out.println("New person, Name: " + name);
    }

    Person(String name, int age) {
        System.out.println("New person, Name: " + name + ", Age: " + age);
    }

    void hello() {
        System.out.println("Hello!");
    }

    void greet(String name) {
        System.out.println("Hello " + name + "!");
    }

    int add(int x, int y) {
        return x + y;
    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + "]";
    }

}