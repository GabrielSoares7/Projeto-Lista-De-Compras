package listadecompras;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.AbstractListModel;

public class Home extends JFrame{
    
    ArrayList<Compras> compra = new ArrayList<>();
    int cod = 0;
    
    //Componentes da janela]
    private JPanel fundo; 
    private JScrollPane Scroll;
    private JMenuBar barraDeMenu;
    private JMenu mArquivo;
    private JButton btAbrir;
    private JButton btAddLista;
    private JButton btPrevisao;
    private JButton btRemover;
    private JMenu jMenu1;
    private JMenuItem imAddLista;
    private JMenuItem imEditar;
    private JMenuItem imSair;
    private JMenuItem imSobre;
    private JLabel lbInfo;
    private JList<String> listaCompras;
    
    
    public void iniciar() {
        fundo = new JPanel();
        Scroll = new JScrollPane();
        barraDeMenu = new JMenuBar();
        mArquivo = new JMenu();
        btAbrir = new JButton();
        btAddLista = new JButton();
        btPrevisao = new JButton();
        btRemover = new JButton();
        jMenu1 = new JMenu();
        imAddLista = new JMenuItem();
        imEditar = new JMenuItem();
        imSair = new JMenuItem();
        imSobre = new JMenuItem();
        lbInfo = new JLabel();
        listaCompras = new JList<>();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fundo.setBackground(new java.awt.Color(254, 254, 254));

        btAddLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/listadecompras/imagens/imgAdd.png"))); // NOI18N
        btAddLista.setMnemonic('A');
        btAddLista.setText("Adicionar Lista");
        btAddLista.addActionListener((java.awt.event.ActionEvent evt) -> {
            addCompra();
        });

        atualizarDados();
        Scroll.setViewportView(listaCompras);

        btPrevisao.setText("Previsão");

        lbInfo.setText("(Código)   -  Nome da lista");

        btAbrir.setText("Abrir");
        btAbrir.addActionListener((java.awt.event.ActionEvent evt) -> {
            //abrirLista();
        });

        btRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/listadecompras/imagens/imgDeletar.png"))); // NOI18N
        btRemover.setText("Remover lista");
        btRemover.addActionListener((java.awt.event.ActionEvent evt) -> {
            removerCompra();
        });

        GroupLayout fundoLayout = new GroupLayout(fundo);
        fundo.setLayout(fundoLayout);
        fundoLayout.setHorizontalGroup(
            fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Scroll, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fundoLayout.createSequentialGroup()
                        .addComponent(btPrevisao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 330, Short.MAX_VALUE)
                        .addComponent(btRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAddLista))
                    .addComponent(lbInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fundoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btAbrir)))
                .addContainerGap())
        );
        fundoLayout.setVerticalGroup(
            fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAddLista)
                    .addComponent(btPrevisao)
                    .addComponent(btRemover))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAbrir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mArquivo.setText("Arquivo");

        imAddLista.setText("Adicionar Lista");
        imAddLista.addActionListener((java.awt.event.ActionEvent evt) -> {
            addCompra();
        });
        mArquivo.add(imAddLista);

        imSobre.setText("Sobre");
        imSobre.addActionListener((java.awt.event.ActionEvent evt) -> {
            exibirSobre();
        });
        mArquivo.add(imSobre);

        imSair.setText("Sair");
        imSair.addActionListener((java.awt.event.ActionEvent evt) -> {
            sair();
        });
        mArquivo.add(imSair);

        barraDeMenu.add(mArquivo);

        jMenu1.setText("Editar");

        imEditar.setText("Editar nome da lista");
        imEditar.addActionListener((java.awt.event.ActionEvent evt) -> {
            editarTituloLista();
        });
        jMenu1.add(imEditar);

        barraDeMenu.add(jMenu1);

        setJMenuBar(barraDeMenu);

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(fundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        this.setVisible(true);
    }
    
    public void addCompra() {
        String mes = JOptionPane.showInputDialog(null, "Digite o mês da compra: ");
        compra.add(new Compras(mes, cod));
        cod++;
        int op = JOptionPane.showConfirmDialog(null, "Deseja abrir esta lista de compras?");
        if(op == 0)
            abrirLista(cod);
        
        atualizarDados();
    }
    
    public void removerCompra() {
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
            if(i < compra.size()) {
                str = String.format("Deseja mesmo excluir esta lista?\nTodos os dados contidos\nna lista " 
                        + compra.get(i).mes
                        + " serão perdidos");
                int op = JOptionPane.showConfirmDialog(null, str);
                if(op == 0)
                    compra.remove(i);
            }
        }
        atualizarDados();
    }
    
    public int buscarCodigo(int codigo) {
        int i;
        boolean existe = false;
        for(i = 0; i < compra.size(); i++) {
            if(codigo == compra.get(i).cod){
                existe = true;
                break;
            }
        }
        
        if(existe == false) {
            JOptionPane.showMessageDialog(null, "Este código de compra não existe");
            return compra.size();
        }
        else
            return i;
    }
    
    public void abrirLista(int  codigo) {
        int i = buscarCodigo(codigo);
        if(i < compra.size()) {
            this.setVisible(false);
            compra.get(i).exibir();
            this.setVisible(true);
        }
    }
    
    public void sair() {
        int op = JOptionPane.showConfirmDialog(null, "Deseja mesmo sair?\nTodos os dados serão perdidos");
        if(op == 0)
            System.exit(0);
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
            if(i < compra.size());
                compra.get(i).mes = JOptionPane.showInputDialog("Digite o mês:\n");
        }  
        atualizarDados();
    }
    
    public void atualizarDados() {
        int i;
        String str[] = new String[compra.size()];
        
        for(i = 0; i < compra.size(); i++) 
            str[i] = String.format("(%d) - %s ", compra.get(i).cod, compra.get(i).mes);
       
       listaCompras.setModel(new AbstractListModel<String>() {
            String[] strings = str;
            @Override
            public int getSize() { return strings.length; }
            @Override
            public String getElementAt(int i) { return strings[i]; }
        });
    }
}
