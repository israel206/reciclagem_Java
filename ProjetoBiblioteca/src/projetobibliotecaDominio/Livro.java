package projetobibliotecaDominio;

/**
 *
 * @author ISRAEL
 */
public class Livro extends MaterialInformacional {
        //variaveis exclusiveis da classe Livro
    private int isbn;
    private int ano;
    private int volume;
    private int edicao;
    
    private Autor autor;
    private Editora editora;
    
    
    //geteres e seteres

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
    /**
     * equals -> vai verificar se objetos da mesma classe são iguais
     * @param outroLivro
     * @return
     */
    @Override
    public boolean equals(Object outroLivro){
        return isbn == ((Livro) outroLivro).getIsbn();
    }
}


    

