package controllers.lists;

public class ListFactory<E> {

    public Lists<E> getList(boolean listType){
        if(listType) return new SinglyList<>();
        else return new DoublyList<>();
    }
}
