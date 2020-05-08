package models;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(String nomeCliente, double saldo, String banco) {
        super(nomeCliente, saldo, banco);
    }

    @Override
    public String toString() {
        return "Id: " + getId() + " Nome: " + getNomeCliente() + " | " +
                " | Banco: " + getBanco() + " | " + "Saldo: " + getSaldo() + "\n";
    }

    @Override
    public double valorMax() {
        return getSaldo();
    }
}
