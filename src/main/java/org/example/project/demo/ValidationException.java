package org.example.project.demo;

/**
 * Nuosava situacija, panaudota dialogo struktūrose įvedamų parametrų
 * tikrinimui.
 */
public class ValidationException extends RuntimeException {

    // Situacijos reikšmė
    private final String value;

    public ValidationException(String message) {
        this(message, "");
    }

    public ValidationException(String message, String value) {
        super(message);
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
