package PacoteUsuario;
import PacoteUsuario.Usuario;
public class Professor extends Usuario{
    private  int Codigo;

    public Professor(String Nome,int codigo){
        super(Nome);
        this.Codigo = codigo;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "Codigo=" + Codigo +
                ", LivroEmprestado=" + LivroEmprestado +
                ", LivroEmPosse=" + LivroEmPosse +
                ", LivroBaixados="
                ;
    }
}
