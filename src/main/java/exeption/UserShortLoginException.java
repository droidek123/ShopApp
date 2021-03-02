package exeption;

public class UserShortLoginException extends Exception {
    public UserShortLoginException(){}

    public UserShortLoginException(String message){
        super(message);
    }
}
