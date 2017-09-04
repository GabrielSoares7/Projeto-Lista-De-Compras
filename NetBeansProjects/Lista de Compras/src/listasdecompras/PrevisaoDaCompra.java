package listasdecompras;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class PrevisaoDaCompra extends Compra {
    
   /* A classe PrevisaoDaCompra é bastante parecida com a classe Compra: as duas 
    * exibem uma lista de produtos, os atributos são quase os mesmos. Praticamente, 
    * a única diferença entre as duas é que a classe PrevisaoDaCompra organizará
    * a lista pela ordem de prioridade de um produto. Sendo assim, para não termos
    * que repetir o mesmo código em duas classes, a classe PrevisaoDaCompra está 
    * herdando "as características" da classe Compra.
    */
    
    ArrayList <Produto> p = new ArrayList<>();
   /* Sempre que esta classe é executada, o ArrayList 'p' recebe todos os produtos
    * existentes em todas as listas de produtos, para que o usuário possa 
    * adicionar um produto que já existe em outras listas.
    */
    
    //Construtor da Classe
    public PrevisaoDaCompra() {
        super("Próximo Mês");//"Chama" o construtor da superclasse Compra
    }
    
    public void preencherProdutos(ArrayList <Compra> a) {
        /* Este método preenche o ArrayList 'p' com todas as informações de produtos
         * existentes. Ele recebe da classe principal o ArrayList a, do tipo compra,
         * que contem as informacoes desejadas.
        **/
        p.removeAll(p);
        int i, j;
        for(i = 0; i < a.size(); i++) {
            for(j = 0;j < a.get(i).produtos.size(); j++)
                p.add(a.get(i).produtos.get(j));
        }
    }
    
    /* O método addProduto() é chamado sempre que o botão '+' é selecionado.
     * Como pretende-se adicionar produtos já existentes na lista de compras, 
     * o 'addProduto()' desta classe está sobrescrevendo o método 'addProduto()
     * da superclasse.
    **/

    @Override //A anotação "@Override" indica que o método sobrescreve outro
    public void addProduto() {
        // Exibe uma caixa de diálogo perguntando se o usuário deseja adicionar um
        // produto existente
        int op = 1;
        if(p.size() > 0)
            op = JOptionPane.showConfirmDialog(null, "Deseja adicionar um produto existente");
        // Se op for 0, significa que o usuário selecionou o botão "SIM", se não,
        // significa que o usuário selecionou o botão "NÃO" ou "CANCELAR"
        
        if(op == 0) {
            // Código executado se o usuário desejar adicionar um produto existente
            
            int i; //Variável será usada como índice
            String lista[] = new String[p.size()]; // String recebe o nome, o local e o preco de todos os produtos
            for(i = 0; i < p.size(); i++) 
                lista[i] = String.format(p.get(i).getNome()
                        + ", " 
                        + p.get(i).getLocalDeCompra()
                        + " R$ "
                        + p.get(i).getPrecoString());
            
            /* Cria caixa de seleção de produtos */
            JComboBox opProdutos = new JComboBox(); // Cria uma lista vazia
            opProdutos.setModel(new DefaultComboBoxModel<>(lista));// Cria uma lista contendo a String lista,
                                                                   // que possui todos os produtos
            JOptionPane.showMessageDialog(null, opProdutos, "Selecione o produto", JOptionPane.QUESTION_MESSAGE);
            // A linha anterior exibe a lista dentro de uma caixa de diálogo
            int a = opProdutos.getSelectedIndex(); // Variável a recebe o índice da opção selecionada, que é o mesmo
                                                   // Que corresponde ao índice do mesmo produto no ArrayList p
            Produto objP = p.get(a); // O objeto de Produto (objP) recebe o ítem do ArrayList na posição 'a' 
            switch(objP.getTipo()) { // Recebe o tipo do produto desejado e compara:
                case 1: // Se for 1, adiciona no topo da lista
                    i = 0;
                    produtos.add(0, objP);
                    break;
                case 2: // Se for 2, adiciona logo abaixo de todos os ítens de tipo 1 o produto
                    i = 0;
                    while(produtos.get(i).getTipo() == 1 && i < produtos.size())
                        i++;
                    produtos.add(i, objP);
                    break;
                case 3:
                    // Se for 3, adiciona o produto no fim da lista
                    produtos.add(produtos.size(), objP);
                    break;
            }
            //Atualiza a tabela
            atualizarDados(); //chama o método que atualiza todos os proudtos
        }
        else {
            addNovoProduto(); //adiciona novo produto caso o usuário não queira adicinar um existente
        }
    }
    
    
    public void addNovoProduto() {//Semelhante ao método addProduto() da superclasse
        //Este método adiciona um novo produto ao ArrayList produto
        
        //Nas três linhas seguintes, o programa coleta o nome, a unidade de compra e o local de compra do produto
        String nome = JOptionPane.showInputDialog("Digite o nome do produto");
        String unidadeDeCompra = JOptionPane.showInputDialog("Digite a unidade do produto\n(Ex.: Kg, g, L)");
        String localDeCompra = JOptionPane.showInputDialog("Digite o local onde você fez a compra");
        

        String recebeNum;// Essa string vai armazenar os dados que o "JOptionPane()" retorna para
                    // posteriormente serem convertidos em valores inteiros ou decimais.

        int qnt = 0;
        boolean ex = false;
        
        //Tratamento de excessão para caso o usuário forneça dados (quantiade e preço) inesejados
        while(ex != true) {
            recebeNum = JOptionPane.showInputDialog("Digite a quantidade (insira um valor válido (Inteiro)):");
            try {
                ex = true;
                qnt = Integer.parseInt(recebeNum);
            }catch (NumberFormatException erroConv){
                JOptionPane.showMessageDialog(null, "ERRO!\nAparentemente, o valor digitado é inválido");
                ex = false;
            }
            
        }
        
        float preco = 0;
        ex = false;
        while(ex != true) {
            recebeNum = JOptionPane.showInputDialog("Digite o preço da compra (Use apenas pontos))\n R$:");
            try {
                ex = true;
                preco = Float.parseFloat(recebeNum);
            }catch (NumberFormatException erroConv){
                ex = false;
                JOptionPane.showMessageDialog(null, "ERRO!\nAparentemente, o valor digitado é inválido");
            }
        }
        UIManager.put("OptionPane.cancelButtonText", "Secundário");
        UIManager.put("OptionPane.noButtonText", "Importante");
        UIManager.put("OptionPane.yesButtonText", "Essencial");
        int tipo = JOptionPane.showConfirmDialog(null, "Digite o tipo do Produto");
        tipo++;
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        UIManager.put("OptionPane.noButtonText", "Não");
        UIManager.put("OptionPane.yesButtonText", "Sim");
        
        //Adiciona um produto a lista
        int i;
        switch(tipo) { // Coloca o ítem na posição
            case 1:
                i = 0;
                produtos.add(0, new Produto(nome, unidadeDeCompra, localDeCompra, qnt, preco, tipo));
                break;
            case 2:
                i = 0;
                while(produtos.get(i).getTipo() == 1 && i < produtos.size())
                    i++;
                produtos.add(i, new Produto(nome, unidadeDeCompra, localDeCompra, qnt, preco, tipo));
                break;
            case 3:
                produtos.add(produtos.size(), new Produto(nome, unidadeDeCompra, localDeCompra, qnt, preco, tipo));
                break;
           }
        //Atualiza a tabela
        atualizarDados();
    }
} 
