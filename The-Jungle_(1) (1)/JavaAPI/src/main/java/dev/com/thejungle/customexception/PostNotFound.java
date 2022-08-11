package dev.com.thejungle.customexception;

public class PostNotFound extends RuntimeException {
    public PostNotFound(String message) {
        super(message);
    }
}
