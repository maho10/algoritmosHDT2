package controllers.stacks;

public interface Stack<E> {

    /**
     * Add an item to the stack. Will be popped next.
     * @param item
     */
    public void add(E item);

    /**
     * If the controllers.stacks.Stack is not empty, the most recent item will be removed and returned.
     * @return Item
     */
    public E remove();

    /**
     * Get the current Item on the controllers.stacks.Stack (without popping it).
     * @return Item
     */
    public E peek();

    /**
     * Check if the controllers.stacks.Stack is empty.
     * @return Boolean indicating if the controllers.stacks.Stack is empty
     */
    public boolean empty();

    /**
     * Get the size of the controllers.stacks.Stack.
     * @return Integer indicating the size of the controllers.stacks.Stack
     */
    public int size();
}