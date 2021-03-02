package exeption;

public class UserLoginAlreadyExistException extends Exception {

    public UserLoginAlreadyExistException(String message){
        super(message);
    }

    public UserLoginAlreadyExistException(){}
}
