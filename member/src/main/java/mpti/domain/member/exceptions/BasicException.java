package mpti.domain.member.exceptions;

public class BasicException extends RuntimeException{
    public BasicException(){
    }
    public BasicException(String message){
        super(message);
    }
    public BasicException(String message, Throwable cause) {
        super(message, cause);
    }
    public BasicException(Throwable cause) {
        super(cause);
    }
}
