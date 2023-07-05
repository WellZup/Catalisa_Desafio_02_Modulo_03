import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaGeral {
    public static Scanner entrada = new Scanner(System.in);
    public static List<Cliente> clientes = new ArrayList<>();
    public static List<Vendedor> vendedores = new ArrayList<>();
    public static List<Venda> vendas = new ArrayList<>();




    private static Cliente ClienteCadastrado(String nomeCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                return cliente;
            }
        }
        return null;
    }




    private static Vendedor VendedorNaoCadastrado(String nomeVendedor) {
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



        String cpfCliente;
        boolean cpfValido = false;
        do {
            System.out.print("CPF do Cliente (formato 000.000.000-00): ");
            cpfCliente = entrada.nextLine();

            if (!validarCPF(cpfCliente)) {
                System.out.println("CPF inválido. Tente novamente.");
            } else {
                cpfValido = true;
            }
        } while (!cpfValido);


        String emailCliente;
        boolean emailValido = false;
        do {
            System.out.print("Email do Cliente: ");
            emailCliente = entrada.nextLine();

            if (!validarEmail(emailCliente)) {
                System.out.println("Email inválido. Tente novamente.");
            } else {
                try {
                    verificarDuplicidadeCliente(emailCliente);
                    emailValido = true;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } while (!emailValido);

        Cliente novoCliente = new Cliente(nomeCliente, cpfCliente,emailCliente);
        clientes.add(novoCliente);

        System.out.println("Cliente cadastrado com sucesso.");
        }


    public static void cadastrarVendedor() {
        System.out.print("Nome do Vendedor: ");
        String nomeVendedor = entrada.nextLine();


        String cpfVendedor;
        boolean cpfValido = false;
        do {
            System.out.print("CPF do Vendedor (formato 000.000.000-00): ");
            cpfVendedor = entrada.nextLine();

            if (!validarCPF(cpfVendedor)) {
                System.out.println("CPF inválido. Tente novamente.");
            } else {
                cpfValido = true;
            }
        } while (!cpfValido);



        String emailVendedor;
        boolean emailValido = false;
        do {
            System.out.print("Email do Vendedor: ");
            emailVendedor = entrada.nextLine();

            if (!validarEmail(emailVendedor)) {
                System.out.println("Email inválido. Tente novamente.");
            } else {
                try {
                    verificarDuplicidadeVendedor(emailVendedor);
                    emailValido = true;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } while (!emailValido);



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

        Vendedor vendedor = VendedorNaoCadastrado(nomeVendedor);
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

    public static void verificarDuplicidadeCliente(String email) throws Exception {
        for (Cliente cliente: clientes) {
            if (cliente.getEmail().equalsIgnoreCase(email)) {
                throw new Exception("Email já cadastrado. Digite outro email válido.");
            }
        }
    }

    public static void verificarDuplicidadeVendedor(String email) throws Exception {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getEmail().equalsIgnoreCase(email)) {
                throw new Exception("Email já cadastrado. Digite outro email válido.");
            }
        }
    }

    public static boolean validarCPF(String cpf) {
        String regex = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";
        return cpf.matches(regex);
    }


    private static boolean validarEmail(String email) {
        return email.contains("@");
    }




}



