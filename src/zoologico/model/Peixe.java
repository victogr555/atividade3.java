package zoologico.model;

public class Peixe extends Animal{
    public Peixe(String name, String species, int age) { super(name, species, age); }
    @Override public void makeSound() { System.out.println(name + " peixe faz som: blub"); }
}
