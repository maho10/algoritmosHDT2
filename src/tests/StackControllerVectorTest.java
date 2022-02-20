package tests;

import controllers.stacks.StackControllerVector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackControllerVectorTest {
    private final StackControllerVector<Double> sc = new StackControllerVector<>();
    //double sc;
    @Test
    void add() {
        sc.add(5.0);
        sc.add(4.0);
    }

    @Test
    void remove() {
        sc.add(5.0);
        sc.add(4.0);
        assertEquals(4,sc.remove(),"Hay un error al remover el elemento del stack");
    }

    @Test
    void peek(){
        sc.add(5.0);
        sc.add(4.0);
        assertEquals(4,sc.peek(),"Hay un error al obtener el objeto del stack");
    }

    @Test
    void size(){
        sc.add(5.0);
        sc.add(4.0);
        assertEquals(2,sc.size(),"Hay un error al obtener el tamaño del objeto del stack");
    }

    @Test
    void empty(){

    }
}
