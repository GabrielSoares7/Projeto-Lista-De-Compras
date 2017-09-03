package listasdecompras;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

//Elmentos swing
import javax.swing.table.DefaultTableModel;

public class Pesquisa extends JInternalFrame {

    ArrayList<Compra> listaDeCompras;
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

        jPanel1 = new JPanel();
        entrada = new JTextField();
        lbInfo = new JLabel();
        btPesquisa = new JButton();
        lbInfoTabela = new JLabel();
        jScrollPane1 = new JScrollPane();
        tabela = new JTable();

        setClosable(true);

        jPanel1.setBackground(new Color(254, 254, 254));

        lbInfo.setText("Digite o termo da pesquisa");

        btPesquisa.setText("Pesquisar");
        btPesquisa.setToolTipText("");
        btPesquisa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btPesquisaActionPerformed(evt);
            }
        });

        lbInfoTabela.setText("Qualquer alteração feita na tabela não será salva");

        jScrollPane1.setViewportView(tabela);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(entrada)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btPesquisa))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lbInfo)
                            .addComponent(lbInfoTabela))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbInfo)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(entrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisa))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbInfoTabela)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btPesquisaActionPerformed
        // Executa ação ao clicar no botão Pesquisar
        if(tipoDePesquisa == 1) {
            pesquisarNome();
        }
        else
            pesquisarLocal();
    }//GEN-LAST:event_btPesquisaActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btPesquisa;
    private JTextField entrada;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JLabel lbInfo;
    private JLabel lbInfoTabela;
    private JTable tabela;
    // End of variables declaration//GEN-END:variables
}
