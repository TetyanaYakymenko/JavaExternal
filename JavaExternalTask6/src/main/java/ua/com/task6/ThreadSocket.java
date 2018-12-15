package ua.com.task6;

public class ThreadSocket {
    private static ThreadSocket ourInstance = new ThreadSocket();

    public static ThreadSocket getInstance() {
        return ourInstance;
    }

    private ThreadSocket() {
    }
}
