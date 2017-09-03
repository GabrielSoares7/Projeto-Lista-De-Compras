package listasdecompras;

import java.util.ArrayList;

//Elmentos swing
import javax.swing.table.DefaultTableModel;

public class Pesquisa extends javax.swing.JInternalFrame {

    ArrayList<Compra> listaDeCompras = new ArrayList<>();
    int tipoDePesquisa;
    /*
     * Se o tipo de pesquisa for '1', então o botão chama o método
     * "pesquisarNome()". Se for '2', 
     * o método a ser chamado é o "pesquisarLocal()"
    **/
  
    public Pesquisa(int tipo, ArrayList lista) {
        initComponents();
        tipoDePesquisa = tipo;// Recebe o tipo de pesquisa (por nome ou por local)
        listaDeCompras = lista; // Recebe uma lista com todos os produtos
    }
    
    public void pesquisarNome() {
        String pesquisa = entrada.getText();
        int i, j;
        
        int contador = 0;//contar produtos para criar a matriz itens
        for(i = 0; i < listaDeCompras.size(); i++) {
            for(j = 0; j < listaDeCompras.get(i).produtos.size(); j++) {
                if(listaDeCompras.get(i).produtos.get(j).getNome().contains(pesquisa)) {
                    contador++;
                }        
            } 
        }
        Object itens[][] = new Object[contador][6];
        for(i = 0; i < listaDeCompras.size(); i++) {
            for(j = 0; j < listaDeCompras.get(i).produtos.size(); j++) {
                if(listaDeCompras.get(i).produtos.get(j).getNome().contains(pesquisa)) {
                    itens[i][0] = listaDeCompras.get(i).mes;
                    itens[i][1] = listaDeCompras.get(i).produtos.get(j).getNome();
                    itens[i][2] = listaDeCompras.get(i).produtos.get(j).getUnidadeDeCompra();
                    itens[i][3] = listaDeCompras.get(i).produtos.get(j).getLocalDeCompra();
                    itens[i][4] = listaDeCompras.get(i).produtos.get(j).getQntString();
                    itens[i][5] = listaDeCompras.get(i).produtos.get(j).getPrecoString();
                }        
            } 
        }   
        
        atualizarTabela(itens);
    }
    
    public void pesquisarLocal() {
        String pesquisa = entrada.getText();
        int i, j;
        
        int contador = 0;//contar produtos para criar a matriz itens
        for(i = 0; i < listaDeCompras.size(); i++) {
            for(j = 0; j < listaDeCompras.get(i).produtos.size(); j++) {
                if(listaDeCompras.get(i).produtos.get(j).getLocalDeCompra().contains(pesquisa)) {
                    contador++;
                }        
            } 
        }
        Object itens[][] = new Object[contador][6];//Guarda os dados de produtos que contem os dados da pesquisa
        for(i = 0; i < listaDeCompras.size(); i++) {
            for(j = 0; j < listaDeCompras.get(i).produtos.size(); j++) {
                if(listaDeCompras.get(i).produtos.get(j).getLocalDeCompra().contains(pesquisa)) {
                    itens[i][0] = listaDeCompras.get(i).mes;
                    itens[i][1] = listaDeCompras.get(i).produtos.get(j).getNome();
                    itens[i][2] = listaDeCompras.get(i).produtos.get(j).getUnidadeDeCompra();
                    itens[i][3] = listaDeCompras.get(i).produtos.get(j).getLocalDeCompra();
                    itens[i][4] = listaDeCompras.get(i).produtos.get(j).getQntString();
                    itens[i][5] = listaDeCompras.get(i).produtos.get(j).getPrecoString();
                }        
            } 
        }     
        
        atualizarTabela(itens);
    }
    
    public void atualizarTabela(Object [][] itens) {
        //Configura as colunas da tabela e recebe os itens das células
        String titulos [] = new String[6];
        titulos[0] = "Lista";
        titulos[1] = "Produto";
        titulos[2] = "Unidade de Compra";
        titulos[3] = "Local";
        titulos[4] = "Quantidade";
        titulos[5] = "Preço";
        
        //Envia as informações para a JTable
        tabela.setModel(new DefaultTableModel(itens, titulos));
    }
    
    //Método inicia e configura os ítens da interface gráfica
    @SuppressWarnings("unchecked") 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        entrada = new javax.swing.JTextField();
        lbInfo = new javax.swing.JLabel();
        btPesquisa = new javax.swing.JButton();
        lbInfoTabela = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        lbInfo.setText("Digite o termo da pesquisa");

        btPesquisa.setText("Pesquisar");
        btPesquisa.setToolTipText("");
        btPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaActionPerformed(evt);
            }
        });

        lbInfoTabela.setText("Qualquer alteração feita na tabela não será salva");

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
        jScrollPane1.setViewportView(tabela);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(entrada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btPesquisa))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbInfo)
                            .addComponent(lbInfoTabela))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbInfoTabela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaActionPerformed
        // Executa ação ao clicar no botão Pesquisar
        if(tipoDePesquisa == 1) {
            pesquisarNome();
        }
        else
            pesquisarLocal();
    }//GEN-LAST:event_btPesquisaActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPesquisa;
    private javax.swing.JTextField entrada;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbInfo;
    private javax.swing.JLabel lbInfoTabela;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
