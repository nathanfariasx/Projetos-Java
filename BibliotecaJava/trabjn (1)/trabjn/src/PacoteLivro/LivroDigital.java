package PacoteLivro;
import PacoteLivro.Livro;
public class LivroDigital extends  Livro{
    private String  Formato;
    private double Tamanho;
    private String URL;

    public LivroDigital(String Titulo, String AnoPublicacao, String Autor,String Formato,double Tamanho,String URL) {
        super(Titulo, AnoPublicacao, Autor);
        this.Formato = Formato;
        this.Tamanho = Tamanho;
        this.URL = URL;

    }

    public String getFormato() {
        return Formato;
    }

    public void setFormato(String formato) {
        Formato = formato;
    }

    public double getTamanho() {
        return Tamanho;
    }

    public void setTamanho(double tamanho) {
        Tamanho = tamanho;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "LivroDigital{" +
                "Formato='" + Formato + '\'' +
                ", Tamanho=" + Tamanho +
                ", URL='" + URL + '\'' +
                '}';
    }
}