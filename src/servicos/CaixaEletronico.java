package servicos;

import models.Conta;
import models.Operacao;

public class CaixaEletronico {

    private CaixaEletronico() {
    }

    public static void pagar(Conta origem, float valor) {
        Operacao op = new Operacao(origem.getId(), valor);
        origem.setSaldo(origem.getSaldo() - valor);
        origem.setListaOperacoes(op);
        Console.printPrompt("\nPagamento efetuado com sucesso");
    };

    public static void pagar(Conta origem, Conta destino, float valor) {

        origem.setSaldo(origem.getSaldo() - valor);

        destino.setSaldo(destino.getSaldo() + valor);
        Operacao op = new Operacao(origem.getId(), destino.getId(), valor);
        origem.setListaOperacoes(op);
        destino.setListaOperacoes(op);
        Console.printPrompt("\nPagamento efetuado com sucesso");
    };
}
