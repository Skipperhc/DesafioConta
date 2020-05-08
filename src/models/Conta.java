package models;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {//Conta

    public Conta(String nomeCliente, double saldo, String banco) {
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
        this.banco = banco;
        this.id = numeroContas + 1;
        listaOperacoes = new ArrayList<Operacao>();
        numeroContas++;
    }

    public List<Operacao> listaOperacoes;
    private static int numeroContas;
    private int id;
    private String nomeCliente;
    private double saldo;
    private String banco;

    public int getId() {
        return this.id;
    }

    public String getNomeCliente() {
        return this.nomeCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getBanco() {
        return this.banco;
    }

    public List<Operacao> getListaOperacoes() {
        return this.listaOperacoes;
    }

    public Operacao getOperacao(int numOperacao) {
        for (Operacao op : listaOperacoes) {
            if (op.getId() == numOperacao) {
                int index = listaOperacoes.indexOf(op);
                return listaOperacoes.get(index);
            }
        }
        return null;
    }

    public void setNomeCliente(String nome) {
        this.nomeCliente = nome;
    }

    public void setSaldo(double novoSaldo) {
        this.saldo = novoSaldo;
    }

    public void setBanco(String novoBanco) {
        this.banco = novoBanco;
    }

    public abstract double valorMax();

    public void setListaOperacoes(Operacao op) {
        this.listaOperacoes.add(op);
    }
}
