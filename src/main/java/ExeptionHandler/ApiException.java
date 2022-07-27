package ExeptionHandler;

import org.springframework.http.HttpStatus;

public class ApiException extends Throwable {

    private final String message;
    private final HttpStatus httpStatus;

    public ApiException(String message,
                        HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
