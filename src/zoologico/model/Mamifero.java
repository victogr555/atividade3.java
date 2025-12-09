package zoologico.model;

public class Mamifero extends Animal {
    public Mamifero(String name, String species, int age) { super(name, species, age); }
    @Override public void makeSound() { System.out.println(name + " mamífero faz som: grrr"); }
}