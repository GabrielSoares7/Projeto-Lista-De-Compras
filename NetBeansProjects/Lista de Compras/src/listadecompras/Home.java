package listadecompras;

import javax.swing.JOptionPane;

public class Home {
    
    public static void main (String[] args) {
        Compras c = new Compras ("Agosto");
        c.mostrarTudo();
        JOptionPane.showMessageDialog(null, "Tchau");
        System.exit(0);
    }
    
}
