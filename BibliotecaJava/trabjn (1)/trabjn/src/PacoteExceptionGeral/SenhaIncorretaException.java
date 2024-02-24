package PacoteExceptionGeral;

public class SenhaIncorretaException extends RuntimeException{
    public SenhaIncorretaException(String msg){
        super(msg);
    }
}