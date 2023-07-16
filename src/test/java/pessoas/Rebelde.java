package pessoas;

public class Rebelde {

    //ATRIBUTOS
    private Long id_rebelde;
    private String nome;
    private int idade;
    private String genero;
    private int localizacao;
    private int denuncias;

    //CONSTRUCTOR

    public Rebelde(Long id_rebelde, String nome, int idade, String genero, int localizacao) {
        this.id_rebelde = id_rebelde;
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.localizacao = localizacao;
    }

    public Rebelde() {
    }

    public Rebelde(Long id, String nome) {
    }

    //GETTERS E SETTERS
    public Long getId_rebelde() {
        return id_rebelde;
    }

    public void setId_rebelde(Long id_rebelde) {
        this.id_rebelde = id_rebelde;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(int localizacao) {
        this.localizacao = localizacao;
    }

    public int getDenuncias() {
        return denuncias;
    }

    public void setDenuncias(int denuncias) {
        this.denuncias = denuncias;
    }

    @Override
    public String toString() {
        return "Rebelde{" +
                "id_rebelde=" + id_rebelde +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", genero='" + genero + '\'' +
                ", localizacao=" + localizacao +
                ", denuncias=" + denuncias +
                '}';
    }
}
