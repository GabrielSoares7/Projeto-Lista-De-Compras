package listadecompras;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Home extends JFrame{
    
    ArrayList<Compras> compra = new ArrayList<>();
    int cod = 0;
    
    //Componentes da janela
    
    
    public void iniciar() {
        exibirSobre();
        addCompra();
    }
    
    public void addCompra() {
        String mes = JOptionPane.showInputDialog(null, "Digite o mês da compra: ");
        compra.add(new Compras(mes, cod));
        int op = JOptionPane.showConfirmDialog(null, "Deseja abrir esta lista de compras?");
        if(op == 0)
            abrirLista(cod);
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
    }
}
