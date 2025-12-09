package zoologico.interfaces;

import java.util.List;

public interface IDAO <T> {T create(T t) throws Exception;
    T read(int id) throws Exception;
    T update(T t) throws Exception;
    boolean delete(int id) throws Exception;
    List<T> listAll();
}
