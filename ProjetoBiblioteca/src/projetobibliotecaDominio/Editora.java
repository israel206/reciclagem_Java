package projetobibliotecaDominio;

/**
 *
 * @author ISRAEL
 */
public class Editora {
    private long id;
    private String nome;
    private int tipo;
    
    //geteres e seteres

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    /**
     * equals -> vai verificar se objetos da mesma classe são iguais
     *
     * @param outraEditora
     * @return
     */
    @Override
    public boolean equals (Object outraEditora){
        return id == ((Autor) outraEditora).getId();
    }
}

    

