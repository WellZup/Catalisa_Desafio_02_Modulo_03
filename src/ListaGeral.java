import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaGeral {
    public static Scanner entrada = new Scanner(System.in);
    public static List<Cliente> clientes = new ArrayList<>();
    public static List<Vendedor> vendedores = new ArrayList<>();
    public static List<Venda> vendas = new ArrayList<>();




    // Função para verificar se um cliente já está cadastrado
    private static boolean isClienteCadastrado(Cliente cliente) {
        return clientes.contains(cliente);
    }
    private static Cliente ClienteCadastrado(String nomeCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                return cliente;
            }
        }
        return null;
    }



    // Função para verificar se um vendedor já está cadastrado
    private static boolean isVendedorCadastrado(Vendedor vendedor) {
        return vendedores.contains(vendedor);
    }

    private static Vendedor getVendedorCadastrado(String nomeVendedor) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getNome().equalsIgnoreCase(nomeVendedor)) {
                return vendedor;
            }
        }
        return null;
    }


    public static void cadastrarCliente() {
        System.out.print("Nome do Cliente: ");
        String nomeCliente = entrada.nextLine();
        System.out.print("CPF do Cliente: ");
        String cpfCliente = entrada.nextLine();
        System.out.print("Email do Cliente: ");
        String emailCliente = entrada.nextLine();

        Cliente novoCliente = new Cliente(nomeCliente, cpfCliente,emailCliente);
        clientes.add(novoCliente);

        System.out.println("Cliente cadastrado com sucesso.");
    }

    public static void cadastrarVendedor() {
        System.out.print("Nome do Vendedor: ");
        String nomeVendedor = entrada.nextLine();
        System.out.print("CPF do Vendedor: ");
        String cpfVendedor = entrada.nextLine();
        System.out.print("Email do Vendedor: ");
        String emailVendedor = entrada.nextLine();

        Vendedor novoVendedor = new Vendedor(nomeVendedor,cpfVendedor,emailVendedor);
        vendedores.add(novoVendedor);

        System.out.println("Vendedor cadastrado com sucesso.");
    }

    public static void cadastrarVenda() {
        System.out.print("Nome do Cliente: ");
        String nomeCliente = entrada.nextLine();

        Cliente cliente = ClienteCadastrado(nomeCliente);
        if (cliente == null) {
            System.out.println("Cliente não cadastrado.");
            return;
        }



        System.out.print("Nome do Vendedor: ");
        String nomeVendedor = entrada.nextLine();

        Vendedor vendedor = getVendedorCadastrado(nomeVendedor);
        if (vendedor == null) {
            System.out.println("Vendedor não cadastrado.");
            return;
        }

        System.out.print("Valor da Venda: ");
        double valorVenda = entrada.nextDouble();
        entrada.nextLine();

        System.out.print("Data de Registro: ");
        String dataRegistro = entrada.nextLine();

        Venda novaVenda = new Venda(cliente, vendedor, valorVenda, dataRegistro);
        vendas.add(novaVenda);

        System.out.println("Venda cadastrada com sucesso.");
    }


    public static void listarInformacoes() {
        System.out.println("Vendas Registradas:");
        for (Venda venda : vendas) {
            System.out.println("-----------------------");
            System.out.println("Cliente: " + venda.getCliente().getNome());
            System.out.println("Vendedor: " + venda.getVendedor().getNome());
            System.out.println("Valor: " + venda.getValor());
            System.out.println("Data de Registro: " + venda.getDataRegistro());
            System.out.println("-----------------------");
        }

        System.out.println("Vendedores Cadastrados:");
        for (Vendedor vendedor : vendedores) {
            System.out.println("-----------------------");
            System.out.println("Nome: " + vendedor.getNome());
            System.out.println("CPF: " + vendedor.getCpf());
            System.out.println("Email: " + vendedor.getEmail());
            System.out.println("-----------------------");
        }

        System.out.println("Clientes Cadastrados:");
        for (Cliente cliente : clientes) {
            System.out.println("-----------------------");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("-----------------------");
        }
    }
}



