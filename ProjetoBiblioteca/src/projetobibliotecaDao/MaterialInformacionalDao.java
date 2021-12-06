package projetobibliotecaDao;

import projetobibliotecaDominio.MaterialInformacional;
import java.util.ArrayList;
/**
 *
 * @author ISRAEL
 */
public class MaterialInformacionalDao {
        ArrayList<MaterialInformacional> material = new ArrayList<MaterialInformacional>();

    /**
     * getMaterial() retorna a lista de todos os materiais cadastrados no
     * ArrayList<MaterialInformacional>
     *
     * @return
     */
    public ArrayList<MaterialInformacional> getMaterial() {
        return material;
    }

    public void setMaterial(ArrayList<MaterialInformacional> material) {
        this.material = material;
    }

    /**
     * Metodo 01: Cria um material na lista Ok
     *
     * @param novoMaterial
     * @return
     */
    public MaterialInformacional create(MaterialInformacional novoMaterial) {
        this.material.add(novoMaterial);
        return novoMaterial;
    } //fim do metodo

    /**
     * Metodo 02: Realiza a listagem dos Materiais Informacionais. Ok
     *
     * @return
     */
    public ArrayList<MaterialInformacional> findAll() {
        return material;
    } //fim do metodo

    /**
     * Metodo 03: Realiza a busca do material informacional pelo tipo. Ele
     * utiliza o primeiro algarismo do codigo de barra para determinar o tipo do
     * material. Sendo: 1-Para Livro 2-Para Periodico 3-Para Material Especial
     *
     * @param tipo
     * @return
     */
    public ArrayList<MaterialInformacional> findByTipo(int tipo) {
        ArrayList<MaterialInformacional> subLista = new ArrayList<MaterialInformacional>();

        //se o primeiro numero do codigo de barras for == 1 trata-se de um livro
        if (tipo == 1) {
            for (MaterialInformacional m : material) {
                if (m.getCodigoBarras().substring(0, 1).equals("1")) {
               //   saida += m.getCodigoBarras() + m.getTitulo() + "\n";
                    subLista.add(m);
                }
            }
            return subLista;
        } //se o primeiro numero do codigo de barras for == 2 trata-se de um Periodico
        else if (tipo == 2) {
            for (MaterialInformacional m : material) {
                if (m.getCodigoBarras().substring(0, 1).equals("2")) {
                    subLista.add(m);
                }
            }
            return subLista;
        } //se o primeiro numero do codigo de barras for == 3 trata-se de um Material especial
        else if (tipo == 3) {
            for (MaterialInformacional m : material) {
                if (m.getCodigoBarras().substring(0, 1).equals("3")) {
                    subLista.add(m);
                }
            }
            return subLista;
        }
        return null;
    } //fim da função 
    /**
     * Metodo 04: Busca o material informacional pelo codigo de barras. O metodo vai verificar 
     * inicialmente se a lista está vazia e depois percorrer o material informacional ate encontrar 
     * um igual ao codigo de barras.
     * @param codigo
     * @return 
     */
    public MaterialInformacional findByCodigoBarras(long codigo){
        if(!material.isEmpty()){
            for (MaterialInformacional m : material) {
                if(m.getCodigoBarras().equals(String.valueOf(codigo)))
                    return m;
            } //fim do for
        } //fim do if
        return null;
    } //fim da função
    
    /**
     * Metodo 05: Atualiza o numero de exemplares disponiveis, dependendo do tipo da operação. 
     * Se realizar um emprestimo ele vai diminuir o numero de exemplares disponiveis, 
     * caso seja uma devolução irá aumentar o numero de exemplares disponiveis
     * @param materialRet
     * @param quantidade 
     */
    public void updateQuantExemplaresDisponiveis(MaterialInformacional materialRet, int quantidade){      
        materialRet.setDisponiveis(quantidade);
    } //fim da função
    
} //fim da CLASSE

    

