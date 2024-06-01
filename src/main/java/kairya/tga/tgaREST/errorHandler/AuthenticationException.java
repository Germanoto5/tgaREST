package kairya.tga.tgaREST.errorHandler;

public class AuthenticationException extends RuntimeException{
    public AuthenticationException(String message){
        super(message);
    }
}
