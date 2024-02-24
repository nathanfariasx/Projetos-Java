package PacoteUsuario;
import PacoteExceptionGeral.ExcedeuLimiteException;
import PacoteExceptionGeral.TipoInvalidoException;
import PacoteLivro.Livro;
import PacoteLivro.LivroFisico;
import PacoteLivro.LivroDigital;
import java.util.ArrayList;
import java.util.List;
public class Usuario {
    private String Nome;
    protected List<LivroFisico> LivroEmprestado = new ArrayList<LivroFisico>();
    protected List<LivroFisico> LivroEmPosse = new ArrayList<LivroFisico>();
    private List<LivroDigital> LivroBaixados = new ArrayList<LivroDigital>();
    public Usuario() {

    }
    public Usuario(String nome) {

        this.Nome = nome;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public List<LivroFisico> getLivroEmprestado() {
        return LivroEmprestado;
    }

    public List<LivroFisico> getLivroEmPosse() {
        return LivroEmPosse;
    }

    public void pegarLivro(LivroFisico livro) {
        if(LivroEmPosse.contains(livro)){
            throw new ExcedeuLimiteException("nao pode pegar um livro duas vezes !");
        }else {
            LivroFisico   livroDesejado = (LivroFisico) livro;

            LivroEmPosse.add(livro);
            LivroEmprestado.add(livro);
            livro.emprestar();

        }
    }

    public void devolverLivro(LivroFisico livro){
        if(livro instanceof LivroFisico){
            LivroFisico livroParaDevolver = (LivroFisico) livro;
            LivroEmPosse.remove(livroParaDevolver);
            LivroEmprestado.add(livroParaDevolver);
            livroParaDevolver.devolver();
        }else {
            throw new  TipoInvalidoException("nao aceita livro digital !!!");
        }

    }

    public void baixarLivros(LivroDigital livro){
        LivroBaixados.add(livro);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Usuario{");
        sb.append("Nome='").append(Nome).append('\'');
        sb.append(", LivroEmprestado=").append(LivroEmprestado);
        sb.append(", LivroEmPosse=").append(LivroEmPosse);
        sb.append(", LivroBaixados=").append(LivroBaixados);
        sb.append('}');
        return sb.toString();
    }
}