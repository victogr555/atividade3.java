package zoologico.model;

import java.util.ArrayList;
import java.util.List;

public class Zoologico {
    private static int counter = 0;
    private final int id;
    private String nome;
    private String localizacao;
    private final List<Ambiente> ambientes = new ArrayList<>();

    public Zoologico(String nome, String localizacao) {
        this.id = ++counter;
        this.nome = nome;
        this.localizacao = localizacao;
    }
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getLocalizacao() { return localizacao; }
    public List<Ambiente> getAmbientes() { return new ArrayList<>(ambientes); }

    public void adicionarAmbiente(Ambiente a) { ambientes.add(a); }
    public boolean removerAmbiente(Ambiente a) { return ambientes.remove(a); }

    @Override
    public String toString() {
        return String.format("Zoológico[%d] %s - %s - ambientes: %d", id, nome, localizacao, ambientes.size());
    }
}


