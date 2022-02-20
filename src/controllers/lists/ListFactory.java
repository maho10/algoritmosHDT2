package controllers.lists;

public class ListFactory<E> {

    public Lists<E> getList(String listType){
        if(listType.equalsIgnoreCase("SINGLY")) return new SinglyList<>();
        else if (listType.equalsIgnoreCase("DOUBLY")) return new DoublyList<>();
        else return null;
    }
}
