package PacoteExceptionGeral;

public class LivroNaoAchadoException extends RuntimeException {
    public LivroNaoAchadoException(String msg){
        super(msg);
    }
}
