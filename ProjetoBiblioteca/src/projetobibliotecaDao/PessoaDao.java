package projetobibliotecaDao;

import projetobibliotecaDominio.Pessoa;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author ISRAEL
 */
public class PessoaDao {
        private ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();
    
    //geteres e seteres
    public ArrayList<Pessoa> getPessoa() {
        return pessoa;
    }

    public void setPessoa(ArrayList<Pessoa> pessoa) {
        this.pessoa = pessoa;
    }        
    
    /**
     * 01 Metodo CREATE que cria uma pessoa
     * Ok
     * @param pessoa
     * @return 
     */  
    public Pessoa createPessoa(Pessoa pessoaNova){
        //adiciona a lista
        this.pessoa.add(pessoaNova);
        return pessoaNova;
    } //fim da função create
    
    /**
     * 02 Metodo que realiza a listagem das pessoas
     * Ok
     * @return 
     */
    public ArrayList<Pessoa> findAll() {
        return pessoa;
    }
   
   /**
     * Metodo 03 que realiza a busca da pessoa pelo cpf. Retorna um elemento Pessoa
     * @param cpf
     * @return 
     */
    public Pessoa findByCpf(long cpf){
        if(!pessoa.isEmpty()){
            for (Pessoa p : pessoa) {
                if(p.getCpf() == cpf)
                    return p;
            } //fim do for
        }
        return null;
    } //fim da função findByCpf
    
    /**
     * Metodo 04: Remove da lista uma pessoa cadastrada. Metodo Extra que não possui retorno: void
     * @param cpf 
     */
    public void removeByCpf(long cpf){
        Pessoa p = findByCpf(cpf);
        if(cpf == p.getCpf()){
            pessoa.remove(p);
            JOptionPane.showMessageDialog(null, "Pessoa removida com sucesso!");
        }else
            JOptionPane.showMessageDialog(null, "Não há pessoa cadastrada com esse CPF.");
                           
    } //fim da função     
} //fim da Classe

    

