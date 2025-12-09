package zoologico.app;

import zoologico.controller.AmbienteController;
import zoologico.controller.ZoologicoController;
import zoologico.dao.AmbienteDAO;
import zoologico.dao.ZoologicoDAO;
import zoologico.exceptions.AmbienteException;
import zoologico.exceptions.ZoologicoException;
import zoologico.model.*;

public class Main {
    public static void main(String[] args) {
        AmbienteDAO ambienteDAO = new AmbienteDAO();
        ZoologicoDAO zoologicoDAO = new ZoologicoDAO();
        AmbienteController ambienteController = new AmbienteController(ambienteDAO);
        ZoologicoController zoologicoController = new ZoologicoController(zoologicoDAO, ambienteDAO);

        try {
            Zoologico zoo = new Zoologico("Zoo Central", "Sousa - PB");
            zoologicoController.create(zoo);

            Ambiente savana = new Ambiente("Savanna", 3);
            Ambiente aquario = new Ambiente("Aquário", 5);

            zoologicoController.adicionarAmbienteAZoologico(zoo.getId(), savana);
            zoologicoController.adicionarAmbienteAZoologico(zoo.getId(), aquario);

            Mamifero leao = new Mamifero("Simba", "Leão", 5);
            Ave papagaio = new Ave("Loro", "Papagaio", 2);
            Peixe nemo = new Peixe("Nemo", "Peixe-palhaço", 1);

            ambienteController.addAnimalToAmbiente(savana.getId(), leao);
            ambienteController.addAnimalToAmbiente(savana.getId(), papagaio); 
            ambienteController.addAnimalToAmbiente(aquario.getId(), nemo);

            System.out.println("Zoológico criado: " + zoo);
            System.out.println("Ambientes do zoológico:");
            for (Ambiente a : zoo.getAmbientes()) {
                System.out.println("\t" + a);
                for (Animal animal : a.getAnimais()) {
                    System.out.println("\t\t" + animal);
                }
            }
            Mamifero m1 = new Mamifero("M1", "Bovino", 3);
            Mamifero m2 = new Mamifero("M2", "Bovino", 4);
            Mamifero m3 = new Mamifero("M3", "Bovino", 2);
            ambienteController.addAnimalToAmbiente(savana.getId(), m1);
            ambienteController.addAnimalToAmbiente(savana.getId(), m2);

        } catch (AmbienteException ae) {
            System.err.println("Erro de ambiente: " + ae.getMessage());
        } catch (ZoologicoException ze) {
            System.err.println("Erro de zoológico: " + ze.getMessage());
        } catch (Exception e) {
            System.err.println("Erro geral: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

