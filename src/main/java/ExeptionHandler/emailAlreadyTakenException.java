package ExeptionHandler;

public class  emailAlreadyTakenException extends Exception{

    public emailAlreadyTakenException(String message) {
        super(message);
    }
}
