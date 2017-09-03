package listasdecompras;

public class Produto {
    
    //Atributos da classe produto;
    private String nome;
    private String unidadeDeCompra;
    private String localDeCompra;
    private int qnt;
    private float preco;
    private int tipo;
    /*
     * A variavel tipo (int tipo), pode receber 3 valores diferentes indicando
     * a prioridade do produto:
     * 1 - Essencial
     * 2 - Importante
     * 3 - Secundário
     * O método getTipoString() retorna uma string indicando a prioridade do produto
    **/
    
    //Construtor da classe Produto que recebe todos os atributos
    public Produto(String nome, String unidadeDeCompra, String localDeCompra, int qnt, float preco, int tipo) {
        this.nome = nome;
        this.unidadeDeCompra = unidadeDeCompra;
        this.localDeCompra = localDeCompra;
        this.qnt = qnt;
        this.preco = preco;
        this.tipo = tipo;
    }
    
    public String getQntString() {
        //Este método retorna a quantidade do produto em string para ser usada na tabela
        return String.format("" + qnt);
    }
    
    public String getPrecoString() {
        /*O método getPrecoString() retorna uma string formatada, por exemplo,
         *se o usuário digitar '2.5', o método retornará 'R$ 2.50'
        **/
        return String.format("R$ %.2f", preco);
    }
    
    public String getTipoString() {
        //Método retorna, como já foi dito anteriormente, o tipo do produto em string
        switch (tipo) {
            case 1:
                return "Essencial";
            case 2:
                return "Importante";
            default:
                return "Secundario";
        }
    }

    /* Métodos Geters e Seters, que devem ser usados para que as outras classes 
     * possam ter acesso aos valores que estão privados
    **/
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidadeDeCompra() {
        return unidadeDeCompra;
    }

    public void setUnidadeDeCompra(String unidadeDeCompra) {
        this.unidadeDeCompra = unidadeDeCompra;
    }

    public String getLocalDeCompra() {
        return localDeCompra;
    }

    public void setLocalDeCompra(String localDeCompra) {
        this.localDeCompra = localDeCompra;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}