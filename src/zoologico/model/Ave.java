package zoologico.model;

public class Ave extends Animal {
    public Ave(String name, String species, int age) { super(name, species, age); }
    @Override public void makeSound() { System.out.println(name + " ave faz som: pii pii"); }
}
