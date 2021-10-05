package service;

import br.com.minhaempresa.domain.Cliente;
import br.com.minhaempresa.domain.Conta;
import br.com.minhaempresa.domain.ContaCorrente;
import br.com.minhaempresa.exception.SaldoInsuficienteException;

public class TransferirService {

    public double transferir(String nome, String sobrenome, double valor, Conta destino) throws SaldoInsuficienteException {

        Cliente cliente = new Cliente(nome, sobrenome);
        Conta conta = new ContaCorrente(cliente);
        conta.transferir(valor, destino);

        return conta.consultarSaldo();
    }

}
