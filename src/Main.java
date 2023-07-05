import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        ListaGeral listaGeral = new ListaGeral();

        boolean continuar = true;
        while (continuar) {
            System.out.println("========= Menu: =========");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Vendedor");
            System.out.println("3. Cadastrar Venda");
            System.out.println("4. Listar Vendas, Vendedores e Clientes Cadastrados");
            System.out.println("5. Sair");
            System.out.println("=== Escolha uma opção: ===");
            int opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    listaGeral.cadastrarCliente();
                    break;
                case 2:
                    listaGeral.cadastrarVendedor();
                    break;
                case 3:
                    listaGeral.cadastrarVenda();
                    break;
                case 4:
                    listaGeral.listarInformacoes();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

}
