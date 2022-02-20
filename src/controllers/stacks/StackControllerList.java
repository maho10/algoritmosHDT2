package controllers.stacks;

import controllers.lists.ListFactory;
import controllers.lists.Lists;


public class StackControllerList<E> implements Stack<E>{

    String type = "Sinlgy";
    private ListFactory<E> list = new ListFactory<>();
    private Lists<E> stack = list.getList(type);

    @Override
    public void add(E item) {
        stack.add(item);
    }

    @Override
    public E remove() {
        E last = stack.get(size() - 1);
        stack.remove(size()-1);
        return last;
    }

    @Override
    public E peek()
    // pre: stack is not empty
    // post: top value (next to be popped) is returned
    {
        return stack.get(size() - 1);
    }

    @Override
    public int size()
    // post: returns the number of elements in the stack
    {
        return stack.size();
    }

    @Override
    public boolean empty()
    // post: returns true if and only if the stack is empty
    {
        return size() == 0;
    }

    public StackControllerList(String type) {
        Lists<E> stack = list.getList(type);
    }
}
