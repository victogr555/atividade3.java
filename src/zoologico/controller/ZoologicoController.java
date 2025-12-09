package zoologico.controller;

import zoologico.dao.AmbienteDAO;
import zoologico.dao.ZoologicoDAO;
import zoologico.exceptions.ZoologicoException;
import zoologico.interfaces.IController;
import zoologico.model.Ambiente;
import zoologico.model.Zoologico;

import java.util.List;

public class ZoologicoController implements IController<Zoologico> {

    private final ZoologicoDAO dao;
    private final AmbienteDAO ambienteDAO;

    public ZoologicoController(ZoologicoDAO dao, AmbienteDAO ambienteDAO) {
        this.dao = dao;
        this.ambienteDAO = ambienteDAO;
    }

    @Override
    public Zoologico create(Zoologico z) throws ZoologicoException {
        return dao.create(z);
    }

    @Override
    public Zoologico getById(int id) throws ZoologicoException {
        return dao.read(id);
    }

    @Override
    public Zoologico update(Zoologico z) throws ZoologicoException {
        return dao.update(z);
    }

    @Override
    public boolean delete(int id) throws ZoologicoException {
        return dao.delete(id);
    }

    public void adicionarAmbienteAZoologico(int zoologicoId, Ambiente a) throws ZoologicoException {
        try {
            Zoologico z = dao.read(zoologicoId);
            ambienteDAO.create(a);
            z.adicionarAmbiente(a);
            dao.update(z);
        } catch (Exception e) {
            throw new ZoologicoException("Erro ao adicionar ambiente: " + e.getMessage(), e);
        }
    }

    public List<Zoologico> listarTodos() {
        return dao.listAll();
    }
}