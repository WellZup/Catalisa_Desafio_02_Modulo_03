public class Venda {
    private Cliente cliente;
    private Vendedor vendedor;
    private double valor;
    private String dataRegistro;

    public Venda(Cliente cliente, Vendedor vendedor, double valor, String dataRegistro) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.valor = valor;
        this.dataRegistro = dataRegistro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
