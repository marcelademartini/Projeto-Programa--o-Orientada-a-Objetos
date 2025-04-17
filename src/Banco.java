import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cliente> clientes;
    private List<Conta> contas;

    public Banco() {
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
    }

    public List<Conta> listarContas() {
        return contas;
    }

    public Conta buscarContaPorNumero(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    public Cliente buscarClientePorCPFouCNPJ(String documento) {
        for (Cliente cliente : clientes) {
            if (cliente instanceof PessoaFisica && ((PessoaFisica) cliente).getCpf().equals(documento)) {
                return cliente;
            } else if (cliente instanceof PessoaJuridica && ((PessoaJuridica) cliente).getCnpj().equals(documento)) {
                return cliente;
            }
        }
        return null;
    }
}
