package br.com.minhaempresa.controller;

import br.com.minhaempresa.domain.Cliente;
import br.com.minhaempresa.domain.Conta;
import br.com.minhaempresa.domain.ContaCorrente;
import br.com.minhaempresa.exception.SaldoInsuficienteException;
import service.TransferirService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/transferir")
public class TransferenciaController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String sobrenome = req.getParameter("sobrenome");
        double valor = Double.valueOf(req.getParameter("valor"));

        Cliente clienteDestino = new Cliente("Senhor", "Destino");
        Conta destino = new ContaCorrente(clienteDestino);

        TransferirService transferirService = new TransferirService();
        try {
            double saldo = transferirService.transferir(nome, sobrenome, valor, destino);
            resp.getWriter().println("Transferencia para a conta do cliente " + clienteDestino.getNome() + " " + clienteDestino.getSobrenome() +
                    " no valor de " + valor + " feita com sucesso");
            resp.getWriter().println("Seu saldo atualizado é de: " + saldo);
        } catch (SaldoInsuficienteException e) {
            resp.getWriter().println(e.getMessage());
        }

    }
}