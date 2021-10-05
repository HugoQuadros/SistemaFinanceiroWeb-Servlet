package service;

import br.com.minhaempresa.domain.Cliente;
import br.com.minhaempresa.domain.Conta;
import br.com.minhaempresa.domain.ContaCorrente;

public class ConsultarSaldoService {

    public double consultarSaldo (String nome, String sobrenome){

        Cliente cliente1 = new Cliente(nome, sobrenome);
        Conta conta1 = new ContaCorrente(cliente1);
        return conta1.consultarSaldo();

    }

}
