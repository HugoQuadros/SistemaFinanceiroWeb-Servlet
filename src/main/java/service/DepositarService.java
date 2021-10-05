package service;

import br.com.minhaempresa.domain.Cliente;
import br.com.minhaempresa.domain.Conta;
import br.com.minhaempresa.domain.ContaCorrente;

public class DepositarService {

    public double depositar (String nome, String sobrenome, double valor){

        Cliente cliente1 = new Cliente(nome, sobrenome);
        Conta conta1 = new ContaCorrente(cliente1);
        conta1.depositar(valor);

        return conta1.consultarSaldo();
    }

}
