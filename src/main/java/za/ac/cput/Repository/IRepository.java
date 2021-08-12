package za.ac.cput.Repository;

import java.util.List;

public interface IRepository<T, ID> {
    public T create(T t);

    public T read(ID id);
    public T update(T t);
    public boolean delete(ID id);

}
