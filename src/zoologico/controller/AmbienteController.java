package zoologico.controller;

import zoologico.dao.AmbienteDAO;
import zoologico.exceptions.AmbienteException;
import zoologico.interfaces.IController;
import zoologico.model.Ambiente;
import zoologico.model.Animal;

import java.util.List;

public class AmbienteController implements IController<Ambiente> {

    private final AmbienteDAO dao;

    public AmbienteController(AmbienteDAO dao) {
        this.dao = dao;
    }

    @Override
    public Ambiente create(Ambiente a) throws AmbienteException {
        if (a == null) throw new AmbienteException("Ambiente inválido");
        return dao.create(a);
    }

    @Override
    public Ambiente getById(int id) throws AmbienteException {
        return dao.read(id);
    }

    @Override
    public Ambiente update(Ambiente a) throws AmbienteException {
        return dao.update(a);
    }

    @Override
    public boolean delete(int id) throws AmbienteException {
        return dao.delete(id);
    }

    public List<Ambiente> listAll() {
        return dao.listAll();
    }

    public void addAnimalToAmbiente(int ambienteId, Animal animal) throws AmbienteException {
        Ambiente a = dao.read(ambienteId);
        a.adicionarAnimal(animal);
    }

    public void removeAnimalFromAmbiente(int ambienteId, Animal animal) throws AmbienteException {
        Ambiente a = dao.read(ambienteId);
        if (!a.removerAnimal(animal)) {
            throw new AmbienteException("Animal não encontrado no ambiente");
        }
    }
}
