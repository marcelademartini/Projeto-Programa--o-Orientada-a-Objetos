import java.util.Scanner;

public class InterfaceGrafica {
    private Scanner scanner = new Scanner(System.in);
    private Banco banco = new Banco();

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n===== BANCO DIGITAL =====");
            System.out.println("1 - Cadastrar Pessoa Física");
            System.out.println("2 - Cadastrar Pessoa Jurídica");
            System.out.println("3 - Listar Clientes");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarPessoaFisica();
                    break;
                case 2:
                    cadastrarPessoaJuridica();
                    break;
                case 3:
                    listarClientes();
                    break;
                case 4:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);
    }

    private void cadastrarPessoaFisica() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        PessoaFisica pf = new PessoaFisica(nome, cpf);
        banco.adicionarCliente(pf);
        System.out.println("Pessoa Física cadastrada com sucesso!");
    }

    private void cadastrarPessoaJuridica() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        PessoaJuridica pj = new PessoaJuridica(nome, cnpj);
        banco.adicionarCliente(pj);
        System.out.println("Pessoa Jurídica cadastrada com sucesso!");
    }

    private void listarClientes() {
        System.out.println("\n--- Clientes Cadastrados ---");
        for (Cliente cliente : banco.listarClientes()) {
            System.out.println("Nome: " + cliente.getNome());
        }
    }
}
