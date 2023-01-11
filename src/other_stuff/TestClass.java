package other_stuff;

public class TestClass {

    private final String message;

    public TestClass() {
        this.message = "No message defined yet";
    }
    public TestClass(String message) {
        this.message = message;
    }

    public String relayMessage() {
        return this.message;
    }

}
