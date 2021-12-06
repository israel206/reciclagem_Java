package projetobibliotecaDominio;

/**
 *
 * @author ISRAEL
 */
public class MaterialInformacional {
    private long id;
    private String titulo;
    private String codigoBarras; //CRITERIO: Primeiro numero vai indicar o tipo/o segundo a estante
    private int estante;
    private int exemplares;
    private int disponiveis;

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public int getDisponiveis() {
        return disponiveis;
    }

    public void setDisponiveis(int disponiveis) {
        this.disponiveis = disponiveis;
    }

    public int getEstante() {
        return estante;
    }

    public void setEstante(int estante) {
        this.estante = estante;
    }

    public int getExemplares() {
        return exemplares;
    }

    public void setExemplares(int exemplares) {
        this.exemplares = exemplares;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public boolean equals(Object outroMaterial){
        return id == ((MaterialInformacional) outroMaterial).getId();
    }
}


    

