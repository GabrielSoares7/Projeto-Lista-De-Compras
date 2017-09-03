package listasdecompras;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

//Elementos da interface gráfica swing
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class Compra extends JInternalFrame {
    /* A classe Compra é responsável por gerar cada lista de compra.
     * Nela temos 3 atributos:
     * - Um ArrayList de produtos, que torna possvíel adicionar vários produtos em
     * na classe
     * - Uma string (mes) que guarda o mês/título da lista
     * - Um "float" que calcula o preço total da lista.
     *
     * A classe também possui os atributos da interface gráfica. Os principais são:
     * - JButton:
     *      btAdd -> addProduto();
     *      btAtualizar -> atualizarDados();
     *      btDeletar -> removerProduto();
     *      btSalvar -> validarAlteracoes();
     * - JTable tabela: mostra todos os produtos e suas informações. O método 
     * atualizarDados() fica responsável por preencher a tabela.
    
     * É importanter ressaltar que a classe herda características da classe JInternalFrame
    **/
    
    //Atributos
    ArrayList <Produto> produtos = new ArrayList<>(); 
    String mes;
    float precoTotal;
    
    //Construtor
    public Compra(String mes) {
        this.mes = mes;
        precoTotal = 0;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fundo = new JPanel();
        lbTitulo = new JLabel();
        btAdd = new JButton();
        btDeletar = new JButton();
        btSalvar = new JButton();
        btAtualizar = new JButton();
        Scroll = new JScrollPane();
        tabela = new JTable();

        setClosable(true);

        fundo.setBackground(Color.white);

        lbTitulo.setText("Mês: " + mes);

        btAdd.setIcon(new ImageIcon(getClass().getResource("/img/imgAdd.png"))); // NOI18N
        btAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addProduto();
            }
        });

        btDeletar.setIcon(new ImageIcon(getClass().getResource("/img/imgDeletar.png"))); // NOI18N
        btDeletar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                removerProduto();
            }
        });

        btSalvar.setIcon(new ImageIcon(getClass().getResource("/img/imgSalvar.png"))); // NOI18N
        btSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                validarAlteracoes();
            }
        });

        btAtualizar.setIcon(new ImageIcon(getClass().getResource("/img/imgAtualizar.png"))); // NOI18N
        btAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                atualizarDados();
            }
        });

        atualizarDados();
        
        Scroll.setViewportView(tabela);

        GroupLayout fundoLayout = new GroupLayout(fundo);
        fundo.setLayout(fundoLayout);
        fundoLayout.setHorizontalGroup(
            fundoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(fundoLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(lbTitulo)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAdd)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDeletar)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSalvar)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAtualizar)
                .addContainerGap())
            .addComponent(Scroll, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
        );
        fundoLayout.setVerticalGroup(
            fundoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(fundoLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(fundoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(btAtualizar)
                    .addComponent(btSalvar)
                    .addGroup(fundoLayout.createSequentialGroup()
                        .addComponent(lbTitulo)
                        .addGap(20, 20, 20))
                    .addComponent(btDeletar)
                    .addComponent(btAdd))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Scroll, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(fundo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(fundo, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void addProduto() {
        /*
         * O seguinte método coleta todas os atributos de um
         * produto que seŕão passados posteriormente para a classe
         * produto. Ele é chamado sempre que o botão '+' (btAdd) é selecionado
         */
        
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
        produtos.add(new Produto(nome, unidadeDeCompra, localDeCompra, qnt, preco, tipo));
        //Atualiza a tabela
        atualizarDados();
    }
    
    public void removerProduto() {
        /* O método exibe uma lista de produtos, na qual o usuário seleciona 1 para
         * ser removido. O método é chamado pelo botão 'btDeletar'
        **/
        
        String [] str = new String[produtos.size()];//Cria um vetor de string que será usado na lista
        int i;
        for(i = 0; i < produtos.size(); i++) {
            str[i] = produtos.get(i).getNome();
        }
        JComboBox opListas = new JComboBox();
        opListas.setModel(new DefaultComboBoxModel<>(str));
        JOptionPane.showMessageDialog(null, opListas, "Selecione a lista: ", JOptionPane.QUESTION_MESSAGE);
        i = opListas.getSelectedIndex();//Recebe o índice do produto selecionado
        
        int op = JOptionPane.showConfirmDialog(null, String.format("Deseja mesmo deletar o\nproduto '"
                + produtos.get(i).getNome()
                + "'?"));//Verifica se o usuário realmente deseja remover o produto
        if(op == 0) // Se op for 0, significa que o usuário selecionou a opção 'SIM'
            produtos.remove(i); // Remove o produto na posicao 1
        atualizarDados();// Exibe a tabela com as alterações realizadas
    }

    public void atualizarDados() {
        /* O método atualizarDados() é chamado sempre que uma alteração acontece
         * na lista de produtos ou então quando o botão 'btAtualizar'
         * é selecionado. Ele (o método) é responsável por atualizar os dados da
         * tabela, além de calcular o preço total e exibir na JLabel lbTitulo
        **/
        int i;
        precoTotal = 0;
        String msgFormat;
        String a[] = new String [6]; //Titulo da tabela
        a[0] = "Produto";
        a[1] = "Unidade de Compra";
        a[2] = "Local";
        a[3] = "Quantidade";
        a[4] = "Preço";
        a[5] = "Tipo";
        
        Object [][] dados = new Object[produtos.size()][6];
        
        for(i = 0; i < produtos.size(); i++) { // Conteúdo da tabela
            dados[i][0] = produtos.get(i).getNome();
            dados[i][1] = produtos.get(i).getUnidadeDeCompra();
            dados[i][2] = produtos.get(i).getLocalDeCompra();
            dados[i][3] = produtos.get(i).getQntString();
            dados[i][4] = produtos.get(i).getPrecoString();
            dados[i][5] = produtos.get(i).getTipoString();
            
            precoTotal += (float) produtos.get(i).getPreco() * produtos.get(i).getQnt();
        }
        tabela.setModel(new DefaultTableModel(dados, a)); // Atualiza os dados da tabela
        
        msgFormat = String.format("Mês: %s  |  Total: R$ %.2f", mes, precoTotal);
        lbTitulo.setText(msgFormat); //Atualiza o "título" da janela
    }
    
    public void validarAlteracoes() {
        /* Este método guarda todas as alterões realizadas na tabela no ArrayList
         * produtos quando o 'btSalvar' é executado
        **/
        int i;
        int guardarInt = 0;
        float guardarFloat = 0;
        String convert, msg;
        int op = JOptionPane.showConfirmDialog(null, "Deseja mesmo atualizar os dados?\nAs informações anteriores serão perdidas");
        // Verifica se o usuário realmente deseja guardar as alterações
        if(op == 0) {
            for(i = 0; i < produtos.size(); i++) {
                // Guardando uns dados que serão utilizados posteriormente caso
                // o número digtado pelo usuário seja inválido
                guardarInt = produtos.get(i).getQnt();
                guardarFloat = produtos.get(i).getPreco();
                
                //Guarda as alterações em "nome", "UnidadeDeCompra" e "Local"
                produtos.get(i).setNome(tabela.getValueAt(i, 0).toString());
                produtos.get(i).setUnidadeDeCompra(tabela.getValueAt(i, 1).toString());
                produtos.get(i).setLocalDeCompra(tabela.getValueAt(i, 2).toString());

                // Os tratamentos impedem que o usuário digite um número errado e
                // prejudique o funcionamento do programa
                try {
                    if(!produtos.get(i).getQntString().equals(tabela.getValueAt(i, 3).toString())) {
                        msg = String.format("Deseja alterar a quantidade do produto %s?\nDigite um valor inteiro:", produtos.get(i).getNome());
                        convert = JOptionPane.showInputDialog(msg, tabela.getValueAt(i, 3).toString());
                        produtos.get(i).setQnt(Integer.parseInt(convert));
                    }
                }
                catch (NumberFormatException erroConv) {
                    JOptionPane.showMessageDialog(null, "O número digitado é inválido");
                    produtos.get(i).setQnt(guardarInt);
                }
                catch (NullPointerException nulo) {
                    produtos.get(i).setQnt(guardarInt);
                }
       
                try {
                    if(!produtos.get(i).getPrecoString().equals(tabela.getValueAt(i, 4).toString())) {
                        msg = String.format("Deseja alterar o preço do(a) %s?\n\nDigite o novo preço.\n\n(Digite apenas pontos e números)", produtos.get(i).getNome());
                        convert = JOptionPane.showInputDialog(msg, tabela.getValueAt(i, 4));
                        produtos.get(i).setPreco(Float.parseFloat(convert));
                    }
                }
                catch(NumberFormatException erroConv) {
                    JOptionPane.showMessageDialog(null, "O número digitado é inválido");
                    produtos.get(i).setPreco(guardarFloat);
                }
                catch (NullPointerException nulo) {
                    produtos.get(i).setPreco(guardarFloat);
                }
                        
                    
            }
            atualizarDados(); //Exibe as alterações na tabela
        }
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JScrollPane Scroll;
    public JButton btAdd;
    private JButton btAtualizar;
    private JButton btDeletar;
    private JButton btSalvar;
    public JPanel fundo;
    private JLabel lbTitulo;
    private JTable tabela;
    // End of variables declaration//GEN-END:variables
}
