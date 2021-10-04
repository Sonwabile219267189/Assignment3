package za.ac.cput.Service;

public interface IService <T, ID>{

    public T create();

    public T read();
    public T update();
    public T delete();
}
