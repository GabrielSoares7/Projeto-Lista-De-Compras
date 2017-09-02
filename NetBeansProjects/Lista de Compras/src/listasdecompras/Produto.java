package listasdecompras;

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
        float oldPreco = preco;
        preco = (float) (newQnt * oldPreco)/qnt;
        qnt = newQnt;
        /* oldQnt ---- oldPreco
         * newQnt ---- newPreco
         * newPreco = oldPreco * newQnt/oldQnt
        **/
    }
    
    public String getQntString() {
        return String.format("" + qnt);
    }
    
    public String getPrecoString() {
        return String.format("R$ %.2f", preco);
    }
    
    public String getTipoString() {
        switch (tipo) {
            case 1:
                return "Essencial";
            case 2:
                return "Importante";
            default:
                return "Secundario";
        }
    }
}