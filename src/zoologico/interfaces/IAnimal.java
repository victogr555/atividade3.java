package zoologico.interfaces;

public interface IAnimal {
    int getId();
    String getName();
    String getSpecies();
    int getAge();
    void feed();
    void makeSound();
}
