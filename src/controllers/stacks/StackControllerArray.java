package controllers.stacks;


import java.util.ArrayList;

public class StackControllerArray<E> extends StackMethods<E> implements Stack<E> {

    protected ArrayList<E> stack;


    @Override
    public void add(E item) {
        stack.add(item);
    }

    @Override
    public E remove() {
        return stack.remove(size()-1);
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

    public StackControllerArray() {
        stack = new ArrayList<E>();
    }
}
