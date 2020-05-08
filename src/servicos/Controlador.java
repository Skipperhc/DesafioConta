package servicos;

import models.Conta;
import models.ContaCorrente;
import models.ContaPoupanca;
import models.ListaDeContas;

import java.util.ArrayList;
import java.util.List;

public class Controlador {
    public ListaDeContas contas;
    public Controlador() {
        contas = ListaDeContas.getInstance();
    }

    public void telaDeOpcoes() {

        boolean sair = false;

        while (!sair) {
            Console.printPrompt("\n\nOpções: 1 - Criar conta  -|- 2 - Pagar boleto -|- " +
                    "3 - Transferência -|- 4 - Listar todas as contas -|- 5 - Sair\n\n");

            String opcao = Console.readLine().toLowerCase() + "";

            if (opcao.equals("sair") || opcao.equals("5")) {
                sair = true;
            } else if (opcao.equals("criar conta") || opcao.equals("1")) {
                CriarConta(opcao);
            } else if (opcao.equals("pagar boleto") || opcao.equals("2")) {
                pagarBoleto();
            } else if (opcao.equals("transferencia") || opcao.equals("3")) {
                realizarTransferencia();
            } else if (opcao.equals("listar contas") || opcao.equals("4")) {
                listarContas();
            } else {
                System.out.println("Coloque uma opção existente");
            }
        }
    }

    public void listarContas() {
        ListaDeContas contas = ListaDeContas.getInstance();
        ListarContas list = new ListarContas();
        Console.printPrompt("Escolha uma das opções:\n1 - Listar contas correntes \n2 - Listar contas poupanca\n" +
                "3 - Listar todas contas \n4 - Listar todas as contas mostrando as operacoes\n\n");
        String opcao = Console.readLine();
        if(opcao.equals("Listar contas correntes") || opcao.equals("1")) {
            list.listarContasCorrentes();
        } else if (opcao.equals("Listar contas poupanca") || opcao.equals("2")) {
            list.listarContasPoupanca();
        } else if (opcao.equals("Listar todas contas") || opcao.equals("3")) {
            list.listarTodasContas();
        } else if (opcao.equals("Listar todas as contas mostrando as operacoes") || opcao.equals("4")) {
            list.listarTodasAsContasComOperacoes();
        }

        Console.printPrompt("\nTotal de contas cadastradas: " + contas.getListaContas().size());
        Console.printPrompt("\nPressione enter para prosseguir");
        Console.readLine();
    }

    public void realizarTransferencia() {
        Console.printPrompt("Informe a sua conta:");
        Conta contaOrigem = acharConta();
        Console.printPrompt("Insira o valor da transação");
        float valor = Console.readFloat();
        if(valor > contaOrigem.valorMax()) {
            Console.printPrompt("Valor excede o saldo da conta");
        } else {
            Console.printPrompt("Informe qual a conta de destino");
            Conta contaDestino = acharConta();
            CaixaEletronico.pagar(contaOrigem,contaDestino,valor);
        }
        Console.printPrompt("\nPressione enter para prosseguir");
        Console.readLine();
    }

    public void pagarBoleto() {
        Conta contaOrigem = acharConta();

        Console.printPrompt("Insira o valor da transação");
        float valor = Console.readFloat();
        if(valor > contaOrigem.valorMax()) {
            Console.printPrompt("Valor excede o saldo da conta");
            Console.printPrompt("Seu saldo atual: " + contaOrigem.getSaldo());

//         Console.printPrompt("Valor excede o saldo da conta\n");
//         Console.printPrompt("Seu saldo atual: " + contaOrigem.getSaldo() + ", e o limite disponivel: " +
//         contaOrigem.getLimite());
        } else {
            CaixaEletronico.pagar(contaOrigem, valor);
        }
        Console.printPrompt("\nPressione enter para prosseguir");
        Console.readLine();
    }

    public Conta acharConta() {
        Console.printPrompt("Informe o numero da conta");
        int numConta = Console.readInt();
        for (Conta con : contas.getListaContas()) {
            if(con.getId() == numConta) {
                int index = contas.getListaContas().indexOf(con);
                return contas.getListaContas().get(index);
            }
        }
        return acharConta();
    }

    public void CriarConta(String opcao) {
        while (true) {
        Console.printPrompt("Você escolheu a opção: Criar conta");
        Console.printPrompt("Qual tipo deseja criar?\n1 - Conta poupança\n2 - Conta corrente\n3 - Sair\n");
        String tipoConta = Console.readLine().toLowerCase() + "";

            if (tipoConta.equals("sair") || tipoConta.equals("3")) {
                break;
            } else if (tipoConta.equals("Conta poupança") || tipoConta.equals("1")) {
                criarContaPoupanca();
                break;
            } else if (tipoConta.equals("Conta corrente") || tipoConta.equals("2")) {
                criarContaCorrente();
                break;
            } else {
                Console.printPrompt("Insira uma opção existente");
            }
        }
        Console.printPrompt("\nPressione enter para prosseguir");
        Console.readLine();
    }

    public void criarContaPoupanca() {
        Console.printPrompt("Você escolheu criar uma conta poupança");
        Console.printPrompt("Defina agora: \n");
        Console.printPrompt("\rQual o seu NOME: ");
        String nome = Console.readLine();
        Console.printPrompt("\rQual o SALDO da conta: ");
        double saldo = definirSaldo();
        Console.printPrompt("\rQual o BANCO: ");
        String banco = Console.readLine();
        ContaPoupanca conta = new ContaPoupanca(nome, saldo, banco);
        Console.printPrompt("O ID da sua conta: " + conta.getId());
        contas.addConta(conta);
    }

    public void criarContaCorrente() {
        Console.printPrompt("Você escolheu criar uma conta corrente");
        Console.printPrompt("Defina agora: \n");
        Console.printPrompt("\rQual o seu NOME: ");
        String nome = Console.readLine();
        Console.printPrompt("\rQual o LIMITE da conta: ");
        double limite = Console.readDouble();
        Console.printPrompt("\rQual o SALDO da conta: ");
        double saldo = definirSaldo(limite);
        Console.printPrompt("\rQual o BANCO: ");
        String banco = Console.readLine();
        ContaCorrente conta = new ContaCorrente(nome, saldo , banco, limite);
        Console.printPrompt("O ID da sua conta: " + conta.getId());
        contas.addConta(conta);
    }

    public double definirSaldo() {
        double saldo = Console.readDouble();
        if(saldo < 0) {
            Console.printPrompt("\rSaldo para conta poupança não pode ser negativo: ");
            return definirSaldo();
        }
        return  saldo;
    }

    public double definirSaldo(double limite) {
        double saldo = Console.readDouble();
        if(saldo < (0 - limite)) {
            Console.printPrompt("Saldo para esta conta corrente não pode ser inferior ao limite: " + limite + "\n");
            Console.printPrompt("Insira um valor adequado\n");
            return definirSaldo(limite);
        }
        return  saldo;
    }
}
