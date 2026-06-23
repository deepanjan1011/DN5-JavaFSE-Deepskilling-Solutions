public class Logger {
    private static volatile Logger instance;

    private Logger() {
        System.out.println("Logger instance created.");
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Logging utility methods
    public void log(String message) {
        System.out.println("[LOG]   : " + message);
    }

    public void warn(String message) {
        System.out.println("[WARN]  : " + message);
    }

    public void error(String message) {
        System.out.println("[ERROR] : " + message);
    }
}
