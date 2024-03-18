package by.it_academy.jd2.messages.core.exceptions;


import java.io.IOException;

public class UnauthorizedException extends IOException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
