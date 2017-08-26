package listadecompras;

//Utilidades
import java.util.ArrayList;


//Interface Gráfica
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.AbstractListModel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;

//Look and Fell
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class Compras {
    /*
     *a classe compras se relaciona com multiplos produtos
     *Uma compra tem n produtos
     */
    //atributos da Classe compra
    String mes;
    ArrayList <Produto> produto = new ArrayList <> ();
    float precoTotal;

    //Construtor
    public Compras (String mes) {
        this.mes = mes;
    }
    
    //Elementos da janela que exibe todos os produtos
    JFrame janelaTudo = new JFrame("Compras do mês");
    JButton btAdd = new JButton();
    JButton btVoltar = new JButton();
    JButton btSalvar = new JButton();
    JButton btAtualizar = new JButton();
    JButton btExcluir = new JButton();
    JLabel lbMes = new JLabel(); 
    JScrollPane scrollFundo = new JScrollPane();
    JTable tabela = new JTable();
    
    //Elemento da janela que exibe e exclui os produtos
    JFrame janelaExcluir = new JFrame("Excluir");
    JPanel fundoJanelaExcluir = new JPanel();
    JLabel lbMsg1 = new JLabel("Cod - Nome");
    JScrollPane scrollRemover = new JScrollPane();
    JList lista = new JList();
    JButton btDeletar = new JButton();
    JButton btFinalizar = new JButton();
    JLabel lbMsg2 = new JLabel("Insira o código do produto\n");
    JTextField entradaCod = new JTextField();
    
    boolean voltar = false;

        // Este método exibe todos os ítens da lista de compras do mes
    @SuppressWarnings("empty-statement")
    public void mostrarTudo() {
        melhorarInterface();
        criarTabela();
        atualizarDados();

        while(voltar == false){
            System.out.print("");
        }
        janelaTudo.setVisible(false);
    }
    
    public void addProduto() {
        /*
         * O seguinte método coleta todas os atributos de um
         * produto que seŕão passados posteriormente para a classe
         * produto.
         */
        /*    */
        melhorarInterface();//chama método que melhora a aparencia da interface gráfica
        
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
        produto.add(new Produto(nome, unidadeDeCompra, localDeCompra, qnt, preco, tipo));
        //Atualiza a tabela
        atualizarDados();
    }
    
    public void melhorarInterface() {//Método melhora interface (Segundo algumas fontes, ativa Look and Fell)
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
                }
            }
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        }
    
    
    }
    
    public void atualizarDados() {
        int i;
        precoTotal = 0;
        String msgFormat;
        String a[] = new String [6];
        a[0] = "Produto";
        a[1] = "Unidade de Compra";
        a[2] = "Local";
        a[3] = "Quantidade";
        a[4] = "Preço";
        a[5] = "Tipo";
        
        Object [][] dados = new Object[produto.size()][6];
        
        for(i = 0; i < produto.size(); i++) {
            dados[i][0] = produto.get(i).nome;
            dados[i][1] = produto.get(i).unidadeDeCompra;
            dados[i][2] = produto.get(i).localDeCompra;
            dados[i][3] = produto.get(i).getQntString();
            dados[i][4] = produto.get(i).getPrecoString();
            dados[i][5] = produto.get(i).getTipoString();
            
            precoTotal += produto.get(i).preco;
        }
        
        msgFormat = String.format("Mês: %s  |  Total: R$ %.2f", mes, precoTotal);
        lbMes.setText(msgFormat);
        
        String strLista[] = new String[produto.size()];
        for(i = 0; i < produto.size(); i++) {
            strLista[i] = String.format("%d - %s", i, produto.get(i).nome);
        }
        
        lista.setModel(new AbstractListModel<String>() {
            String[] strings = strLista;
            @Override
            public int getSize() { 
                return strLista.length; 
            }
            @Override
            public String getElementAt(int i) {
                return strings[i]; 
            }
        });
        
        tabela.setModel(new DefaultTableModel(dados, a));
    }
    
    public void verificarAlterações() {
        int i;
        int guardarInt = 0;
        float guardarFloat = 0;
        String convert, msg;
        int op = JOptionPane.showConfirmDialog(null, "Deseja mesmo atualizar os dados?\nAs informações anteriores serão perdidas");
        if(op == 0) {
            for(i = 0; i < produto.size(); i++) {
                //guardando uns dados que serão utilizados posteriormentes
                guardarInt = produto.get(i).qnt;
                guardarFloat = produto.get(i).preco;
                    
                produto.get(i).nome = tabela.getValueAt(i, 0).toString();
                produto.get(i).unidadeDeCompra = tabela.getValueAt(i, 1).toString();
                produto.get(i).localDeCompra = tabela.getValueAt(i, 2).toString();

                try {
                    if(!produto.get(i).getQntString().equals(tabela.getValueAt(i, 3).toString())) {
                        msg = String.format("Deseja alterar a quantidade do produto %s?\nDigite um valor inteiro:", produto.get(i).nome);
                        convert = JOptionPane.showInputDialog(msg, tabela.getValueAt(i, 3).toString());
                        produto.get(i).alterarQnt(Integer.parseInt(convert));
                    }
                }
                catch (NumberFormatException erroConv) {
                    JOptionPane.showMessageDialog(null, "O número digitado é inválido");
                    produto.get(i).qnt = guardarInt;
                }
                catch (NullPointerException nulo) {
                    produto.get(i).qnt = guardarInt;
                }
       
                try {
                    if(guardarFloat == produto.get(i).preco) {
                        if(!produto.get(i).getPrecoString().equals(tabela.getValueAt(i, 4).toString())) {
                            msg = String.format("Deseja alterar o preço do(a) %s?\n\nDigite o novo preço.\n\n(Digite apenas pontos e números)", produto.get(i).nome);
                            convert = JOptionPane.showInputDialog(msg, tabela.getValueAt(i, 4));
                            produto.get(i).preco = Float.parseFloat(convert);
                        }
                    }
                }
                catch(NumberFormatException erroConv) {
                    JOptionPane.showMessageDialog(null, "O número digitado é inválido");
                    produto.get(i).preco = guardarFloat;
                }
                catch (NullPointerException nulo) {
                    produto.get(i).preco = guardarFloat;
                }
                        
                    
            }
            atualizarDados();
        }
    }
    
    public void criarTabela() {
        janelaTudo.setLocationRelativeTo(null);
        tabela = new JTable();

        janelaTudo.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        janelaTudo.setResizable(false);
        
        btSalvar.setIcon(new ImageIcon(getClass().getResource("/listadecompras/imagens/imgSalvar.png")));
        btSalvar.addActionListener((ActionEvent evento) -> {
            verificarAlterações();
        });
        
        btExcluir.setIcon(new ImageIcon(getClass().getResource("/listadecompras/imagens/imgDeletar.png")));
        btExcluir.addActionListener((ActionEvent evento) -> {
            criarJanelaRemoverProduto();
        });
        
        btAtualizar.setIcon(new ImageIcon(getClass().getResource("/listadecompras/imagens/imgAtualizar.png"))); // NOI18N
        btAtualizar.addActionListener((ActionEvent evento) -> {
            int op = JOptionPane.showConfirmDialog(null, "Deseja mesmo realizar essa operação?\nDados editados serão perdidos.");
            if(op == 0)
                atualizarDados();
        });
        
        btVoltar.setIcon(new ImageIcon(getClass().getResource("/listadecompras/imagens/imgVoltar.png"))); // NOI18N
        btVoltar.addActionListener((ActionEvent evento) -> {
            voltar = true;
        });
        
        atualizarDados();
        
        scrollFundo.setViewportView(tabela);

        btAdd.setIcon(new ImageIcon(getClass().getResource("/listadecompras/imagens/imgAdd.png"))); // NOI18N
        btAdd.addActionListener((ActionEvent evento) -> {
            addProduto();
        });
        
        GroupLayout layout = new GroupLayout(janelaTudo.getContentPane());
        janelaTudo.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMes)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btVoltar)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAdd)
                .addContainerGap()
                .addComponent(btExcluir)
                .addContainerGap()
                .addComponent(btSalvar)
                .addContainerGap()
                .addComponent(btAtualizar)
                .addContainerGap())

            .addComponent(scrollFundo, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(lbMes)
                    .addComponent(btVoltar)
                    .addComponent(btAdd)
                    .addComponent(btExcluir)
                    .addComponent(btSalvar)
                    .addComponent(btAtualizar))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollFundo, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
        );

        janelaTudo.pack();
        janelaTudo.setVisible(true);
    }
    
    public void removerProduto(int i) {
        int op = JOptionPane.showConfirmDialog(null, "Deseja mesmo remover o produto?");
        if(op == 0) {
            produto.remove(i);
            atualizarDados();
        }
    }
    
    public void criarJanelaRemoverProduto() {
        janelaTudo.setVisible(false);
        
        janelaExcluir.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        janelaExcluir.setLocationRelativeTo(null);
        
        atualizarDados();
        scrollRemover.setViewportView(lista);
        
        btFinalizar.setIcon(new ImageIcon(getClass().getResource("/listadecompras/imagens/imgVoltar.png")));
        btFinalizar.addActionListener((ActionEvent evt) -> {
            janelaExcluir.setVisible(false);
            janelaTudo.setVisible(true);
        });
        
        btDeletar.setIcon(new ImageIcon(getClass().getResource("/listadecompras/imagens/imgDeletar.png")));
        btDeletar.addActionListener((ActionEvent evento) -> {
            int i;
            try {
                i = Integer.parseInt(entradaCod.getText());
            }
            catch (NumberFormatException erroConv) {
                i = produto.size();
            }
            
            if(i < produto.size())
                removerProduto(i);
            else
                JOptionPane.showMessageDialog(null, "ERRO!\nImpossível realizar a operação!");
        });
        
        GroupLayout fundoJanelaExcluirLayout = new GroupLayout(fundoJanelaExcluir);
        fundoJanelaExcluir.setLayout(fundoJanelaExcluirLayout);
        fundoJanelaExcluirLayout.setHorizontalGroup(
            fundoJanelaExcluirLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrollRemover)
            .addGroup(fundoJanelaExcluirLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fundoJanelaExcluirLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(fundoJanelaExcluirLayout.createSequentialGroup()
                        .addComponent(lbMsg1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btFinalizar))
                        .addComponent(lbMsg2)
                    .addGroup(fundoJanelaExcluirLayout.createSequentialGroup()
                        .addComponent(entradaCod, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(btDeletar)))
                .addContainerGap())
        );
        fundoJanelaExcluirLayout.setVerticalGroup(
            fundoJanelaExcluirLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(fundoJanelaExcluirLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fundoJanelaExcluirLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMsg1)
                    .addComponent(btFinalizar))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollRemover, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(lbMsg2)
                .addGroup(fundoJanelaExcluirLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(entradaCod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDeletar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(janelaExcluir.getContentPane());
        janelaExcluir.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fundoJanelaExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fundoJanelaExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        janelaExcluir.pack();
        
        
        
        janelaExcluir.setVisible(true);
    }
}