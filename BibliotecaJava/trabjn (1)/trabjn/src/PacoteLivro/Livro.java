package PacoteLivro;

public class Livro {
    protected String Titulo;
    protected String AnoPublicacao;
    protected String Autor;
    public Livro(String Titulo,String AnoPublicacao,String Autor) {
        this.Titulo = Titulo;
        this.AnoPublicacao = AnoPublicacao;
        this.Autor = Autor;
    }
    @Override
    public String  toString(){
        return "Título: " + this.Titulo + " \nAno: " + this.AnoPublicacao + "\nAutor   :" + this.Autor;
    }

    public  String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        Titulo = Titulo;
    }

    public String getAnoPublicacao() {
        return AnoPublicacao;
    }

    public void setAnoPublicacao(String anoPublicacao) {
        AnoPublicacao = anoPublicacao;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }
}
