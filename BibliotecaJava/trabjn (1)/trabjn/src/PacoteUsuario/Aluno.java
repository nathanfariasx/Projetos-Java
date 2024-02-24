package PacoteUsuario;
import PacoteExceptionGeral.ExcedeuLimiteException;
import PacoteLivro.LivroFisico;
import PacoteUsuario.Usuario;
public class Aluno extends Usuario{
    private  int Matricula;

    public Aluno(String Nome, int matricula){
        super(Nome);
        this.Matricula = matricula;

    }


    public int getMatricula() {
        return Matricula;
    }

    public void setMatricula(int matricula) {
        Matricula = matricula;
    }
    @Override
    public  void pegarLivro(LivroFisico livro){
        super.pegarLivro(livro);
        if(LivroEmPosse.size() > 5){
            throw new ExcedeuLimiteException("Já chegou ao limite de 5 livros!");
        }
    }
    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append("Matricula: ").append(getMatricula())
                .toString();
    }
}
