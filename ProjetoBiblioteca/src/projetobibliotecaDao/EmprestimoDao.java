package projetobibliotecaDao;

import projetobibliotecaDominio.Emprestimo;
import projetobibliotecaDominio.Livro;
import projetobibliotecaDominio.MaterialInformacional;
import projetobibliotecaDominio.Pessoa;
//import projetobibliotecaDao.MaterialInformacionalDao;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 * 1 classe
 * @author ISRAEL
 */
public class EmprestimoDao {
        private int i = 0; //incrementa o id do emprestimo
    //cria listas
    private ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    private ArrayList<Emprestimo> devolucoes = new ArrayList<Emprestimo>();
    
    //geteres e seters

    public ArrayList<Emprestimo> getDevolucoes() {
        return devolucoes;
    }

    public void setDevolucoes(ArrayList<Emprestimo> devolucoes) {
        this.devolucoes = devolucoes;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
    
    /**
     * Metodo 01 - Realiza um emprestimo e retorno do tipo Emprestimo
     * @param pessoa
     * @param material
     * @param data
     * @return 
     */
    public Emprestimo create(Pessoa pessoa, MaterialInformacional material, Date data){
        Emprestimo empReal = new Emprestimo();
        empReal.setId(i);
        empReal.setPessoa(pessoa);
        empReal.setMaterial(material);
        empReal.setDataEmprestimo(data);
        empReal.setDataDevolucao(null); //reafirma que o conteudo é null, deixando o emprestimo ativo
        
        //Foi necessario fazer um ploxi 
        if(material instanceof Livro ) {
            empReal.setAutor(((Livro) material).getAutor());
            empReal.setEditora(((Livro) material).getEditora());
        } 
        
        emprestimos.add(empReal); //adiciona no ArrayList emprestimo
        i++;
        return empReal;     
    } //fim da função create
    
    /**
     * Metodo 02: Este metodo recebe o cpf e o codigo de barras e retorna o id do emprestimo
     * @param cpf
     * @param cBarras
     * @return 
     */
    
        public Emprestimo findByIdentificador(long cpf, long cBarras){
        //converter os valores para Strings
        String CBStr = String.valueOf(cBarras);
        int v=0;
        //percorre o ArrayList Emprestimo
        for (Emprestimo e : emprestimos) {
            if(e.getPessoa().getCpf() == cpf){ //verifica se há pessoa com o mesmo cpf  
               v=1;
                if(e.getMaterial().getCodigoBarras().equals(CBStr)) //verifica se a pessoa encontrada possui um emprestimo com o CBarras informado
                    return e;  
                else 
                    JOptionPane.showMessageDialog(null, "O CPF(" + cpf + ") não possui o codigo de Barras (" + CBStr + ") emprestado");
                break;
            } if (v==1)
                JOptionPane.showMessageDialog(null, "Esta pessoa não possui emprestimo");
        } //fim do for
        return null;
    } //fim da função
    
    /**
     * Metodo 03: Este metodo recebe o codigo de barras do material cadastrado. 
     * Identificar a posição dele e percorre o emprestimo ate encontrar o elemento com o mesmo codigo de barras. 
     * Depois ele seta a data de devolução deixando o emprestimo inativo e o adiciona novamente na lista emprestimo 
     * na mesma posição.
     * @param codBarras
     * @param cpf 
     */
    public void removerEmprestimo(String codBarras, long cpf){
        Emprestimo emprestimoGuardado = null; //vai guardar o emprestimo qdo for encontrado
        Date data = new java.util.Date(); //vai registrar a data do pc
        
        for (Emprestimo e : emprestimos) { //vai percorrer a lista emprestimo em busca do elemento que contenha o mesmo codigo de barras
            if(e.getMaterial().getCodigoBarras().equals(codBarras)){
                    if(e.getPessoa().getCpf()==cpf){
                        emprestimoGuardado = e;
                        devolucoes.add(e); //adiciona o emprestimo e no ArrayList da devolução
                        break; //para de percorrer qdo encontrar 
                    } 
            } //fim do if
        } //fim do for
        
        int posicao = emprestimos.indexOf(emprestimoGuardado); //vai guardar a posição do elemento emprestimo na lista
        emprestimoGuardado.setDataDevolucao(data); //ao setar a data torna o emprestimo inativo
        emprestimos.add(posicao, emprestimoGuardado); //adiciona o elemento emprestimo na lista

        JOptionPane.showMessageDialog(null, "Material devolvido com sucesso!"); //saida: confirmação da operação
    } //fim da função create   
    /**
     * Método 3.1: Este metodo recebe emprestimo cadastrado. 
     * Identificar a posição dele e percorre o emprestimo ate encontrar o elemento com o mesmo codigo de barras. 
     * Depois ele seta a data de devolução deixando o emprestimo inativo e o adiciona novamente na lista emprestimo 
     * na mesma posição.
     * @param e 
     */
    public void devolverEmprestimo(Emprestimo e){
        Emprestimo emprestimoGuardado = null; //vai guardar o emprestimo qdo for encontrado
        Date data = new java.util.Date(); //vai registrar a data do pc
        
        if(e!=null){
           
                for (Emprestimo eE : emprestimos) {
                    if(e.getPessoa().getCpf() == eE.getPessoa().getCpf() && eE.getDataDevolucao() == null){ 
                        if(e.getMaterial().getExemplares( )>= e.getMaterial().getDisponiveis()){
                            emprestimoGuardado = e;
                            devolucoes.add(e);

                            int posicao = emprestimos.indexOf(emprestimoGuardado); //vai guardar a posição do elemento emprestimo na lista
                            emprestimoGuardado.setDataDevolucao(data); //ao setar a data torna o emprestimo inativo
                            emprestimos.add(posicao, emprestimoGuardado); //adiciona o elemento emprestimo na lista


                            JOptionPane.showMessageDialog(null, "Material devolvido com sucesso!"); //saida: confirmação da operação
                            break;
                        } 
                    }else
                        JOptionPane.showMessageDialog(null, "Cpf não encontrado na lista dos emprestimos");
                } //fim do for
            } //fim do if
            else 
                JOptionPane.showMessageDialog(null, "Exemplar ja devolvido ... ");
    }
    /**
     * Metodo 04: Realiza o cancelamento do emprestimo, retirando-o da lista dos emprestimos
     * @param id 
     */
    public void cancelarEmprestimo(long id){
        for (Emprestimo e : emprestimos) { 
            if(e.getId() == (id)){ //vai verificar se existe algum emprestimo na lista com o id informado
               emprestimos.remove(e);
                break;
            } //fim do if
        } //fim do for
    } //fim da função
    /**
     * Metodo 05: Lista todos os emprestimos
     * @return 
     */
    public ArrayList<Emprestimo> findEmprestimos(){
        return emprestimos;
    }
    /**
     * Metodo 06: Vai listar todas as devoluções registradas. Retorna um ArrayList 
     * @return 
     */
    public ArrayList<Emprestimo> findDevolucoes(){
        return devolucoes;
    } //fim da função findDevolucao
    /**
     * Método 07: Recebe o codigo de barras do material informacional e busca o material na lista dos emprestimos
     * @param codigo
     * @return 
     */
    public Emprestimo findByCBEmprestado(long codigo){
        if(!emprestimos.isEmpty()){
            for (Emprestimo matEncontrado : emprestimos) {
                if(matEncontrado.getMaterial().getCodigoBarras().equals(String.valueOf(codigo)))
                    return matEncontrado;
            } //fim do for
        } //fim do if
        return null;
    } //fim da função
}



    

