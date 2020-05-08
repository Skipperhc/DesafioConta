package models;

public class Operacao {
    public Operacao(int contaId, int contaTransferencia, double totalTransferido) {
        this.contaIdOrigem = contaId;
        this.contaIdDestino = contaTransferencia;
        this.totalTransferido = totalTransferido;
        this.id = numeroOperacao + 1;
        numeroOperacao++;
    }

    public Operacao(int contaId, double totalTransferido) {
        this.contaIdOrigem = contaId;
        this.totalTransferido = totalTransferido;
        this.contaIdDestino = 0;
        this.id = numeroOperacao + 1;
        numeroOperacao++;
    }

    @Override
    public String toString() {
        if(contaIdDestino == 0) {
            return "Id " + this.id + " | conta - " + contaIdOrigem + " pagou um boleto no valor de " + totalTransferido + "\n";
        } else {
            return "Id " + this.id + " | conta - " + contaIdOrigem + " transferiu para a conta " +
                contaIdDestino + " o valor de " + totalTransferido + "\n";
        }
    }

    public static int numeroOperacao;
    private int id;
    private int contaIdOrigem;
    private int contaIdDestino;
    private double totalTransferido;

    public static int getNumeroOperacao() {
        return numeroOperacao;
    }

    public int getId() {
        return id;
    }

    public int getContaIdOrigem() {
        return contaIdOrigem;
    }

    public int getContaIdDestino() {
        return contaIdDestino;
    }

    public double getTotalTransferido() {
        return totalTransferido;
    }


}
