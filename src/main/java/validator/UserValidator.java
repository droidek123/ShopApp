package validator;

import entity.User;
import exeption.UserLoginAlreadyExistException;
import exeption.UserShortLoginException;
import exeption.UserShortPasswordException;

public class UserValidator {

    private static final int MIN_LENGTH_PASSWORD = 6;
    private static final int MIN_LENGTH_LOGIN = 4;

    private UserValidator(){}

    private static UserValidator instance = new UserValidator();


    public static UserValidator getInstance(){
        if(instance == null){
            instance = new UserValidator();
        }
        return instance;
    }

    public boolean isValidate(User user) throws UserLoginAlreadyExistException, UserShortLoginException, UserShortPasswordException {

    }

    private boolean isUserLoginAlreadyExistException(User user) throws UserLoginAlreadyExistException {
        if(user.getLogin().length() >= MIN_LENGTH_LOGIN){
            return true;
        }
        else {
            return false;
        }
    }
}
