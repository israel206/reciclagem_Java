package projetobibliotecaDominio;

/**
 *
 * @author ISRAEL
 */
public class Pessoa {
        //variaveis
    private long id;
    private long cpf;
    private String nome;
    private String telefone;
    
    //geteres e seteres

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * equals -> vai verificar se objetos da mesma classe são iguais
     * Ok
     * @param outraPessoa
     * @return
     */
    @Override
    public boolean equals(Object outraPessoa){
        return id == ((Pessoa) outraPessoa).getId();
    }//fim da funcão equals
}

    

