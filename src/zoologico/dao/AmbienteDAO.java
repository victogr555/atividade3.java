package zoologico.dao;

import zoologico.exceptions.AmbienteException;
import zoologico.interfaces.IDAO;
import zoologico.model.Ambiente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AmbienteDAO implements IDAO<Ambiente> {

    private final List<Ambiente> storage = new ArrayList<>();

    @Override
    public Ambiente create(Ambiente a) throws AmbienteException {
        if (a == null) throw new AmbienteException("Ambiente nulo");
        storage.add(a);
        return a;
    }

    @Override
    public Ambiente read(int id) throws AmbienteException {
        Optional<Ambiente> opt = storage.stream().filter(x -> x.getId() == id).findFirst();
        if (opt.isEmpty()) throw new AmbienteException("Ambiente não encontrado: " + id);
        return opt.get();
    }

    @Override
    public Ambiente update(Ambiente a) throws AmbienteException {
        if (a == null) throw new AmbienteException("Ambiente nulo");
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getId() == a.getId()) {
                storage.set(i, a);
                return a;
            }
        }
        throw new AmbienteException("Ambiente não encontrado: " + a.getId());
    }

    @Override
    public boolean delete(int id) throws AmbienteException {
        return storage.removeIf(x -> x.getId() == id);
    }

    @Override
    public List<Ambiente> listAll() {
        return new ArrayList<>(storage);
    }
}
