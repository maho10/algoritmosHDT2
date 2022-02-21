package controllers.stacks;

public class StackFactory<E> {
    public Stack<E> getStack(int stackType){
        switch (stackType){
            case 1:
                return new StackControllerArray<>();
            case 2:
                return new StackControllerVector<>();
            case 3:
                return new StackControllerList<>(true);
            case 4:
                return new StackControllerList<>(false);
            default:
                return null;
        }
    }
}
