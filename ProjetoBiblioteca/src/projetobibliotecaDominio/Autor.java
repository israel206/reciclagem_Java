package projetobibliotecaDominio;

/**
 *
 * @author ISRAEL
 */
public class Autor {
    private long id;
    private String nome;
    private String sobreNome;
    
    private Livro livro;
    
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

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }
    
    //classe Livro

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    /**
     * equals -> vai verificar se objetos da mesma classe são iguais
     * @param outroAutor
     * @return
     */
    @Override
    public boolean equals(Object outroAutor){
        return id == ((Autor) outroAutor).getId();
    }// fim da função equals
}

    

