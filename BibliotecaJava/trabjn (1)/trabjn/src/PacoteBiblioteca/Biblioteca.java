package PacoteBiblioteca;
import PacoteExceptionGeral.*;
import PacoteLivro.*;
import PacoteLivro.Livro;
import PacoteLivro.LivroDigital;
import PacoteLivro.LivroFisico;
import PacoteUsuario.Aluno;
import PacoteUsuario.Professor;
import PacoteUsuario.Usuario;



import java.util.ArrayList;
import java.util.List;

public class Biblioteca{
    List<Livro> livro ;
    List<Usuario> usuario ;



    public Biblioteca() {
        livro = new ArrayList<Livro>();
        usuario = new ArrayList<Usuario>();
    }

    public void LivrosDisponiveis(){
        for(Livro L : livro ){
            System.out.println(L);
        }
    }

    public void printarUsuarios(){
        for(Usuario U: usuario){
            System.out.println(U);
        }
    }

    public List<Livro> getLivro() {
        return livro;
    }

    public List<Usuario> getUsuario() {
        return usuario;
    }



    public void cadastrarUsuario(Usuario U) {
        for(Usuario usuario2 : usuario){
            if(usuario2 instanceof Aluno && U instanceof Aluno && ((Aluno) usuario2).getMatricula()==((Aluno)U).getMatricula()){
                throw new UsuarioJaCadastradoException("Aluno ja esta cadastrado no sistema !");
            } else if (usuario2 instanceof Professor && U instanceof Professor && ((Professor) usuario2).getCodigo()==((Professor)U).getCodigo()) {
                throw new UsuarioJaCadastradoException("Professor ja esta cadastrado no sistema !");
            }
        }
        usuario.add(U);
    }

    public void cadastrarLivro(Livro L){
        this.livro.add(L);
    }

    public void printarLivros(){
        for(Livro L : livro){
            System.out.println(L);
        }
    }

    public List<Livro> buscarLivro(String Titulo) {
        List<Livro> acheiLivro = new ArrayList<>();
        if(!livro.isEmpty()){
            for (Livro L : livro) {
                if(L.getTitulo().equalsIgnoreCase(Titulo)) {
                    acheiLivro.add(L);
                }
            }
        }
        return acheiLivro;
    }

    public LivroFisico seExisteFisico(String Titulo){
        for( Livro livro : livro){
            if(livro instanceof LivroFisico && ((LivroFisico)livro).getTitulo().equalsIgnoreCase(Titulo)){
                return (LivroFisico) livro;
            }
        }
        throw new LivroNaoAchadoException("livro nao encontrado");
    }

    public LivroDigital seExisteDigital(String Titulo){
        for( Livro livro : livro){
            if(livro instanceof LivroDigital && ((LivroDigital)livro).getTitulo().equalsIgnoreCase(Titulo)){
                return (LivroDigital) livro;
            }
        }
        throw new LivroNaoAchadoException("livro nao encontrado");
    }

    public Usuario buscarUsuario(int id){
        for(Usuario usuario3 : usuario){
            if(usuario3 instanceof Aluno && ((Aluno)usuario3).getMatricula()==id){
                return usuario3;
            } else if (usuario3 instanceof Professor && ((Professor) usuario3).getCodigo() == id){
                return usuario3;
            }
        }
        throw new UsuarioNaoExisteException("usuario nao existe !!!");
    }


    public void realizarEmprestimo(Usuario U , Livro L) {
            U.pegarLivro((LivroFisico) L);
    }

    public void devolverEmprestimo(Usuario Usuario , Livro livro) {
        if(livro instanceof LivroFisico){
            LivroFisico livroRetorno = (LivroFisico) livro;
            Usuario AcheiUsuario = null;
            for(Usuario usuario : usuario){
                if(usuario.equals(usuario)){
                    AcheiUsuario = usuario;
                    break;
                }
            }
            if(AcheiUsuario == null){
                throw new UsuarioNaoExisteException("usuario nao existe");
            }
            if(AcheiUsuario.getLivroEmPosse().contains(livroRetorno)){
                AcheiUsuario.devolverLivro(livroRetorno);
            }else{
                throw  new NaoPossuiException("nao aceita livro Digital");
            }
        }
        else{
            throw  new TipoInvalidoException("nao aceita livro Digital");
        }



    }
}
