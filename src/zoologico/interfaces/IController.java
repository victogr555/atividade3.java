package zoologico.interfaces;

public interface IController <T>{
    T create(T t) throws Exception;
    T getById(int id) throws Exception;
    T update(T t) throws Exception;
    boolean delete(int id) throws Exception;
}
