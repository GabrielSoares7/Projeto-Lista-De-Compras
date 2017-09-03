package listasdecompras;

//Interface Gráfica: Elementos AWT
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//Elementos Swing
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

//Utilidades
import java.util.ArrayList;



public class Home extends JFrame {
    /* A classe Home contem o método main, que faz com que ela seja a primeira 
     * classe executada. A classe herda os atributos e métodos da classe JFrame
     * que possibilita a criação de uma janela.
    **/
    
    //atributos
    ArrayList <Compra> compras = new ArrayList<>(); //Permite que o  usuário
                                                    //adicione várias listas
                                                    //de compras
    PrevisaoDaCompra previsao = new PrevisaoDaCompra(); //Classe da previsao de
                                                        //compra
    //Construtor
    public Home() {
        initComponents();//Inicia interface gráfica
    }
    
        public static void main(String args[]) {
        //Método main
        try {
            //ativa interface "look and fell"
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //inicia interface gráfica
        EventQueue.invokeLater(() -> {
            new Home().setVisible(true);
        });
    }
    
    public void addCompra() {
    	//Adiciona lista de comopras
        String mes = JOptionPane.showInputDialog(null, "Digite o mês da compra: ");
        compras.add(new Compra(mes));
        
        //Atualiza a lista que exibe as listas de compra
        atualizarDados();
    }
    
    public void criarLista() {
    	/* Este método pede para que o usuário digite o mês/título da lista e cria
    	 * uma nova lista de compra com base nos itens que existem na previsão. Automaticamente
    	 * ele já exclui os itens adicionados aqui da previsão.
    	**/
        int i, op;
        float gastos = 0;
        String str;
        int indice = compras.size() - 1;
        if(indice < 1)
            indice = 0;
        
        if(previsao.produtos.size() > 0) {
            str = JOptionPane.showInputDialog("Digite o mês da compra:");
            compras.add(indice, new Compra(str));
            atualizarDados();
            for(i = 0; i < previsao.produtos.size(); i++) {
                str = String.format("Você já gastou R$ "
                        + gastos
                        + "\nDeseja comprar o produto abaixo?\n"
                        + previsao.produtos.get(i).getNome()
                        + ", R$ " 
                        + previsao.produtos.get(i).getPreco()
                        + "\nProduto "
                        + previsao.produtos.get(i).getTipoString()
                        + "\n\n(Conclua a compra clicando em cancelar)");
                op = JOptionPane.showConfirmDialog(null, str);
                if(op == 0) {
                    compras.get(indice).produtos.add(previsao.produtos.get(i));
                    previsao.precoTotal -= previsao.produtos.get(i).getPreco();
                    gastos += previsao.produtos.get(i).getPreco();
                    previsao.produtos.remove(i);
                    previsao.atualizarDados();
                    compras.get(indice).atualizarDados();
                }
                else if(op == 2) {
                    JOptionPane.showMessageDialog(null, "Operação Realizada!\n");
                    break;
                }
            }
        }
    }
    
    public void deletar() {
    	//Deleta uma lista de compra selecionada em uma caixa de dialogo
        try {
            String [] a = new String[compras.size()];
            int i;
            for(i = 0; i < compras.size(); i++) {
                a[i] = compras.get(i).mes;
            }
            JComboBox opListas = new JComboBox();
            opListas.setModel(new DefaultComboBoxModel<>(a));
            JOptionPane.showMessageDialog(null, opListas, "Selecione a lista: ", JOptionPane.QUESTION_MESSAGE);

            i = opListas.getSelectedIndex();
            int op = JOptionPane.showConfirmDialog(null, String.format("Deseja mesmo deletar a\nlista '"
                    + compras.get(i).mes 
                    + "'?"));
            if(op == 0)
                compras.remove(i);
            atualizarDados();
        }catch(ArrayIndexOutOfBoundsException erro) {}
    }
    
    public void atualizarDados() {
    	//Atualiza os dados existentes na lista que está localizada do lado esquerdo da janela
        int i;
        String str[] = new String[compras.size()];
        
        for(i = 0; i < compras.size(); i++) 
            str[i] = String.format("(%d) - %s ", i, compras.get(i).mes);
       
        lista.setModel(new AbstractListModel<String>() {
            String[] strings = str;
            @Override
            public int getSize() { return strings.length; }
            @Override
            public String getElementAt(int i) { return strings[i]; }
        });
    }
    
    public void abrirLista(int i) {
        /* Abre uma lista de compras quando o usuário aperta o botão "abrir".
       	 * O método recebe um inteiro i, indicando o índice do ítem que foi selecionado na lista,
       	 * que corresponde ao mesmo índice do ArrayList compras.
       	**/
        try {
            if(i < compras.size()) {
                desktop.add(compras.get(i));
                compras.get(i).setVisible(true);
            }
        }
        catch (IllegalArgumentException erro) {
            desktop.add(compras.get(i));
            compras.get(i).setVisible(true);
        }
        catch(ArrayIndexOutOfBoundsException erro) {
            JOptionPane.showMessageDialog(null, "Nenhum ítem foi selecionado");
        }
    }
    
    public void abrirPrevisao() {   
    	// Quando o botão "previsão" é selecionado, este método abre a lista de previsões
        try {
            desktop.add(previsao);
            previsao.preencherProdutos(compras);
            previsao.setVisible(true);
        }
        catch(IllegalArgumentException erro) {
            desktop.add(previsao);
            previsao.preencherProdutos(compras);
            previsao.setVisible(true);
        }
    }
    
    public void editarTituloLista() {
    	//Método utilizado para alterar o título/mes de uma lista

        String str = JOptionPane.showInputDialog("Digite o código da compra:");
        boolean valido = true;
        int i = 0;
        try {
            i = Integer.parseInt(str);
        } 
        catch(NumberFormatException erro) {
            valido = false;
            JOptionPane.showMessageDialog(null, "Código inválido!");
        }
        if(valido == true) {
            if(i < compras.size() && i >= 0)
                compras.get(i).mes = JOptionPane.showInputDialog("Digite o mês:\n");
            else
                JOptionPane.showMessageDialog(null, "Código inválido!");
        }  
        atualizarDados();
    }
    
    public void exibirSobre() {
    	//Exibe informações sobre o software.
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
    	//Encerra a aplicação caso o usuário desejar
        int op = JOptionPane.showConfirmDialog(null, "Deseja mesmo sair?");
        if(op == 0)
            System.exit(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

    	//Método contendo as configuraçẽos da interface gráfica
    	//O método initComponents() é gerado automaticamente quando usa-se o FormEditor

        fundo = new JPanel();
        jScrollPane1 = new JScrollPane();
        lista = new JList<>();
        btDeletar = new JButton();
        btAdd = new JButton();
        btPrevisao = new JButton();
        btAbrir = new JButton();
        desktop = new JLayeredPane();
        lbImg = new JLabel();
        lbInfo = new JLabel();
        jLabel1 = new JLabel();
        jMenuBar1 = new JMenuBar();
        mArquivo = new JMenu();
        imAdd = new JMenuItem();
        imCriarLista = new JMenuItem();
        imSobre = new JMenuItem();
        imSair = new JMenuItem();
        mEditar = new JMenu();
        imEdit = new JMenuItem();
        mPesquisar = new JMenu();
        imPNome = new JMenuItem();
        imPLocal = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Lista de Compras");
        setResizable(false);

        fundo.setBackground(new Color(254, 254, 254));

        atualizarDados();

        jScrollPane1.setViewportView(lista);

        btDeletar.setIcon(new ImageIcon(getClass().getResource("/img/imgDeletar.png"))); // NOI18N
        btDeletar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deletar();
            }
        });

        btAdd.setIcon(new ImageIcon(getClass().getResource("/img/imgAdd.png"))); // NOI18N
        btAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addCompra();
            }
        });

        btPrevisao.setText("Previsão");
        btPrevisao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                abrirPrevisao();
            }
        });

        btAbrir.setText("Abrir");
        btAbrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                abrirLista(lista.getSelectedIndex());
            }
        });

        lbImg.setIcon(new ImageIcon(getClass().getResource("/img/imgIFLogo.png"))); // NOI18N

        lbInfo.setFont(lbInfo.getFont().deriveFont(lbInfo.getFont().getSize()-1f));
        lbInfo.setForeground(new Color(152, 152, 152));
        lbInfo.setText("Recomendamos que você não abra várias janelas ao mesmo tempo");

        desktop.setLayer(lbImg, JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(lbInfo, JLayeredPane.DEFAULT_LAYER);

        GroupLayout desktopLayout = new GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, desktopLayout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addGroup(desktopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lbInfo)
                    .addComponent(lbImg))
                .addGap(78, 78, 78))
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(desktopLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbImg)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbInfo, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
        );

        jLabel1.setText("Selecione um ítem para abrir");

        GroupLayout fundoLayout = new GroupLayout(fundo);
        fundo.setLayout(fundoLayout);
        fundoLayout.setHorizontalGroup(
            fundoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, fundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fundoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(fundoLayout.createSequentialGroup()
                        .addComponent(btPrevisao)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAdd)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDeletar)
                        .addGap(208, 208, 208))
                    .addComponent(btAbrir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING)
                    .addGroup(fundoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        fundoLayout.setVerticalGroup(
            fundoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(fundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fundoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(desktop)
                    .addGroup(fundoLayout.createSequentialGroup()
                        .addGroup(fundoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(btPrevisao)
                            .addComponent(btDeletar)
                            .addComponent(btAdd))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAbrir)))
                .addContainerGap())
        );

        mArquivo.setText("Arquivo");

        imAdd.setText("Adicionar Lista Compra");
        imAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addCompra();
            }
        });
        mArquivo.add(imAdd);

        imCriarLista.setText("Criar lista usando a previsão");
        imCriarLista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                criarLista();
            }
        });
        mArquivo.add(imCriarLista);

        imSobre.setText("Sobre");
        imSobre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exibirSobre();
            }
        });
        mArquivo.add(imSobre);

        imSair.setText("Fechar");
        imSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sair();
            }
        });
        mArquivo.add(imSair);

        jMenuBar1.add(mArquivo);

        mEditar.setText("Editar");

        imEdit.setText("Editar Título de uma lista");
        imEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editarTituloLista();
            }
        });
        mEditar.add(imEdit);

        jMenuBar1.add(mEditar);

        mPesquisar.setText("Pesquisar");

        imPNome.setText("Pesquisar por nome");
        imPNome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Pesquisa p = new Pesquisa(1, compras);
		        try {
		            desktop.add(p);
		            p.setVisible(true);
		        }
		        catch (java.lang.IllegalArgumentException a) {
		            JOptionPane.showMessageDialog(null, "Não é possível abrir ítem solicitado\nVerifique se alguma janela já está aberta");
		        }
            }
        });
        mPesquisar.add(imPNome);

        imPLocal.setText("Pesquisar por local");
        imPLocal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Pesquisa p = new Pesquisa(2, compras);
		        try {
		            desktop.add(p);
		            p.setVisible(true);
		        }
		        catch (IllegalArgumentException a) {
		            JOptionPane.showMessageDialog(null, "Não é possível abrir ítem solicitado\nVerifique se alguma janela já está aberta");
		        }
            }
        });
        mPesquisar.add(imPLocal);

        jMenuBar1.add(mPesquisar);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(fundo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(fundo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();

        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btAbrir;
    private JButton btAdd;
    private JButton btDeletar;
    private JButton btPrevisao;
    private JLayeredPane desktop;
    private JPanel fundo;
    private JMenuItem imAdd;
    private JMenuItem imCriarLista;
    private JMenuItem imEdit;
    private JMenuItem imPLocal;
    private JMenuItem imPNome;
    private JMenuItem imSair;
    private JMenuItem imSobre;
    private JLabel jLabel1;
    private JMenuBar jMenuBar1;
    private JScrollPane jScrollPane1;
    private JLabel lbImg;
    private JLabel lbInfo;
    private JList<String> lista;
    private JMenu mArquivo;
    private JMenu mEditar;
    private JMenu mPesquisar;
    // End of variables declaration//GEN-END:variables
}