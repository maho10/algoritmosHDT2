package controllers.stacks;

public abstract class StackMethods<E> implements Stack<E>{
    public boolean empty()
    {
        return size() == 0;
    }

}
