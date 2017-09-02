package listasdecompras;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.util.ArrayList;

public class PrevisaoDaCompra extends Compra {
    ArrayList <Produto> produtos = new ArrayList<>();
    public PrevisaoDaCompra() {
        super("Próximo Mês");
    }
    
    public final void preencherProdutos(ArrayList <Compra> a) {
        int i, j;
        for(i = 0; i < a.size(); i++) {
            for(j = 0;j < a.get(i).produtos.size(); j++)
                produtos.add(a.get(i).produtos.get(j));
        }
    }
    
    @Override
    public void addProduto() {
        //Adiciona um produto a lista. Se for essencial, vai para o topo, se não for vai para o final
        int op = JOptionPane.showConfirmDialog(null, "Deseja adicionar um produto existente");
        if(op == 1) {
            int i;
            Object lista[] = new Object[produtos.size()];
            for(i = 0; i < produtos.size(); i++) 
                lista[i] = String.format(produtos.get(i).nome 
                        + ", " 
                        + produtos.get(i).localDeCompra 
                        + " R$ "
                        + produtos.get(i).getPrecoString());

            int a = JOptionPane.showOptionDialog(null, lista, "Escolha o produto", WIDTH, HEIGHT, null, lista, null);
            Produto p = produtos.get(a);
            switch(p.tipo) {
                case 1:
                    i = 0;
                    while(produtos.get(i).tipo == 1)
                        i++;
                    produtos.add(i, p);
                    break;
                case 2:
                    i = produtos.size();
                    while(produtos.get(i).tipo == 3)
                        i--;
                    produtos.add(i, p);
                    break;
                case 3:
                    produtos.add(produtos.size(), p);
                    break;
            }
            //Atualiza a tabela
            atualizarDados();
        }
        else {
            addProduto();
        }
    }
    
    
    public void addNovoProduto() {
        /*
         * O seguinte método coleta todas os atributos de um
         * produto que seŕão passados posteriormente para a classe
         * produto.
         */
        /*    */
        
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
        switch(tipo) {
            case 1:
                i = 0;
                while(produtos.get(i).tipo == 1)
                    i++;
                produtos.add(i, new Produto(nome, unidadeDeCompra, localDeCompra, qnt, preco, tipo));
                break;
            case 2:
                i = produtos.size();
                while(produtos.get(i).tipo == 3)
                    i--;
                produtos.add(i, new Produto(nome, unidadeDeCompra, localDeCompra, qnt, preco, tipo));
                break;
            case 3:
                produtos.add(produtos.size(), new Produto(nome, unidadeDeCompra, localDeCompra, qnt, preco, tipo));
                break;
            }
        //Atualiza a tabela
        atualizarDados();
    }
    
    public void pagar() {
        float preco = 0;
        String str = JOptionPane.showInputDialog(null, "Digite o valor que você gastou ou vai gastar:\nApenas numeros e pontos");
        boolean valido = false;
        
        while(valido != true) {
            try {
                preco = Float.parseFloat(str);
            }
            catch (NumberFormatException erro) {
                JOptionPane.showMessageDialog(null, "Preço Inválido");
                preco = 0;
            }
            
            if(preco != 0)
                valido = true;
        }
    }
    
    
} 
