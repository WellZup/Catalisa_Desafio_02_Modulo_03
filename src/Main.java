import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        ListaGeral listaGeral = new ListaGeral();

        boolean continuar = true;
        while (continuar) {
            System.out.println("======== MENU ========");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Vendedor");
            System.out.println("3 - Cadastrar Venda");
            System.out.println("4 - Pesquisar Compras por Cliente (CPF)");
            System.out.println("5 - Pesquisar Vendas por Vendedor (Email)");
            System.out.println("6 - Listar Informações");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");
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
                    listaGeral.pesquisarComprasPorCliente();
                    break;
                case 5:
                    listaGeral.pesquisarVendasPorVendedor();
                    break;
                case 6:
                    listaGeral.listarInformacoes();
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        }
        System.out.println();
    }

}
