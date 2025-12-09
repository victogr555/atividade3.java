package zoologico.model;

import zoologico.exceptions.AmbienteException;

import java.util.ArrayList;
import java.util.List;

public class Ambiente {
    private static int counter = 0;
    private final int id;
    private String tipo;
    private final int capacidade;
    private final List<Animal> animais = new ArrayList<>();

    public Ambiente(String tipo, int capacidade) {
        this.id = ++counter;
        this.tipo = tipo;
        this.capacidade = capacidade;
    }

    public int getId() { return id; }
    public String getTipo() { return tipo; }
    public int getCapacidade() { return capacidade; }
    public List<Animal> getAnimais() { return new ArrayList<>(animais); }

    public void adicionarAnimal(Animal a) throws AmbienteException {
        if (animais.size() >= capacidade) {
            throw new AmbienteException("Ambiente cheio! Capacidade: " + capacidade);
        }
        animais.add(a);
    }

    public boolean removerAnimal(Animal a) {
        return animais.remove(a);
    }

    @Override
    public String toString() {
        return String.format("Ambiente[%d] %s (capacidade %d) - %d animais", id, tipo, capacidade, animais.size());
    }
}
