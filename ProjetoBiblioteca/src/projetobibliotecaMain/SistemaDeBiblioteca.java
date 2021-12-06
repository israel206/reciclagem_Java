package projetobibliotecaMain;

import projetobibliotecaDao.EmprestimoDao;
import projetobibliotecaDao.MaterialInformacionalDao;
import projetobibliotecaDao.PessoaDao;
import projetobibliotecaDominio.*;
import projetobibliotecaDominio.Emprestimo;
import java.text.SimpleDateFormat; //Responsavel por formatar a saida da data
import javax.swing.JOptionPane; //Responsavel pelas janelas
/**
 *
 * @author ISRAEL
 */
public class SistemaDeBiblioteca {
        public static void main(String[] args) {

        //referencia para cada Dao
        MaterialInformacionalDao matInf = new MaterialInformacionalDao();
        PessoaDao pessoa = new PessoaDao();
        EmprestimoDao emprestimo = new EmprestimoDao();
       //Emprestimo emprestimoDom = new Emprestimo();
       
        //Variaveis
        int op; //variavel utilizada nos menus
        int ip = 4; //incrementa o id do objeto pessoa
        int miL = 4; //incrementa o id do mat. Inf. Livro
        int miP = 3; //incrementa o id do mat. Inf. Livro
        int miE = 3; //incrementa o id do mat. Inf. Livro
        int tipoMat = 0; //usada na busca do material por tipo
        String str = ""; //vai tratar a listagem dos usuarios cadastrados
        String tipoStr = ""; //vai tratar a listagem do Material por tipo
        String strEmp = ""; //vai tratar a listagem dos emprestimos
        String saida = ""; //vai tratar a listagem do material informacional
        long eCpf=0; //usada no case da devolução do material
        long eCodigoBarras=0; //usada no case da devolução do material
       

        //CADASTRO AUTOMATICO DE PESSOAS
        //PESSOA 1
        Pessoa p = new Pessoa();  //Nova pessoa
        p.setId(1);
        p.setNome("Thiago Campos");
        p.setCpf(1111);
        p.setTelefone("9900-7500");
        pessoa.createPessoa(p); //adiciona a lista

        Pessoa p1 = new Pessoa(); //Nova pessoa
        p1.setId(2);
        p1.setNome("Roberto Queiroz");
        p1.setCpf(2222);
        p1.setTelefone("8710-1002");
        pessoa.createPessoa(p1); //adiciona a lista

        Pessoa p2 = new Pessoa(); //Nova pessoa
        p2.setId(3);
        p2.setNome("Ronaldo da Silva");
        p2.setCpf(3333);
        p2.setTelefone("8155-5554");
        pessoa.createPessoa(p2); //adiciona a lista
        //FIM DO CADASTRO AUTOMATICO DAS PESSOAS

        //CADASTRO AUTOMATICO DO MATERIAL INFORMACIONAL
        //LIVRO 1
        Livro livro = new Livro();
        livro.setId(101);
        livro.setTitulo("Quebrando a Cabeça com Java");
        livro.setCodigoBarras("11001");
        livro.setEstante(1);
        livro.setExemplares(2);
        livro.setDisponiveis(2);
        livro.setIsbn(101);
        livro.setAno(2010);
        livro.setVolume(3);
        
        //Instanciando Autor
        Autor autor = new Autor();
        autor.setId(11);
        autor.setNome("Itamir");
        autor.setSobreNome("Filho");
        livro.setAutor(autor); //add autor
        
        //instanciando Editora
        Editora editora = new Editora();
        editora.setId(10);
        editora.setNome("Abril");
        editora.setTipo(1);
        livro.setEditora(editora); //add editora

        //LIVRO 2
        Livro livro2 = new Livro();
        livro2.setId(102);
        livro2.setTitulo("Programação Orientada a Objeto");
        livro2.setCodigoBarras("11002");
        livro2.setEstante(1);
        livro2.setExemplares(1);
        livro2.setDisponiveis(1);
        livro2.setIsbn(102);
        livro2.setAno(2009);
        livro2.setVolume(1);
        
        //Instanciando autor
        Autor autor2 = new Autor();
        autor2.setId(12);
        autor2.setNome("Paulo");
        autor2.setSobreNome("Coelho");
        livro2.setAutor(autor2); //add autor
        
        //instanciando editora
        Editora editora1 = new Editora();
        editora1.setId(20);
        editora1.setNome("Saraiva");
        editora1.setTipo(2);
        livro2.setEditora(editora1); //add editora

        //LIVRO 3
        Livro livro3 = new Livro();
        livro3.setId(103);
        livro3.setTitulo("Java 7: Como Programar");
        livro3.setCodigoBarras("11003");
        livro3.setEstante(1);
        livro3.setExemplares(3);
        livro3.setDisponiveis(3);
        livro3.setIsbn(103);
        livro3.setAno(2011);
        livro3.setVolume(3);
        
        //instanciando autor
        Autor autor3 = new Autor();
        autor3.setId(13);
        autor3.setNome("Jose");
        autor3.setSobreNome("Brandão");
        livro3.setAutor(autor3); //add autor
        
        //instanciando editora
        Editora editora3 = new Editora();
        editora3.setId(20);
        editora3.setNome("Saraiva");
        editora3.setTipo(2);
        livro.setEditora(editora3);

        //Adicionar o livro a base de dado
        matInf.create(livro);
        matInf.create(livro2);
        matInf.create(livro3);

        //PERIODICO 01
        Periodico per = new Periodico();
        per.setId(201);
        per.setTitulo("Diario de Natal");
        per.setCodigoBarras("22001");
        per.setEstante(2);
        per.setExemplares(5);
        per.setDisponiveis(5);
        per.setIssn(201);
        per.setVolume(5);
        per.setAno(2004);

        //PERIODICO 02
        Periodico per2 = new Periodico();
        per2.setId(202);
        per2.setTitulo("Tribuna do Norte");
        per2.setCodigoBarras("22002");
        per2.setEstante(2);
        per2.setExemplares(2);
        per2.setDisponiveis(2);
        per2.setIssn(202);
        per2.setVolume(1);
        per2.setAno(2012);

        //Adicionar o livro a base de dado
        matInf.create(per);
        matInf.create(per2);

        //MATERIAL ESPECIAL 1
        MaterialEspecial especial = new MaterialEspecial();
        especial.setId(301);
        especial.setTitulo("A Vitoria do Brasil na Copa de 94");
        especial.setCodigoBarras("33001");
        especial.setEstante(3);
        especial.setExemplares(4);
        especial.setDisponiveis(4);
        especial.setDescricao("Trata-se de trabalho escolar");
        //instanciando o tipo de material especial
        TipoMaterialEspecial tipoME = new TipoMaterialEspecial();
        tipoME.setId(1);
        tipoME.setNome("DVD");
        especial.setTipoMaterialEspecial(tipoME);

        //MATERIAL ESPECIAL 2
        MaterialEspecial especial2 = new MaterialEspecial();
        especial2.setId(301);
        especial2.setTitulo("O impacto da Programação na atualidade");
        especial2.setCodigoBarras("33002");
        especial2.setEstante(3);
        especial2.setExemplares(3);
        especial2.setDisponiveis(3);
        especial2.setDescricao("Trata-se de estudo realizado por estudantes");
        //instanciando o tipo de material especial
        TipoMaterialEspecial tipoME2 = new TipoMaterialEspecial();
        tipoME2.setId(1);
        tipoME2.setNome("FITA");
        especial2.setTipoMaterialEspecial(tipoME2);

        //Adicionar o livro a base de dado
        matInf.create(especial);
        matInf.create(especial2);
        //FIM DO CADASTRAMENTO AUTOMATICO DO MATERIAL INFORMACIONAL

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção:"
                    + "\n1-Emprestimo de Material"
                    + "\n2-Devolução de Material"
                    + "\n3-Cadastro / Informações (Pessoa ou Material) "
                    + "\n4-Sair do Programa"));
            switch (op) {
                case 1: //Emprestimo
                    do {
                        op = Integer.parseInt(JOptionPane.showInputDialog("Menu Emprestimo:"
                                + "\n1-Listar Emprestimo"
                                + "\n2-Realizar Emprestimo"
                                + "\n3-Cancelar Emprestimo"
                                + "\n4-Sair do Menu Emprestimo"));
                        switch (op) {
                            case 1: //LISTAR EMPRESTIMOS    


                                SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy"); //formatad a saida da data
                               
                                for (Emprestimo e : emprestimo.findEmprestimos()) {
                                    if (e.getDataDevolucao() == null) {
                                        strEmp += "+ Nome: " + e.getPessoa().getNome() + " CPF: " + e.getPessoa().getCpf() + " Tel.: " + e.getPessoa().getTelefone()
                                        + "\n " + " CB:" + e.getMaterial().getCodigoBarras() + " Titulo: " + e.getMaterial().getTitulo()
                                        + " Autor: " + (e.getAutor() != null ? e.getAutor().getSobreNome() : " - ") + ", " + (e.getAutor() != null ? e.getAutor().getNome() : "-")
                                        + "\n " + " Data do Emprestimo: " + spf.format(e.getDataEmprestimo())+ "\n\n";
                                    }
                                }
                                if (strEmp.equals("")) {
                                    JOptionPane.showMessageDialog(null, "Não há material emprestado!");
                                } else {
                                    JOptionPane.showMessageDialog(null, strEmp);
                                }
                                strEmp = ""; //zerar a String
                                break;
                            case 2: //REALIZAR EMPRESTIMO              
                                eCpf = Long.parseLong(JOptionPane.showInputDialog("Informe o CPF da pessoa:"));
                                Pessoa retornoPessoa = pessoa.findByCpf(eCpf);
                                if (retornoPessoa != null) { //verifica se existe a pessoa (9.32)

                                    //BUSCA DO MATERIAL POR TIPO
                                    do {

                                        tipoMat = Integer.parseInt(JOptionPane.showInputDialog("Informe o tipo:"
                                                + "\n1-Livro"
                                                + "\n2-Periodico"
                                                + "\n3-Material Especial"
                                                + "\n4-Não Realizar o emprestimo"));
                                        switch (tipoMat) {
                                            case 1:
                                            case 2:
                                            case 3:
                                                if (tipoMat != 4) {//Condição para efetuar o cadastro
                                                    tipoStr = "";
                                                    for (MaterialInformacional elem : matInf.findByTipo(tipoMat)) {
                                                        tipoStr += "CB:" + elem.getCodigoBarras() + "     Título: " + elem.getTitulo()
                                                                + "          Estante: " + elem.getEstante() + "     Qtd. Exemplares: " + elem.getExemplares() + "     Qtd. Disp.: " + elem.getDisponiveis() + "\n";
                                                    }
                                                    JOptionPane.showMessageDialog(null, tipoStr); //lista todo o material disponivel

                                                    eCodigoBarras = Long.parseLong(JOptionPane.showInputDialog("Informe o codigo de barra do material:"));
                                                    MaterialInformacional retornoMaterial = matInf.findByCodigoBarras(eCodigoBarras);
                                                    if (retornoMaterial == null) {
                                                        JOptionPane.showMessageDialog(null, "Código de barras inválido, material Não Cadastrado!");
                                                    } else {

                                                        if (retornoMaterial.getDisponiveis() > 0) { //if responsavel pela verificação de exemplares disponiveis
                                                            matInf.updateQuantExemplaresDisponiveis(retornoMaterial, (retornoMaterial.getDisponiveis() - 1));

                                                            Emprestimo e = new Emprestimo(); //instancia e cria o emprestimo na lista
                                                            e = emprestimo.create(retornoPessoa, retornoMaterial, new java.util.Date()); //chama e recebe a função  ( new java.util.Date() -> guarda a data do pc)         
                                              //              i++; //incrementa o id do emprestimo    

                                                            JOptionPane.showMessageDialog(null, "Emprestimo realizado com sucesso"); //saida
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Não existe exemplares disponiveis!");
                                                        }
                                                    } //fim do else
                                                    tipoMat = 4;
                                                } //fim do if que verifica se o usuario deseja cadastrar o material
                                                break;
                                            case 4:
                                                JOptionPane.showMessageDialog(null, "Saindo do cadastro de material");
                                                break;
                                            default:
                                                JOptionPane.showMessageDialog(null, "Opção invalida!");

                                        } //fim do switch
                                    } while (tipoMat != 4);
                                    //FIM DA BUSCA
                                } else { //Se a pessoa não existir (9.3.3)
                                    JOptionPane.showMessageDialog(null, "CPF inválido ou Pessoa Não Cadastrada!");
                                    op = 0;
                                    do {
                                        op = Integer.parseInt(JOptionPane.showInputDialog("Deseja cadastrar novo usuário?"
                                                + "\n1-Sim"
                                                + "\n2-Não"));
                                        if (op == 1) {
                                            Pessoa p5 = new Pessoa();  //Nova pessoa
                                            p5.setId(ip);
                                            p5.setNome(JOptionPane.showInputDialog("Informe o nome:"));
                                            p5.setCpf(eCpf);
                                            p5.setTelefone(JOptionPane.showInputDialog("Informe o telefone:"));
                                            pessoa.createPessoa(p5); //adiciona a lista
                                            ip++; //incrementa o id

                                            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                                            op = 2;
                                        }
                                    } while (op != 2); //Realiz novo cadastro

                                }
                                strEmp = ""; //zerar a String
                                break;
                            case 3: //CANCELAR EMPRESTIMO
                                long cpfRet = Long.parseLong(JOptionPane.showInputDialog("Informe o cpf:"));
                                long CBarras = Long.parseLong(JOptionPane.showInputDialog("Informe o codigo de barra do material:")); //Guarda o codigo de barras

                                Emprestimo eE = emprestimo.findByIdentificador(cpfRet, CBarras);
                                if (eE != null) {
                                    matInf.updateQuantExemplaresDisponiveis(eE.getMaterial(), (eE.getMaterial().getDisponiveis() + 1));
                                    emprestimo.cancelarEmprestimo(eE.getId()); //passa o id do emprestimo e o retira da lista de emprestimo

                                    JOptionPane.showMessageDialog(null, "Cancelamento realisado com sucesso!");
                                }
                                strEmp = ""; //zerar a String
                                break;   
                            case 4: //SAIR
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção invalida!");
                                break;
                        } //fim do switch op
                    } while (op != 4);
                    op = 0;
                    break;
                case 2: //MENU DAS DEVOLUÇÕES
                    do {
                        op = Integer.parseInt(JOptionPane.showInputDialog("Menu Devolução:"
                                + "\n1-Listar Devolução"
                                + "\n2-Realizar Devolução"
                                + "\n3-Sair do Menu Devolução"));
                        switch (op) {
                            case 1: //LISTA TODAS AS DEVOLUÇÕES
                                for (Emprestimo d : emprestimo.findDevolucoes()) {
                                    if (d.getDataDevolucao() != null) {
                                        strEmp += "+ Nome: " + d.getPessoa().getNome() + "     CPF: " + d.getPessoa().getCpf() + "     Tel.: " + d.getPessoa().getTelefone()
                                                + "\n " + "  CB:" + d.getMaterial().getCodigoBarras() + "      Titulo: " + d.getMaterial().getTitulo()
                                                + "        Autor: " + (d.getAutor() != null ? d.getAutor().getSobreNome() : " - ") + ", " + (d.getAutor() != null ? d.getAutor().getNome() : "-")
                                                + "\n " + "  Data do Emprestimo: " + d.getDataEmprestimo() + "  Data da Devolução: " + d.getDataDevolucao() + "\n\n";
                                    }
                                }
                                if (!strEmp.equals("")) {
                                    JOptionPane.showMessageDialog(null, strEmp);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Não há material emprestado");
                                }
                                strEmp = ""; //zerar a String
                                break;
                            case 2: //REALIZA A DEVOLUÇÃO DO MATERIAL        
                                eCodigoBarras = Long.parseLong(JOptionPane.showInputDialog("Informe o codigo de barra do material:")); //Guarda o codigo de barras
                                eCpf = Long.parseLong(JOptionPane.showInputDialog("Informe o cpf:"));

                                Emprestimo e = emprestimo.findByIdentificador(eCpf, eCodigoBarras);
                                if (e != null) {
                                    if (e.getDataDevolucao() == null && e.getPessoa().getCpf() == eCpf) {
                                        if (e.getMaterial().getDisponiveis() < e.getMaterial().getExemplares()) { //vai observar o numero de exemplares disponiveis em relação ao numero de exemplares 
                                            matInf.updateQuantExemplaresDisponiveis(e.getMaterial(), (e.getMaterial().getDisponiveis() + 1)); //atualiza o numero de exemplares disp
                                            emprestimo.devolverEmprestimo(e);
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Todos os exemplares estão na biblioteca.");
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Cpf não encontrado na lista dos emprestimos");
                                }
                                break;
                            case 3: //SAIR
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção invalida!");
                                break;
                        } //fim do switch
                    } while (op != 3);
                    op = 0;
                    break;
                case 3: //MENU DOS CADASTROS
                    do {
                        op = Integer.parseInt(JOptionPane.showInputDialog("Menu Cadastro:"
                                + "\n1-Pessoa"
                                + "\n2-Material Informacional"
                                + "\n3-Sair do Menu Cadastro"));
                        switch (op) {
                            case 1: //Pessoa
                                do {
                                    op = Integer.parseInt(JOptionPane.showInputDialog("Menu Pessoa:"
                                            + "\n1-Listar Cadastro"
                                            + "\n2-Buscar Cadastro"
                                            + "\n3-Realizar Cadastro"
                                            + "\n4-Excluir Cadastro"
                                            + "\n5-Sair do Cadastro de Pessoa"));
                                    switch (op) {
                                        case 1: //LISTAR CADASTRO DAS PESSOAS

                                            for (Pessoa pLista : pessoa.findAll()) {
                                                str += pLista.getCpf() + "  " + pLista.getNome() + "  Tel:  " + pLista.getTelefone() + "\n";
                                            }
                                            if (!pessoa.findAll().isEmpty()) {
                                                JOptionPane.showMessageDialog(null, str);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Não há pessoa cadastrada!");
                                            }
                                            str = ""; //Prepara a String para nova consulta
                                            break;
                                        case 2: //BUSCAR CADASTRO
                                            long cpfBuscado = Long.parseLong(JOptionPane.showInputDialog("BUSCA DE PESSOA:\n Informe o CPF:"));
                                            Pessoa retPessoa = pessoa.findByCpf(cpfBuscado);
                                            if (retPessoa != null) {
                                                str = retPessoa.getCpf() + "  " + retPessoa.getNome() + " Tel:  " + retPessoa.getTelefone();
                                                JOptionPane.showMessageDialog(null, str);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Não ha pessoa cadastrada com esse CPF.");
                                            }
                                            str = ""; //Prepara a String para nova consulta
                                            break;
                                        case 3: //REALIZAR CADASTRO DE PESSOA
                                           
                                            Pessoa p4 = new Pessoa(); //Nova pessoa
                                            Pessoa retPessoa2 = new Pessoa(); //cria um obj para armazenar retorno
                                           
                                            cpfBuscado = Long.parseLong(JOptionPane.showInputDialog("Informe o CPF:"));
                                           
                                            retPessoa2 = pessoa.findByCpf(cpfBuscado);
                                          
                                            if (retPessoa2 != null) { //verifica a existencia do cadastro
                                                JOptionPane.showMessageDialog(null, "Ja existe pessoa cadastrada com esse CPF.");
                                                break;
                                            } 
                                            else {
                                                p4.setCpf(cpfBuscado);
                                                p4.setId(ip);
                                                p4.setNome(JOptionPane.showInputDialog("Informe o nome:"));
                                                p4.setTelefone(JOptionPane.showInputDialog("Informe o telefone:"));
                                                pessoa.createPessoa(p4); //adiciona a lista
                                                ip++; //incrementa o id
                                                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                                            }
                                            break;

                                        case 4: //EXCLUIR CADASTRO DE PESSOA
                                            cpfBuscado = Long.parseLong(JOptionPane.showInputDialog("REMOVER CADASTRO:\n Informe o CPF:"));
                                            pessoa.removeByCpf(cpfBuscado);
                                            break;
                                        case 5: //Sair
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null, "Opção invalida!");
                                            break;
                                    } //fim do switch op
                                } while (op != 5);
                                op = 0;

                                break;
                            case 2: //MENU DO MATERIAL INFORMACIONAL
                                do {
                                    op = Integer.parseInt(JOptionPane.showInputDialog("CADASTRO DE MATERIAL:"
                                            + "\n1-Listar Cadastro"
                                            + "\n2-Realizar Cadastro"
                                            + "\n3-Procurar Cadastro por tipo"
                                            + "\n4-Procurar por codigo"
                                            + "\n5-Sair do Cadastro de Material"));
                                    switch (op) {
                                        case 1: //LISTAR CADASTRO DE MATERIAL INFORNCIONAL
                                            saida = "";
                                            for (MaterialInformacional elem : matInf.getMaterial()) {
                                                if (elem.getCodigoBarras().substring(0, 1).equals("1")) {
                                                    saida += "Livro: ";
                                                    saida += "CB:" + elem.getCodigoBarras() + " - " + elem.getTitulo() + " - Estante: " + elem.getEstante() + " - Qtd.Exemplares: " + elem.getExemplares() + " - Qtd.Disp.: " + elem.getDisponiveis() + "\n";
                                                } else if (elem.getCodigoBarras().substring(0, 1).equals("2")) {
                                                    saida += "Period.: ";
                                                    saida += "CB:" + elem.getCodigoBarras() + " - " + elem.getTitulo() + " - Estante: " + elem.getEstante() + " - Qtd.Exemplares: " + elem.getExemplares() + " - Qtd.Disp.: " + elem.getDisponiveis() + "\n";
                                                } else if (elem.getCodigoBarras().substring(0, 1).equals("3")) {
                                                    saida += "Mat.Esp.: ";
                                                    saida += "CB:" + elem.getCodigoBarras() + " - " + elem.getTitulo() + " - Estante: " + elem.getEstante() + " - Qtd.Exemplares: " + elem.getExemplares() + " - Qtd.Disp.: " + elem.getDisponiveis() + "\n";
                                                }
                                            }
                                            JOptionPane.showMessageDialog(null, "MATERIAL CADASTRADO:\n" + saida);
                                            break;
                                        case 2: //BUSCAR CADASTRO DE MATERIAL INFORMACIONAL
                                            int tipo = Integer.parseInt(JOptionPane.showInputDialog("Escolha o tipo:"
                                                    + "\n1-Livro"
                                                    + "\n2-Periodico"
                                                    + "\n3-Material Especial"));
                                            if (tipo == 1) {
                                                //criando obj de material informacional
                                                //LIVRO 1                                             
                                                Livro livro4 = new Livro();
                                                livro4.setId(miL);
                                                livro4.setTitulo(JOptionPane.showInputDialog("Informe o Nome do livro:"));
                                                livro4.setCodigoBarras(String.valueOf(10000 + miL)); //vai gerar o codigo de barra automatico
                                                livro4.setEstante(Integer.parseInt(JOptionPane.showInputDialog("Informe a estante(int):")));
                                                livro4.setExemplares(Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de exemplares(int):")));
                                                livro4.setDisponiveis(livro4.getExemplares()); //Pq no ato do cadastro todos os exemplares estão disponiveis
                                                livro4.setIsbn(Integer.parseInt(JOptionPane.showInputDialog("Informe o ISBN(int):")));
                                                livro4.setAno(Integer.parseInt(JOptionPane.showInputDialog("Informe o ano(aaaa):")));
                                                livro4.setVolume(Integer.parseInt(JOptionPane.showInputDialog("Informe o volume(int):")));
                                                
                                                //Instanciando Autor
                                                Autor autor4 = new Autor();
                                                autor4.setId(miL + 10);
                                                autor4.setNome(JOptionPane.showInputDialog("Informe o 1º Nome do Autor:"));
                                                autor4.setSobreNome(JOptionPane.showInputDialog("Informe o 2º Nome do livro:"));
                                                livro4.setAutor(autor4); //add autor
                                                
                                                //instanciando Editora
                                                Editora editora4 = new Editora();
                                                editora4.setId(miL * 10);
                                                editora4.setNome(JOptionPane.showInputDialog("Informe o Nome da Editora:"));
                                                editora4.setTipo(1);
                                                livro.setEditora(editora4); //add editora

                                                //Adicionar o livro a base de dado
                                                matInf.create(livro4);
                                                miL++;

                                            } else if (tipo == 2) {
                                                //criando obj de material informacional
                                                //PERIODICO 01
                                                Periodico per3 = new Periodico();
                                                per3.setId(miP);
                                                per3.setTitulo(JOptionPane.showInputDialog("Informe o Nome do Titulo:"));
                                                per3.setCodigoBarras(String.valueOf(20000 + miP)); //vai gerar o codigo de barra automatico
                                                per3.setEstante(Integer.parseInt(JOptionPane.showInputDialog("Informe a Estante(int):")));
                                                per3.setExemplares(Integer.parseInt(JOptionPane.showInputDialog("Informe o exemplar(int):")));
                                                per3.setDisponiveis(per3.getExemplares()); //Pq no ato do cadastro todos os exemplares estão disponiveis
                                                per3.setIssn(Integer.parseInt(JOptionPane.showInputDialog("Informe o ISSN(int):")));
                                                per3.setVolume(Integer.parseInt(JOptionPane.showInputDialog("Informe o volume(int):")));
                                                per3.setAno(Integer.parseInt(JOptionPane.showInputDialog("Informe o ano(aaaa):")));

                                                //Adicionar o livro a base de dado
                                                matInf.create(per3);
                                                miP++;
                                            } else if (tipo == 3) {
                                                //criando obj de material informacional
                                                //MATERIAL ESPECIAL 1
                                                MaterialEspecial especial3 = new MaterialEspecial();
                                                especial3.setId(miE);
                                                especial3.setTitulo(JOptionPane.showInputDialog("Informe o titulo:"));
                                                especial3.setCodigoBarras(String.valueOf(30000 + miE)); //vai gerar o codigo de barra automatico
                                                especial3.setEstante(Integer.parseInt(JOptionPane.showInputDialog("Informe a estante(int):")));
                                                especial3.setExemplares(Integer.parseInt(JOptionPane.showInputDialog("Informe o numero de exemplares(int):")));
                                                especial3.setDisponiveis(especial3.getExemplares()); //Pq no ato do cadastro todos os exemplares estão disponiveis
                                                especial3.setDescricao(JOptionPane.showInputDialog("Descrição do material:"));
                                                
                                                //instanciando o tipo de material especial
                                                TipoMaterialEspecial tipoME3 = new TipoMaterialEspecial();
                                                tipoME3.setId(miE + 10);
                                                tipoME3.setNome(JOptionPane.showInputDialog("Informe o tipo do Material Especial(DVD, CD ou FITA):"));
                                                especial.setTipoMaterialEspecial(tipoME3);

                                                //Adicionar o livro a base de dado
                                                matInf.create(especial3);
                                                miE++;

                                            } else {
                                                JOptionPane.showMessageDialog(null, "Opção invalida!");
                                            }
                                            break;
                                        case 3: //Buscar Cadastro por tipo - RETORNO OK - falta formata-la apenas
                                            tipoMat = Integer.parseInt(JOptionPane.showInputDialog("Informe o tipo:"
                                                    + "\n1-Livro"
                                                    + "\n2-Periodico"
                                                    + "\n3-Material Especial"));
                                            //Trata o retorno da função que é uma lista

                                            for (MaterialInformacional elem : matInf.findByTipo(tipoMat)) {
                                                tipoStr += elem.getCodigoBarras() + " - " + elem.getTitulo()
                                                        + " Estante: " + elem.getEstante() + " - Qtd.Exemplares: " + elem.getExemplares()
                                                        + " - Qtd.Disp.: " + elem.getDisponiveis() + "\n";
                                            }
                                            JOptionPane.showMessageDialog(null, tipoStr);
                                            break;
                                        case 4: //BUSCAR MATERIAL INFORMACIONAL POR CODIGO DE BARRAS
                                            long matBuscado = Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo de barras:"));

                                            //Trata o retorno da função que é uma lista
                                            MaterialInformacional matRetorno = matInf.findByCodigoBarras(matBuscado); //instanciei para receber o retorno da função

                                            String strMI = matRetorno.getCodigoBarras() + " - " + matRetorno.getTitulo() + "     Estante: "
                                                    + matRetorno.getEstante() + "    Qtd: " + matRetorno.getExemplares() + "     Disp.: " + matRetorno.getDisponiveis() + "\n";

                                            JOptionPane.showMessageDialog(null, strMI); //saida tratada
                                            break;
                                        case 5: //Sair
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null, "Opção invalida!");
                                            break;
                                    } //fim do switch op
                                } while (op != 5);
                                op = 0;
                                break;
                            case 3: //Sair
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção invalida!");
                                break;
                        } //fim do switch op
                    } while (op != 3);
                    op = 0;
                    break;
                case 4: //Sair
                    JOptionPane.showMessageDialog(null, "Fechando o Programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção invalida!");
                    break;
            } //fim do switch op
        } while (op != 4);
    } //fim do main
} //fim da classe

    

