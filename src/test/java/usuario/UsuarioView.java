package usuario;

import pessoas.Rebelde;
import pessoas.Traidor;
import service.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UsuarioView {

    //ATRIBUTOS
    private Scanner entrada;
    private Service service;
    private Rebelde rebelde;
    private Traidor traidor;

    //CONSTRUCTOR
    public UsuarioView(Scanner entrada, Service service, Rebelde rebelde, Traidor traidor) {
        entrada = new Scanner(System.in);
        service = new Service();
        rebelde = new Rebelde();
        traidor = new Traidor();
    }
    public UsuarioView() {

    }

    //MÉTODOS
    public void menuPrincipal(){
        System.out.println("ESCOLHA O NÚMERO EQUIVALENTE PARA INICIAR A FUNÇÃO DESEJADA: ");
        System.out.println("1) EXIBIR TODOS OS REBELDES CADASTRADOS");
        System.out.println("2) CADASTRAR NOVO MEMBRO");
        System.out.println("3) COMPRAR ITENS PARA O INVENTÁRIO");
        System.out.println("4) REPORTAR NOVA LOCALIZAÇÃO");
        System.out.println("5) REPORTAR MEMBRO POR TRAIÇÃO");
        System.out.println("6) OFICIALIZAR MEMBRO COMO TRAIDOR");
        System.out.println("7) EXIBIR INVENTÁRIO DE UM MEMBRO");
        System.out.println("8) EXIBIR RELATÓRIOS");
        System.out.println("9) MOSTRAR LISTA DE TRAIDORES OFICIALIZADOS");
        System.out.println("10) SAIR");

    }

    public void menuCompraPrincipal(){
        System.out.println("DIGITE O NÚMERO EQUIVALENTE AO ITEM QUE DESEJA COMPRAR: ");
        System.out.println("1) ARMA | VALOR = 100");
        System.out.println("2) MUNIÇÃO | VALOR = 30");
        System.out.println("3) ÁGUA | VALOR = 5");
        System.out.println("4) COMIDA | VALOR = 15");

    }

    public void menuCompraQtde(){
        System.out.println("DIGITE A QUANTIDADE DESEJADA DO ITEM: ");

    }

    public void menuLocalizacao(){
        System.out.println("DIGITE O NÚMERO EQUIVALENTE À SUA LOCALIZAÇÃO ATUAL: ");
        System.out.println("1) Base Corvo | Yavin 4");
        System.out.println("2) Base Echo | Hoth");
        System.out.println("3) Base em Dantooine | Dantooine");
        System.out.println("4) Base Falcão | Yavin 4");
        System.out.println("5) Estação Echo 3T8 | Hoth");
        System.out.println("6) Estação Echo 57 | Hoth");
        System.out.println("7) Grande Templo | Yavin 4");
        System.out.println("8) Posto Avançado de Crait | Crait");
    }
    public void menuIntro(){
        System.out.println("                  .==.\n" +
                "                   ()''()-.\n" +
                "        .---.       ;--; /\n" +
                "      .'_:___\". _..'.  __'.\n" +
                "      |__ --==|'-''' \\'...;\n" +
                "      [  ]  :[|       |---\\\n" +
                "      |__| I=[|     .'    '.\n" +
                "      / / ____|     :       '._\n" +
                "     |-/.____.'      | :       :\n" +
                "    /___\\ /___\\      '-'._----'");
        System.out.println();
        System.out.println("H e l p  m e  O b i - W a n  K e n o b i.  Y o u ' r e  m y  o n l y  h o p e!");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("SEJA BEM-VINDE AO SISTEMA DE GERENCIAMENTO DE MEMBROS DA ALIANÇA REBELDE.");
        System.out.println("QUE A FORÇA ESTEJA COM VOCÊ!");
        System.out.println("---------------------------------------------------------------------------");
    }

    public void iniciarPrograma(){
        Scanner entrada = new Scanner(System.in);
        Service service = new Service();
        menuIntro();
        while(true){
            menuPrincipal();
            int opcaoMenuPrincipal = entrada.nextInt();

            switch (opcaoMenuPrincipal){
                case 1:
                    service.exibirRebeldes();
                    break;
                case 2:
                    entrada.nextLine();
                    System.out.println("DIGITE O NOME:");
                    String nomeNovo = entrada.nextLine();
                    System.out.println("DIGITE A IDADE: ");
                    int idadeNova = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("DIGITE O GÊNERO: ");
                    String generoNovo = entrada.nextLine();
                    menuLocalizacao();
                    String novaLocalizacao = entrada.nextLine();
                    service.cadastrarNovoRebelde(nomeNovo, idadeNova, generoNovo,novaLocalizacao);
                    break;
                case 3:
                    System.out.println("DIGITE O ID DO REBELDE: ");
                    Long idVerifica = entrada.nextLong();
                    entrada.nextLine();
                    System.out.println("DIGITE O NOME DO REBELDE: ");
                    String nomeVerifica = entrada.nextLine();

                    if(service.rebeldeExiste(nomeVerifica)){
                        menuCompraPrincipal();
                        int opcaoCompra = entrada.nextInt();
                        menuCompraQtde();
                        int opcaoQte = entrada.nextInt();
                        service.comprarItensParaInventario(idVerifica,opcaoCompra,opcaoQte);
                        break;
                    }else{
                        System.out.println("ERRO!");
                        break;
                    }
                case 4:
                    System.out.println("DIGITE O ID DO REBELDE: ");
                    Long idVerificaLoc = entrada.nextLong();
                    menuLocalizacao();
                    int novaLocReporte = entrada.nextInt();
                    service.atualizarLocalizacao(idVerificaLoc, novaLocReporte);
                    break;
                case 5:
                    System.out.println("DIGITE O ID DO MEMBRO QUE DESEJA FAZER UMA DENÚNCIA DE TRAIÇÃO: ");
                    Long idTraidor = entrada.nextLong();
                    service.reportarTraidor(idTraidor);
                    break;
                case 6:
                    System.out.println("VERIFIQUE SE UM MEMBRO PODE SER OFICIALIZADO COMO TRAIDOR.");
                    System.out.println("DIGITE O ID DO MEMBRO: ");
                    Long idTraidorVerifica = entrada.nextLong();
                    entrada.nextLine();
                    System.out.println("DIGITE O NOME DO MEMBRO: ");
                    String nomeTraidorVerifica = entrada.nextLine();
                    service.validacaoTraidor(idTraidorVerifica,nomeTraidorVerifica);
                    break;
                case 7:
                    System.out.println("DIGITE A ID DO MEMBRO PARA EXIBIR O INVENTÁRIO: ");
                    Long idRebeldeInventario = entrada.nextLong();
                    service.exibirInventarioDoRebelde(idRebeldeInventario);
                    break;
                case 8:
                    service.exibirRelatorio();
                    break;
                case 9:
                    service.exibirTraidores();
                    break;
                case 10:
                    System.out.println("SAINDO DO SISTEMA....");
                    return;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!");

            }
        }
    }

}
