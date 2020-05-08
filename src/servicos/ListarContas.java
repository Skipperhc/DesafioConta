package servicos;

import models.*;
import servicos.interfaces.Listar;

import java.util.List;

public class ListarContas implements Listar {
    private ListaDeContas contas = ListaDeContas.getInstance();

    @Override
    public void listarContasCorrentes() {
        Console.printPrompt("\n");
        for (Conta con : contas.getListaContas()) {
            if(con instanceof ContaCorrente) {
                Console.printPrompt(con.toString());
            }
        }
    }

    @Override
    public void listarContasPoupanca() {
        Console.printPrompt("\n");
        for (Conta con : contas.getListaContas()) {
            if(con instanceof ContaPoupanca) {
                Console.printPrompt(con.toString());
            }
        }
    }

    @Override
    public void listarTodasContas() {
        Console.printPrompt("\n");
        for (Conta con : contas.getListaContas()) {
            Console.printPrompt(con.toString());
        }
    }

    @Override
    public void listarTodasAsContasComOperacoes() {
        Console.printPrompt("\n");
        for (Conta con : contas.getListaContas()) {
            Console.printPrompt(con.toString());
            for (Operacao op : con.listaOperacoes) {
                Console.printPrompt(op.toString());
            }
            Console.printPrompt("\nEsta conta realizou um total de " + con.listaOperacoes.size() + "\n");
        }
    }
}
