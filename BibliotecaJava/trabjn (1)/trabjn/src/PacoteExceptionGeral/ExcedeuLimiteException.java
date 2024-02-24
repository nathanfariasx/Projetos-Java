package PacoteExceptionGeral;

public class ExcedeuLimiteException extends RuntimeException {
    public ExcedeuLimiteException(String msg){
        super(msg);
    }

}