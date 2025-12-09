package zoologico.model;

import zoologico.interfaces.IAnimal;

public abstract class Animal implements IAnimal {
    private static int counter = 0;
    protected final int id;
    protected String name;
    protected String species;
    protected int age;

    public Animal(String name, String species, int age) {
        this.id = ++counter;
        this.name = name;
        this.species = species;
        this.age = age;
    }

    @Override public int getId() { return id; }
    @Override public String getName() { return name; }
    @Override public String getSpecies() { return species; }
    @Override public int getAge() { return age; }

    @Override
    public void feed() {
        System.out.println(name + " foi alimentado.");
    }

    @Override
    public abstract void makeSound();

    @Override
    public String toString() {
        return String.format("[%d] %s (%s) - %d anos", id, name, species, age);
    }
}
