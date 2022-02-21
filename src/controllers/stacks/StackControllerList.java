package controllers.stacks;

import controllers.lists.ListFactory;
import controllers.lists.Lists;


public class StackControllerList<E> extends StackMethods<E> implements Stack<E>{

    private ListFactory<E> list = new ListFactory<>();
    private Lists<E> stack;

    @Override
    public void add(E item) {
        stack.add(item);
    }

    @Override
    public E remove() {
        E last = stack.get();
        stack.remove();
        return last;
    }

    @Override
    public E peek()
    // pre: stack is not empty
    // post: top value (next to be popped) is returned
    {
        return stack.get();
    }

    @Override
    public int size()
    // post: returns the number of elements in the stack
    {
        return stack.size();
    }

    public StackControllerList(boolean type) {
        stack = list.getList(type);
    }
}
