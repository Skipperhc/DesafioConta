import servicos.Controlador;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.executar();
    }


    private void executar() {
        Controlador con = new Controlador();
        con.telaDeOpcoes();
    }
}