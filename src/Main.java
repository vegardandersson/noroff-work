import other_stuff.TestClass;


public class Main {
    public static void main(String[] args) {
        TestClass testClass = new TestClass("Hello world!");
        System.out.println(testClass.relayMessage());

        TestClass testClassEmpty = new TestClass();
        System.out.println(testClassEmpty.relayMessage());
    }
}