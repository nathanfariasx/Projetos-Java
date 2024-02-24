package PacoteLivro;
import PacoteLivro.Livro;
public class LivroFisico extends Livro{
    private  int CopiasDisponiveis;
    public LivroFisico(String Titulo, String AnoPublicacao, String Autor,int CopiasDisponiveis) {
        super(Titulo,AnoPublicacao,Autor);
        this.CopiasDisponiveis = CopiasDisponiveis;
    }
    public int getCopiasDisponiveis() {
        return CopiasDisponiveis;
    }
    public void setCopiasDisponiveis(int copiasDisponiveis) {
        CopiasDisponiveis = copiasDisponiveis;
    }
    public void emprestar() {
        this.CopiasDisponiveis -=1;

    }
    public void devolver() {
        this.CopiasDisponiveis += 1;
    }

    @Override
    public String toString() {
        return "LivroFisico{" +
                "CopiasDisponiveis=" + CopiasDisponiveis +
                ", Titulo='" + Titulo + '\'' +
                ", AnoPublicacao='" + AnoPublicacao + '\'' +
                ", Autor='" + Autor + '\'' +
                '}';
    }
}
