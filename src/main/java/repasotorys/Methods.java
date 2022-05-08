package repasotorys;

import java.util.List;

public interface Methods<T> {
    void create(T t);
    T read(Long id);
    void update(Long id,T t);
    void delete(Long id);
    List<T> readAll();
}
