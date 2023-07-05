public class Venda {
    private final Cliente cliente;
    private final Vendedor vendedor;
    private final double valor;
    private final String dataRegistro;

    public Venda(Cliente cliente, Vendedor vendedor, double valor, String dataRegistro) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.valor = valor;
        this.dataRegistro = dataRegistro;
    }

    public Cliente getCliente() {
        return cliente;
    }



    public Vendedor getVendedor() {
        return vendedor;
    }



    public double getValor() {
        return valor;
    }



    public String getDataRegistro() {
        return dataRegistro;
    }

}
