package za.ac.cput.Repository;

import java.util.List;

public interface IRepository<T, ID> {
    public T create();

    public T read();
    public T update();
    public T delete();

}
