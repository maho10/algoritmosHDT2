package controllers.lists;

public interface Lists<E>  {

    public void add(E data);

    public E get();

    public void remove();

    public int size();

}
