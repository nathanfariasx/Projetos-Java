package PacoteExceptionGeral;

public class UsuarioNaoExisteException extends RuntimeException{
    public UsuarioNaoExisteException(String msg){
        super(msg);
    }
}