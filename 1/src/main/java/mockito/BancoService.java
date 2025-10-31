package projeto;

import java.util.Objects;

public class BancoService {

    private final ContaRepository contaRepository;

    public BancoService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public double consultarSaldo(String numeroConta) {
        var contaCliente = contaRepository.buscarConta(numeroConta);
        return contaCliente.getSaldo();
    }

    public void depositar(String numeroConta, double valor) {
        var contaCliente = contaRepository.buscarConta(numeroConta);

        if(valor <= 0) {
            throw new IllegalArgumentException("Valor do depósito deve ser maior que zero.");
        }

        if(Objects.isNull(contaCliente)) {
            throw new IllegalArgumentException("Conta não encontrada.");
        }

        var saldoAtual = contaCliente.getSaldo();
        var saldoAtualizado = saldoAtual + valor;
        contaCliente.setSaldo(saldoAtualizado);
        contaRepository.salvar(contaCliente);
    }

}
