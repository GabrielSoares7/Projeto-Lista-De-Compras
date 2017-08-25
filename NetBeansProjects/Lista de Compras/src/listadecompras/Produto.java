package listadecompras;

public class Produto {
    //Atributos da classe produto;
    String nome;
    String unidadeDeCompra;
    String localDeCompra;
    int qnt;
    float preco;
    int tipo;
    
    public Produto(String nome, String unidadeDeCompra, String localDeCompra, int qnt, float preco, int tipo) {
        this.nome = nome;
        this.unidadeDeCompra = unidadeDeCompra;
        this.localDeCompra = localDeCompra;
        this.qnt = qnt;
        this.preco = preco;
        this.tipo = tipo;
    }
    
    public void alterarQnt(int newQnt) {       
        preco = (float) (newQnt * preco)/qnt;
        qnt = newQnt;
    }
    
    public String getQntString() {
        return String.format("" + qnt);
    }
    
    public String getPrecoString() {
        return String.format("R$ %.2f", preco);
    }
    
    public String getTipoString() {
        if(tipo == 1) 
            return "Essencial";
        
        else if(tipo == 2) 
            return "Importante";
        
        else
            return "Secundario";
    }
}
