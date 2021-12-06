package projetobibliotecaDominio;

/**
 *
 * @author ISRAEL
 */
public class Periodico extends MaterialInformacional{
        //variaveis exclusiveis da classe Periodico
    private int issn;
    private int ano;
    private int volume;
    
    //geteres e seteres

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getIssn() {
        return issn;
    }

    public void setIssn(int issn) {
        this.issn = issn;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    
    /**
     * equals -> vai verificar se objetos da mesma classe são iguais
     *
     * @param outroPeriodico
     * @return
     */
    @Override
    public boolean equals(Object outroPeriodico){
        return issn == ((Periodico) outroPeriodico).getIssn();
    }
}



    

