package listasdecompras;

//Interface Gráfica: Elementos AWT
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

//Elementos Swing
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;


//Utilidades
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import listadecompras.Main;


public class Home extends JFrame {
    //atributos
    ArrayList <Compra> compras = new ArrayList<>(); 
    int cod;
    public Home() {
        cod = 0;
        initComponents();
        this.setLocationRelativeTo(null);//por definição no final do método initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fundo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        btDeletar = new javax.swing.JButton();
        btAdd = new javax.swing.JButton();
        btPrevisao = new javax.swing.JButton();
        btAbrir = new javax.swing.JButton();
        desktop = new JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mArquivo = new javax.swing.JMenu();
        imAdd = new javax.swing.JMenuItem();
        imSobre = new javax.swing.JMenuItem();
        imSair = new javax.swing.JMenuItem();
        mEditar = new javax.swing.JMenu();
        imEdit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Lista de Compras");
        setResizable(false);

        fundo.setBackground(new java.awt.Color(254, 254, 254));

        atualizarDados();

        /*
        lista.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        */
        jScrollPane1.setViewportView(lista);

        btDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgDeletar.png"))); // NOI18N

        btAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgAdd.png"))); // NOI18N
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btPrevisao.setText("Previsão");

        btAbrir.setText("Abrir");
        btAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fundoLayout = new javax.swing.GroupLayout(fundo);
        fundo.setLayout(fundoLayout);
        fundoLayout.setHorizontalGroup(
            fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fundoLayout.createSequentialGroup()
                        .addComponent(btPrevisao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(btAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDeletar)
                        .addGap(214, 214, 214))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fundoLayout.createSequentialGroup()
                        .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btAbrir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        fundoLayout.setVerticalGroup(
            fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fundoLayout.createSequentialGroup()
                        .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(fundoLayout.createSequentialGroup()
                        .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btPrevisao)
                            .addComponent(btDeletar)
                            .addComponent(btAdd))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAbrir)))
                .addContainerGap())
        );

        mArquivo.setText("Arquivo");

        imAdd.setText("Adicionar Lista Compra");
        imAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imAddActionPerformed(evt);
            }
        });
        mArquivo.add(imAdd);

        imSobre.setText("Sobre");
        imSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imSobreActionPerformed(evt);
            }
        });
        mArquivo.add(imSobre);

        imSair.setText("Fechar");
        imSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imSairActionPerformed(evt);
            }
        });
        mArquivo.add(imSair);

        jMenuBar1.add(mArquivo);

        mEditar.setText("Editar");

        imEdit.setText("Editar Título de uma lista");
        imEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imEditActionPerformed(evt);
            }
        });
        mEditar.add(imEdit);

        jMenuBar1.add(mEditar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        addCompra();
    }//GEN-LAST:event_btAddActionPerformed

    private void imSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imSairActionPerformed
        sair();
    }//GEN-LAST:event_imSairActionPerformed

    private void btAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirActionPerformed
        abrirLista(0);
    }//GEN-LAST:event_btAbrirActionPerformed

    private void imSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imSobreActionPerformed
        exibirSobre();
    }//GEN-LAST:event_imSobreActionPerformed

    private void imAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imAddActionPerformed
        addCompra();
    }//GEN-LAST:event_imAddActionPerformed

    private void imEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imEditActionPerformed
        editarTituloLista();
    }//GEN-LAST:event_imEditActionPerformed
    
    public void addCompra() {
        String mes = JOptionPane.showInputDialog(null, "Digite o mês da compra: ");
        compras.add(new Compra(mes, cod));
        cod++;
        int op = JOptionPane.showConfirmDialog(null, "Deseja abrir esta lista de compras?");
        if(op == 0)
            abrirLista(cod-1);
        
        atualizarDados();
    }
    
    public void atualizarDados() {
        int i;
        String str[] = new String[compras.size()];
        
        for(i = 0; i < compras.size(); i++) 
            str[i] = String.format("(%d) - %s ", compras.get(i).cod, compras.get(i).mes);
       
       lista.setModel(new AbstractListModel<String>() {
            String[] strings = str;
            @Override
            public int getSize() { return strings.length; }
            @Override
            public String getElementAt(int i) { return strings[i]; }
        });
    }
    
    public void abrirLista(int codigo) {
        atualizarDados();
        int i = buscarCodigo(codigo);
        try {
            if(i < compras.size()) {
                fundo.add(compras.get(0));
                compras.get(0).setVisible(true);
            }
        }
        catch (java.lang.IllegalArgumentException a) {
            JOptionPane.showMessageDialog(null, "Não é possível abrir ítem solicitado\nVerifique se alguma janela já está aberta");
        }
    }
    
    public int buscarCodigo(int codigo) {
        int i;
        boolean existe = false;
        for(i = 0; i < compras.size(); i++) {
            if(codigo == compras.get(i).cod){
                existe = true;
                break;
            }
        }
        
        if(existe == false) {
            JOptionPane.showMessageDialog(null, "Este código de compra não existe");
            return compras.size();
        }
        else
            return i;
    }
    
    public void editarTituloLista() {
        String str = JOptionPane.showInputDialog("Digite o código da compra:");
        boolean valido = true;
        int codigo = 0;
        try {
            codigo = Integer.parseInt(str);
        } 
        catch(NumberFormatException erro) {
            valido = false;
            JOptionPane.showMessageDialog(null, "Código inválido");
        }
        if(valido == true) {
            int i = buscarCodigo(codigo);
            if(i < compras.size());
                compras.get(i).mes = JOptionPane.showInputDialog("Digite o mês:\n");
        }  
        atualizarDados();
    }
    
    public void exibirSobre() {
        String msg = 
                String.format("SOBRE\n"
                        + "Instituto Federal de Alagoas\n\n"
                        + "Desenvolvido por:\n"
                        + "    Almir Gabriel Soares da S. Santos\n"
                        + "    Carlos Emanuel Santos de Melo\n\n"
                        + "Turma: 912A\n\n"
                        + "Trabalho solicitado pela professora\n"
                        + "Clédja Rolin, da discliplina de Programação\n"
                        + "Orientada a Objetos, para fins avaliativos.\n");
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public void sair() {
        int op = JOptionPane.showConfirmDialog(null, "Deseja mesmo sair?");
        if(op == 0)
            System.exit(0);
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Home().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAbrir;
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btDeletar;
    private javax.swing.JButton btPrevisao;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JPanel fundo;
    private javax.swing.JMenuItem imAdd;
    private javax.swing.JMenuItem imEdit;
    private javax.swing.JMenuItem imSair;
    private javax.swing.JMenuItem imSobre;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lista;
    private javax.swing.JMenu mArquivo;
    private javax.swing.JMenu mEditar;
    // End of variables declaration//GEN-END:variables
}