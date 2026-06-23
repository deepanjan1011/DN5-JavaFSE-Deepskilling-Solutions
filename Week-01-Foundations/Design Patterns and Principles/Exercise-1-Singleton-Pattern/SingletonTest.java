public class SingletonTest {

    public static void main(String[] args) {

        System.out.println("=== Singleton Pattern Test ===\n");

        Logger logger1 = Logger.getInstance();
        logger1.log("Application started.");

        Logger logger2 = Logger.getInstance();
        logger2.warn("This is a warning message.");
        logger2.error("This is an error message.");

        System.out.println();

        System.out.println("=== Verification ===");
        System.out.println("logger1 hashCode: " + logger1.hashCode());
        System.out.println("logger2 hashCode: " + logger2.hashCode());

        System.out.println();

        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both references point to the SAME instance. Singleton works!");
        } else {
            System.out.println("FAILED: Different instances were created. Singleton is broken.");
        }
    }
}
