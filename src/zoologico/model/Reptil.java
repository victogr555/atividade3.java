package zoologico.model;

public class Reptil extends Animal {
    public Reptil(String name, String species, int age) { super(name, species, age); }
    @Override public void makeSound() { System.out.println(name + " réptil faz som: ..."); }
}
