import PacoteBiblioteca.Biblioteca;
import PacoteLivro.LivroFisico;
import PacoteLivro.LivroDigital;
import PacoteBiblioteca.Biblioteca;
import PacoteLivro.Livro;
import PacoteUsuario.Aluno;
import PacoteUsuario.Professor;
import PacoteUsuario.Usuario;
import PacoteExceptionGeral.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String tipoUser;
        int opcao;
        int acesso;
        String nome;
        int matricula;
        int codigo;
        String tipo;
        String Formato;
        double Tamanho;
        String URL;
        String AnoPublicacao;
        String Autor;
        int CopiasDisponiveis;
        int Id;
        String resp;
        String titulo;
        boolean aG = false;
        boolean aA = false;
        boolean aP = false;
        boolean aB = false;
        Biblioteca bib = new Biblioteca();
        Usuario usu = new Usuario();
        Scanner in = new Scanner(System.in);

        bib.cadastrarUsuario(new Professor("marcos",001));
        bib.cadastrarUsuario(new Professor("andre",002));
        bib.cadastrarUsuario(new Professor("pedro",003));
        bib.cadastrarUsuario(new Professor("lucas",004));
        bib.cadastrarUsuario(new Professor("fulano",005));
        bib.cadastrarUsuario(new Aluno("joao",100));
        bib.cadastrarUsuario(new Aluno("nathan",200));
        bib.cadastrarUsuario(new Aluno("mathias",300));
        bib.cadastrarUsuario(new Aluno("luiz",400));
        bib.cadastrarUsuario(new Aluno("bia",500));
        bib.cadastrarUsuario(new Aluno("ana",600));
        bib.cadastrarLivro(new LivroFisico("java","2003","joao vitor",3));
        bib.cadastrarLivro(new LivroFisico("pyhton","2103","nathan",3));
        bib.cadastrarLivro(new LivroFisico("c","2003","pedro",3));
        bib.cadastrarLivro(new LivroDigital("java","2003","joelso","PDF",222,"http://livro1"));
        bib.cadastrarLivro(new LivroDigital("javaScript","2003","carlos","PDF",222,"http://livro2"));
        bib.cadastrarLivro(new LivroDigital("java","2003","edilson","PDF",222,"http://livro3"));
        try {
            System.out.println("Digite seu nível de acesso:\n1 - Aluno\n2 - Professor \n3 - Bibliotecário");
            acesso = in.nextInt();
            if (acesso == 1) {
                int matri;
                int opcaoAluno = 0;
                System.out.println("Digite sua matricula: ");
                matri = in.nextInt();
                Usuario aluno = bib.buscarUsuario(matri);
                if (aluno != null) {
                    while (!aA) {
                        System.out.println("(1) - Pegar Livro\n(2) - Devolver Livro\n(3) - Baixar Livro");
                        opcaoAluno = in.nextInt();
                        switch (opcaoAluno) {
                            case 1:
                                System.out.println("Digite o titulo do livro: ");
                                titulo = in.nextLine();
                                LivroFisico livro = bib.seExisteFisico(titulo);
                                usu.pegarLivro(livro);
                                break;

                            case 2:
                                System.out.println("Digite o livro que deseja devolver: ");
                                titulo = in.nextLine();

                                LivroFisico livro1 = bib.seExisteFisico(titulo);
                                usu.devolverLivro(livro1);
                                break;

                            case 3:
                                System.out.println("Digite o titulo que deseja baixar: ");
                                titulo = in.nextLine();
                                LivroDigital livro2 = bib.seExisteDigital(titulo);
                                usu.baixarLivros(livro2);
                                break;
                        }
                        System.out.println("O aluno ");
                        aA = !desejaCont().equals("false");
                    }
                } else {
                    throw new UsuarioNaoExisteException("Você não esta cadastrado no sistema!");
                }


            } else if (acesso == 2) {

                int cod;

                int opcaoProf;
                while (!aP) {
                    System.out.println("(1)-Pegar Livro\n(2)-Devolver Livro\n(3)-Baixar Livro");
                    opcaoProf = in.nextInt();
                    System.out.println("Digite seu código: ");
                    cod = in.nextInt();
                    Usuario prof = bib.buscarUsuario(cod);
                    if (prof != null) {
                        switch (opcaoProf) {
                            case 1:
                                System.out.println("Digite o título do livro: ");
                                titulo = in.nextLine();
                                LivroFisico livro = bib.seExisteFisico(titulo);
                                usu.pegarLivro(livro);
                                break;

                            case 2:
                                System.out.println("Digite o livro que deseja devolver: ");
                                titulo = in.nextLine();
                                ;
                                LivroFisico livro1 = bib.seExisteFisico(titulo);
                                usu.devolverLivro(livro1);
                                break;

                            case 3:
                                System.out.println("Digite o titulo que deseja baixar: ");
                                titulo = in.nextLine();
                                LivroDigital livro2 = bib.seExisteDigital(titulo);
                                usu.baixarLivros(livro2);
                                break;
                        }
                        System.out.println("o professor ");
                        aP = !desejaCont().equals("false");
                    } else {
                        throw new UsuarioNaoExisteException("Você não esta cadastrado no sistema!");
                    }

                }


            } else if (acesso == 3) {
                int senha = 13245;
                int senhaD;
                int opera;

                System.out.println("Digite sua senha de acesso: ");
                senhaD = in.nextInt();

                if (senhaD == senha) {
                    while (!aB) {
                        System.out.println("Digite a operação desejada:\n1 - Cadastrar usuário \n 2- Cadastrar livro \n3- Buscar livro \n4 -Buscar usuario \n5 -Realizar emprestimo \n6- Devolver emprestimo");

                        opera = in.nextInt();
                        switch (opera) {
                            case 1: // Cadastrar Usuário
                                in.nextLine();
                                System.out.println("Aluno ou professor?");
                                tipoUser = in.nextLine();
                                System.out.println("Digite o nome: ");
                                nome = in.nextLine();
                                if (Olhada(tipoUser) == 1) {
                                    System.out.println("Digite a matricula: ");
                                    matricula = in.nextInt();
                                    bib.cadastrarUsuario(new Aluno(nome, matricula));
                                } else if (Olhada(tipoUser) == 2) {
                                    in.nextLine();
                                    System.out.println("Digite o código: ");
                                    codigo = in.nextInt();
                                    bib.cadastrarUsuario(new Professor(nome, codigo));
                                } else {
                                    throw new SenhaIncorretaException("Senha Incorreta!");
                                }
                                break;

                            case 2: // Cadastrar Livro
                                in.nextLine();
                                System.out.println("Digite o tipo do livro: ");
                                tipo = in.nextLine().toLowerCase();

                                if (tipo.equals("digital")) {
                                    System.out.println("Digite o título do livro: ");
                                    titulo = in.nextLine();
                                    System.out.println("Digite o ano de publicação do livro: ");
                                    AnoPublicacao = in.nextLine();
                                    System.out.println("Digite o Autor do livro: ");
                                    Autor = in.nextLine();
                                    System.out.println("Digite o formato do livro: ");
                                    Formato = in.nextLine();
                                    System.out.println("Digite o tamanho do livro: ");
                                    Tamanho = in.nextDouble();
                                    System.out.println("Digite a URL do livro: ");
                                    URL = in.nextLine();
                                    bib.cadastrarLivro(new LivroDigital(titulo, AnoPublicacao, Autor, Formato, Tamanho, URL));
                                } else if (tipo.equals("fisico")) {
                                    System.out.println("Digite o título do livro: ");
                                    titulo = in.nextLine();
                                    System.out.println("Digite o ano de publicação do livro: ");
                                    AnoPublicacao = in.nextLine();
                                    System.out.println("Digite o Autor do livro: ");
                                    Autor = in.nextLine();
                                    System.out.println("Digite copias disponiveis do livro: ");
                                    CopiasDisponiveis = in.nextInt();
                                    bib.cadastrarLivro(new LivroFisico(titulo, AnoPublicacao, Autor, CopiasDisponiveis));
                                } else {
                                    throw new OpcaoInvalidaException("Opção Inválida!");
                                }
                                bug();
                                break;

                            case 3: //Buscar Livro
                                System.out.println("O livro que deseja procurar é Digital ou  Fisico?");
                                resp = in.nextLine().toLowerCase();

                                if (resp.equals("digital")) {
                                    System.out.println("Digite o titulo que deseja buscar: ");
                                    titulo = in.nextLine();
                                    bib.seExisteDigital(titulo);
                                } else if (resp.equals("fisico")) {
                                    System.out.println("Digite o titulo que deseja buscar: ");
                                    titulo = in.nextLine();
                                    bib.seExisteFisico(titulo);
                                } else {
                                    throw new OpcaoInvalidaException("Opção Inválida!");
                                }
                                bug();
                                break;

                            case 4: //Buscar usuário
                                System.out.println("Aluno ou professor?");
                                tipoUser = in.nextLine();
                                if (Olhada(tipoUser) == 1) {
                                    System.out.println("Digite a matrícula do aluno que deseja encontrar: ");
                                    Id = in.nextInt();
                                    bib.buscarUsuario(Id);
                                } else if (Olhada(tipoUser) == 2) {
                                    System.out.println("Digite o código do professor que deseja encontrar: ");
                                    Id = in.nextInt();
                                    bib.buscarUsuario(Id);
                                } else {
                                    throw new UsuarioNaoExisteException("Usuário não encontrado!");
                                }
                                bug();
                                break;

                            case 5: // Realizar emprestimo
                                System.out.println("Digite o ID do usuario: ");
                                Id = in.nextInt();
                                Usuario user = bib.buscarUsuario(Id);
                                System.out.println("Digite o livro que deseja alugar: ");
                                titulo = in.nextLine().toLowerCase();
                                LivroFisico livro = bib.seExisteFisico(titulo);
                                bib.realizarEmprestimo(user, livro);

                                bug();
                                break;

                            case 6: // Devolver emprestimo
                                System.out.println("Digite o ID do usuário: ");
                                Id = in.nextInt();
                                Usuario user1 = bib.buscarUsuario(Id);
                                System.out.println("Digite o livro que deseja devolver: ");
                                titulo = in.nextLine().toLowerCase();
                                LivroFisico livro1 = bib.seExisteFisico(titulo);
                                bib.devolverEmprestimo(user1, livro1);
                                bug();
                                break;

                        }
                        System.out.println("o bibliotecário ");
                        aB = !desejaCont().equals("false");
                    }
                }
            }
        } catch (OpcaoInvalidaException e) {
            System.out.println(e.getMessage());
        } catch (ExcedeuLimiteException e) {
            System.out.println(e.getMessage());
        } catch (UsuarioNaoExisteException e) {
            System.out.println(e.getMessage());
        } catch (NaoPossuiException e){
            System.out.println(e.getMessage());
        } catch (TipoInvalidoException e){
            System.out.println(e.getMessage());
        } catch (UsuarioJaCadastradoException e) {
            System.out.println(e.getMessage());
        } catch (SenhaIncorretaException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa Encerrado!");
        }
    }


    public static String desejaCont () {
        Scanner in = new Scanner(System.in);
        String vaiOuNao;
        String retorno;
        System.out.println("deseja continuar? (sim/nao) ");
        vaiOuNao = in.nextLine().toLowerCase();
        if (vaiOuNao.equals("sim")) {
            retorno = "false";
        } else {
            retorno = "true";
        }
            return retorno;
        }

        public static int Olhada (String tipoUser){
            int tipo = 0;

            if (tipoUser.toLowerCase().equals("aluno")) {
                tipo = 1;
            } else if (tipoUser.toLowerCase().equals("professor")) {
                tipo = 2;
            } else {
                System.out.println("tipo usuario invalido ");
            }
            return tipo;
        }

        public static void bug () {
            Scanner in = new Scanner(System.in);
            in.nextLine();
        }
    }
