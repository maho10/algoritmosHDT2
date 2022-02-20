package controllers.lists;

public interface Lists<E>  {

    public void add(E data);

    public E get(int position);

    public void remove(int position);

    public int size();

}
