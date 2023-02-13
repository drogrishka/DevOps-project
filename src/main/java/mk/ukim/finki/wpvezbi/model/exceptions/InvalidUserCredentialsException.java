package mk.ukim.finki.wpvezbi.model.exceptions;

public class InvalidUserCredentialsException extends  RuntimeException {
    public InvalidUserCredentialsException(){
        super("Invalid user credentials exception");
    }
}
