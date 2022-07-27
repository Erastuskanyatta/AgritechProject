package ExeptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler {
@ExceptionHandler(value = {IllegalStateException.class})
    public ResponseEntity<Object>
    handleApiRequestException(IllegalStateException e){
        // exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
         ApiException apiException = new ApiException(
                  e.getMessage(),
                  badRequest
          );
        // returning response entity
        return new ResponseEntity<>(apiException, badRequest);
    }

}
