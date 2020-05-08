package models;

public class ContaCorrente extends Conta {

    public ContaCorrente(String nomeCliente, double saldo, String banco, double limite) {
        super(nomeCliente, saldo, banco);
        this.limite = limite;
    }

    private double limite;

    public double getLimite() {
        return this.limite;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + " Nome: " + getNomeCliente() + " | " +
                "Banco: " + getBanco() + " | " + "Saldo: " + super.getSaldo() + " | Limite: " + getLimite() + "\n";
    }

    @Override
    public double valorMax() {
        return limite + getSaldo();
    }
}
