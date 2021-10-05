package br.com.minhaempresa.controller;

import br.com.minhaempresa.exception.SaldoInsuficienteException;
import service.SacarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/sacar")
public class SaqueController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String sobrenome = req.getParameter("sobrenome");
        double valor = Double.valueOf(req.getParameter("valor"));
        Double saldo = null;

        SacarService sacarService = new SacarService();

        try {
            saldo = sacarService.sacar(nome, sobrenome, valor);
            resp.getWriter().println("Saque na conta do cliente " + nome + " " + sobrenome +
                    " no valor de " + valor + " feito com sucesso");
            resp.getWriter().println("Seu saldo atualizado é de: " + saldo);
        } catch (SaldoInsuficienteException e) {
            resp.getWriter().println(e.getMessage());
        }

    }
}
