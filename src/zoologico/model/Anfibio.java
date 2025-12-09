package zoologico.model;

public class Anfibio extends Animal{
    public Anfibio(String name, String species, int age) { super(name, species, age); }
    @Override public void makeSound() { System.out.println(name + " anfíbio faz som: croak"); }
}
