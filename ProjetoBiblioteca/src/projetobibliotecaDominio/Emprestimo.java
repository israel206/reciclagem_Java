package projetobibliotecaDominio;
import java.util.Date;

/**
 *
 * @author ISRAEL
 */
public class Emprestimo {
    private long id;
    private Date dataEmprestimo;
    private Date dataDevolucao = null;
   
    
    //variaveis de relacionamento
    Pessoa pessoa; //obj da classe pessoa
    Autor autor; //obj da classe Autor
    Editora editora; //obj da classe Editora
    MaterialInformacional material; //obj da Classe MaterialInformacional
    
    //geteres e seteres
    /**
     * getDataDevolucao vai retornar a data de devolução do emprestimo
     * @return 
     */
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * setDataDevolucao vai setar a data de devolução do emprestimo
     * @param dataDevolucao 
     */
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    
    
    /**
     * getId() vai retornar o codigo do emprestimo
     * @return 
     */
    public long getId() {
        return id;
    }
   
 /**
     * setId() vai setar o codigo do emprestimo
     * @param id 
     */
    public void setId(long id) {
        this.id = id;
    }

    //get e set das variaveis da classe
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public MaterialInformacional getMaterial() {
        return material;
    }

    public void setMaterial(MaterialInformacional material) {
        this.material = material;
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
     *
     * @param outroEmprestimo
     * @return
     */
    @Override
    public boolean equals (Object outroEmprestimo){
        return id == ((Emprestimo) outroEmprestimo).getId();
    }
}

    

