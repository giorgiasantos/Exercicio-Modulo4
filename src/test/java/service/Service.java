package service;
import pessoas.Rebelde;
import pessoas.Traidor;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static conexao.Conexao.getConnection;

public class Service {

    //ATRIBUTOS
    private Statement statement;
    private Rebelde rebelde;
    private Traidor traidor;
    private List<Rebelde> listaDeRebeldes = new ArrayList<>();
    private List<Traidor> listaTraidores = new ArrayList<>();

    //CONSTRUCTOR
    public Service() {
        try{
            statement =getConnection().createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //MÉTODOS

    //método para exibir todos os rebeldes no banco de dados
    public void exibirRebeldes(){
        String sql = "select * from rebeldes";

        try{
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println(">>LISTA DE REBELDES CADASTRADOS<<");
            while(resultSet.next()){
                System.out.println("ID: " + resultSet.getLong("id") + " | NOME: " + resultSet.getString("nome") + " | IDADE: " + resultSet.getInt("idade") + " | GÊNERO: " + resultSet.getString("genero") + " | DENÚNCIAS: " + resultSet.getInt("denuncias"));
            }
            System.out.println("--------------------------------------------------------------------------------------");

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    // método para instanciar rebeldes na lista de rebeldes
    public List<Rebelde> listarRebeldes(){
        String sql = "SELECT * from rebeldes";
        Long id;
        String nome;
        int idade;
        String genero;
        int localizacao;

        try{
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                id = resultSet.getLong("id");
                nome = resultSet.getString("nome");
                idade = resultSet.getInt("idade");
                genero = resultSet.getString("genero");
                localizacao = resultSet.getInt("localizacao_id");
                rebelde = new Rebelde(id,nome,idade,genero,localizacao);
                listaDeRebeldes.add(rebelde);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listaDeRebeldes;
    }

    //método para fazer o cadastro de um novo rebelde no banco de dados
    public void cadastrarNovoRebelde(String nome, int idade, String genero, String localizacao){

        String sql = "INSERT INTO rebeldes (nome, idade, genero, localizacao_id) VALUES ('" + nome + "', '" + idade + "', '" + genero +"', '" + localizacao +"')";

        try {
            statement.executeUpdate(sql);
            System.out.println("O REBELDE " + nome + " FOI INCLUÍDO COM SUCESSO. QUE A FORÇA ESTEJA COM VOCÊ!");
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("--------------------------------------------------------------------------------------");

    }

    //método para mostrar o inventário do rebelde
    public void exibirInventarioDoRebelde(Long id){
        String sql = "select rebeldes.nome, inventario.id, itens_compra.item, inventario.quantidade from inventario inner join itens_compra on inventario.item_id = itens_compra.id inner join rebeldes on inventario.rebelde_id = rebeldes.id where inventario.rebelde_id = '" +id+"'";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("NOME: " + resultSet.getString("nome") + " -> ITEM: " + resultSet.getString("item") + " | QUANTIDADE = " +resultSet.getInt("quantidade"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }

    //método para validar o rebelde no banco de dados
    public boolean rebeldeExiste(String nome){
        String sql = "select nome from rebeldes where nome = '" + nome +"'";
        listarRebeldes();
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                Iterator<Rebelde> iterator = listaDeRebeldes.iterator();
                while (iterator.hasNext()){
                    Rebelde rebelde = iterator.next();
                    if(listaDeRebeldes.contains(rebelde)){
                        System.out.println("REBELDE VALIDADO NO SISTEMA. BOAS COMPRAS!");
                        return true;
                    }else{
                        System.out.println("REBELDE NÃO ENCONTRADO NO SISTEMA.");
                        return false;
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;

    }

    // método para comprar novos itens para o inventário
    public void comprarItensParaInventario(Long id, int novoItem, int quantidade){
            String sql = "INSERT INTO inventario (rebelde_id, item_id, quantidade) VALUES ('" + id +"', '" + novoItem +"', '" + quantidade+"')";

            try{
                statement.executeUpdate(sql);
                System.out.println("INVENTÁRIO ATUALIZADO COM SUCESSO!");
                exibirInventarioDoRebelde(id);
            }catch(SQLException e){
                e.printStackTrace();
            }

    }

    // método para exibir a localização atual do rebelde
    public void exibirLocalizacao(String id){
        String sql = "select rebeldes.nome, localizacao.nome_base, localizacao.local from localizacao inner join rebeldes on localizacao.id = rebeldes.localizacao_id where rebeldes.id = '" +id+"'";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("NOME: " + resultSet.getString("nome") + " | LOCALIZAÇÃO: " + resultSet.getString("nome_base") + " - " + resultSet.getString("local"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }

    // método para reportar nova localização
    public void atualizarLocalizacao(Long id, int localizacaoNova){
        String sql = "update rebeldes set localizacao_id = '" + localizacaoNova+"' where id = '" + id + "'";
            try {
                statement.executeUpdate(sql);
                System.out.println("LOCALIZAÇÃO ATUALIZADA COM SUCESSO!");
                exibirLocalizacao(id.toString());
            }catch (SQLException e){
                e.printStackTrace();
            }
        System.out.println("--------------------------------------------------------------------------------------");
    }

    // método para exibir traidores
    public void exibirTraidores(){
        String sql = "select * from traidores";

        try{
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println(">>LISTA DE TRAIDORES OFICIALIZADOS<<");
            while(resultSet.next()){
                System.out.println("ID: " + resultSet.getLong("id_traidor") + " | NOME: " + resultSet.getString("nome"));
            }
            System.out.println("--------------------------------------------------------------------------------------");

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    // método para instanciar traidores na lista de traidores
    public List<Traidor> listarTraidores(){
        String sql = "SELECT * from traidores";
        Long id;
        String nome;

        try{
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                id = resultSet.getLong("id_traidor");
                nome = resultSet.getString("nome");
                traidor = new Traidor(id, nome);
                listaTraidores.add(traidor);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listaTraidores;
    }

    // método para denunciar traidor
    public void reportarTraidor(Long id){
        String sql = "update rebeldes set denuncias = denuncias + 1 WHERE id = '" + id +"'";

        try{
            statement.executeUpdate(sql);
            System.out.println("DENUNCIA DE TRAIÇÃO REGISTRADA COM SUCESSO!");
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }

    // método para validar um novo traidor (incluí-lo no banco de dados e lista de traidores, removê-lo do banco de dados e lista de rebeldes ativos)
    public void validacaoTraidor(Long id, String nome){
        String sql = "select denuncias from rebeldes where id = '" + id +"' ";
        listarRebeldes();
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                int denunciasTotal = resultSet.getInt("denuncias");
                int limiteDenuncias = 3;
                Iterator<Rebelde> iterator = listaDeRebeldes.iterator();
                while (iterator.hasNext()){
                    Rebelde rebelde = iterator.next();
                    if(denunciasTotal >= limiteDenuncias){
                        listaTraidores.add(traidor);
                        iterator.remove();
                        System.out.println("O TRAIDOR FOI INATIVO COM SUCESSO.");
                        String sqlTraidorInclui = "insert into traidores (nome) values ('" + nome + "')";
                        statement.executeUpdate(sqlTraidorInclui);
                        String sqlTraidorRemove = "delete from rebeldes where id = '" + id +"'";
                        statement.executeUpdate(sqlTraidorRemove);
                        break;
                    }else{
                        System.out.println("ERRO! ESTE USUÁRIO NÃO TEM DENÚNCIAS O SUFICIENTE PARA SER REPORTADO COMO TRAIDOR.");
                        break;
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("--------------------------------------------------------------------------------------");

    }


    // método para exibir estatísticas de relatório
    public void exibirRelatorio() {
        listarRebeldes();
        listarTraidores();
        double totalRebeldes = listaDeRebeldes.size();
        double  totalTraidores= listaTraidores.size();
        double  totalPessoas = listaDeRebeldes.size() + listaTraidores.size();
        double  porcentagemRebeldes = (totalRebeldes / totalPessoas) * 100;
        double  porcentagemTraidores = (totalTraidores / totalPessoas) * 100;

        System.out.println(">>RELATÓRIO<<");
        System.out.println("QUANTIDADE DE REBELDES FIÉIS PELA CAUSA = " + listaDeRebeldes.size());
        System.out.println("QUANTIDADE DE TRAIDORES = " +listaTraidores.size());
        System.out.println("A PORCENTAGEM ATUAL DE REBELDES É = " + porcentagemRebeldes + " %");
        System.out.println("A PORCENTAGEM ATUAL DE TRAIDORES É = " + porcentagemTraidores + " %");
        System.out.println("--------------------------------------------------------------------------------------");
    }

}
