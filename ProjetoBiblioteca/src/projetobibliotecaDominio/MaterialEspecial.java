package projetobibliotecaDominio;

/**
 *
 * @author ISRAEL
 */
public class MaterialEspecial extends MaterialInformacional{
    //variaveis exclusiveis da classe Periodico
    private String descricao;
    private TipoMaterialEspecial tipoMaterialEspecial;
    
    //variavel da classe filha
    private long idTipoMaterial;
    
    //geteres e seteres

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //geteres e seteres da variavel da classe filha

    public long getIdTipoMaterial() {
        return idTipoMaterial;
    }

    public void setIdTipoMaterial(long idTipoMaterial) {
        this.idTipoMaterial = idTipoMaterial;
    }

    public TipoMaterialEspecial getTipoMaterialEspecial() {
        return tipoMaterialEspecial;
    }

    public void setTipoMaterialEspecial(TipoMaterialEspecial tipoMaterialEspecial) {
        this.tipoMaterialEspecial = tipoMaterialEspecial;
    }
    
}

    

