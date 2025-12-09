package zoologico.dao;

import zoologico.exceptions.ZoologicoException;
import zoologico.interfaces.IDAO;
import zoologico.model.Zoologico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ZoologicoDAO implements IDAO<Zoologico> {

    private final List<Zoologico> storage = new ArrayList<>();

    @Override
    public Zoologico create(Zoologico z) throws ZoologicoException {
        if (z == null) throw new ZoologicoException("Zoológico nulo");
        storage.add(z);
        return z;
    }

    @Override
    public Zoologico read(int id) throws ZoologicoException {
        Optional<Zoologico> opt = storage.stream().filter(x -> x.getId() == id).findFirst();
        if (opt.isEmpty()) throw new ZoologicoException("Zoológico não encontrado: " + id);
        return opt.get();
    }

    @Override
    public Zoologico update(Zoologico z) throws ZoologicoException {
        if (z == null) throw new ZoologicoException("Zoológico nulo");
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getId() == z.getId()) {
                storage.set(i, z);
                return z;
            }
        }
        throw new ZoologicoException("Zoológico não encontrado: " + z.getId());
    }

    @Override
    public boolean delete(int id) throws ZoologicoException {
        return storage.removeIf(x -> x.getId() == id);
    }

    @Override
    public List<Zoologico> listAll() {
        return new ArrayList<>(storage);
    }
}
