package models;

import java.util.ArrayList;
import java.util.List;

public class ListaDeContas {
    private static ListaDeContas unicaInstancia = null;
    private ListaDeContas() {
        listaContas = new ArrayList<Conta>();
    }
    public static ListaDeContas getInstance() {
        if(unicaInstancia == null) unicaInstancia = new ListaDeContas();
        return unicaInstancia;
    }
    private List<Conta> listaContas;
    public List<Conta> getListaContas() {
        return listaContas;
    }
    public void addConta(Conta con) {
        listaContas.add(con);
    }
}
