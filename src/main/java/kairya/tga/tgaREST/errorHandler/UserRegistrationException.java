package kairya.tga.tgaREST.errorHandler;

public class UserRegistrationException extends RuntimeException{
    public UserRegistrationException(String message){
        super(message);
    }
}
