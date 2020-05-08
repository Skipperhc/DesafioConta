package servicos.interfaces;

import models.Conta;

import java.util.List;

public interface Listar {
    void listarContasCorrentes();
    void listarContasPoupanca();
    void listarTodasContas();
    void listarTodasAsContasComOperacoes();
}
