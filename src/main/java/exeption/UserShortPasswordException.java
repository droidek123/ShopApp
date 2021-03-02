package exeption;

public class UserShortPasswordException extends Exception {

    public UserShortPasswordException(){}

    public UserShortPasswordException(String message){
        super(message);
    }
}
