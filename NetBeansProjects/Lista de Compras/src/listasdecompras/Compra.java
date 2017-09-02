package listasdecompras;

import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class Compra extends JInternalFrame {
    
    ArrayList <Produto> produtos = new ArrayList<>();
    String mes;
    float precoTotal;
    
    public Compra(String mes) {
        this.mes = mes;
        precoTotal = 0;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fundo = new javax.swing.JPanel();
        lbMes = new javax.swing.JLabel();
        lbPreco = new javax.swing.JLabel();
        btAdd = new javax.swing.JButton();
        btDeletar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        Scroll = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setClosable(true);

        fundo.setBackground(java.awt.Color.white);

        lbMes.setText("Mês: " + mes);

        lbPreco.setText("Preço: " + precoTotal);

        btAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgAdd.png"))); // NOI18N
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgDeletar.png"))); // NOI18N
        btDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeletarActionPerformed(evt);
            }
        });

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgSalvar.png"))); // NOI18N
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgAtualizar.png"))); // NOI18N
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        atualizarDados();
        /*
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        */
        Scroll.setViewportView(tabela);

        javax.swing.GroupLayout fundoLayout = new javax.swing.GroupLayout(fundo);
        fundo.setLayout(fundoLayout);
        fundoLayout.setHorizontalGroup(
            fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPreco)
                    .addComponent(lbMes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDeletar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAtualizar)
                .addContainerGap())
            .addComponent(Scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
        );
        fundoLayout.setVerticalGroup(
            fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btAtualizar)
                    .addComponent(btSalvar)
                    .addGroup(fundoLayout.createSequentialGroup()
                        .addComponent(lbMes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPreco))
                    .addComponent(btDeletar)
                    .addComponent(btAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fundo, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        addProduto();
    }//GEN-LAST:event_btAddActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        atualizarDados();
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        validarAlteracoes();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletarActionPerformed
        removerProduto();
    }//GEN-LAST:event_btDeletarActionPerformed

    public void addProduto() {
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
        produtos.add(new Produto(nome, unidadeDeCompra, localDeCompra, qnt, preco, tipo));
        //Atualiza a tabela
        atualizarDados();
    }
    
    public void removerProduto() {
        
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
        
        Object [][] dados = new Object[produtos.size()][6];
        
        for(i = 0; i < produtos.size(); i++) {
            dados[i][0] = produtos.get(i).nome;
            dados[i][1] = produtos.get(i).unidadeDeCompra;
            dados[i][2] = produtos.get(i).localDeCompra;
            dados[i][3] = produtos.get(i).getQntString();
            dados[i][4] = produtos.get(i).getPrecoString();
            dados[i][5] = produtos.get(i).getTipoString();
            
            precoTotal += produtos.get(i).preco;
        }
        
        msgFormat = String.format("Mês: %s  |  Total: R$ %.2f", mes, precoTotal);
        lbMes.setText(msgFormat);
        
        String strLista[] = new String[produtos.size()];
        for(i = 0; i < produtos.size(); i++) {
            strLista[i] = String.format("%d - %s", i, produtos.get(i).nome);
        }
        
        tabela.setModel(new DefaultTableModel(dados, a));
    }
    
    public void validarAlteracoes() {
        int i;
        int guardarInt = 0;
        float guardarFloat = 0;
        String convert, msg;
        int op = JOptionPane.showConfirmDialog(null, "Deseja mesmo atualizar os dados?\nAs informações anteriores serão perdidas");
        if(op == 0) {
            for(i = 0; i < produtos.size(); i++) {
                //guardando uns dados que serão utilizados posteriormentes
                guardarInt = produtos.get(i).qnt;
                guardarFloat = produtos.get(i).preco;
                    
                produtos.get(i).nome = tabela.getValueAt(i, 0).toString();
                produtos.get(i).unidadeDeCompra = tabela.getValueAt(i, 1).toString();
                produtos.get(i).localDeCompra = tabela.getValueAt(i, 2).toString();

                try {
                    if(!produtos.get(i).getQntString().equals(tabela.getValueAt(i, 3).toString())) {
                        msg = String.format("Deseja alterar a quantidade do produto %s?\nDigite um valor inteiro:", produtos.get(i).nome);
                        convert = JOptionPane.showInputDialog(msg, tabela.getValueAt(i, 3).toString());
                        produtos.get(i).alterarQnt(Integer.parseInt(convert));
                    }
                }
                catch (NumberFormatException erroConv) {
                    JOptionPane.showMessageDialog(null, "O número digitado é inválido");
                    produtos.get(i).qnt = guardarInt;
                }
                catch (NullPointerException nulo) {
                    produtos.get(i).qnt = guardarInt;
                }
       
                try {
                    if(guardarFloat == produtos.get(i).preco) {
                        if(!produtos.get(i).getPrecoString().equals(tabela.getValueAt(i, 4).toString())) {
                            msg = String.format("Deseja alterar o preço do(a) %s?\n\nDigite o novo preço.\n\n(Digite apenas pontos e números)", produtos.get(i).nome);
                            convert = JOptionPane.showInputDialog(msg, tabela.getValueAt(i, 4));
                            produtos.get(i).preco = Float.parseFloat(convert);
                        }
                    }
                }
                catch(NumberFormatException erroConv) {
                    JOptionPane.showMessageDialog(null, "O número digitado é inválido");
                    produtos.get(i).preco = guardarFloat;
                }
                catch (NullPointerException nulo) {
                    produtos.get(i).preco = guardarFloat;
                }
                        
                    
            }
            atualizarDados();
        }
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Scroll;
    public javax.swing.JButton btAdd;
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btDeletar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JPanel fundo;
    private javax.swing.JLabel lbMes;
    private javax.swing.JLabel lbPreco;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
