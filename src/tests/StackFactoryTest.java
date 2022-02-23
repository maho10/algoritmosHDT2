package tests;

import controllers.stacks.StackControllerArray;
import controllers.stacks.StackControllerList;
import controllers.stacks.StackControllerVector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackFactoryTest {
    private final StackControllerArray<Double> sca = new StackControllerArray<>();
    private final StackControllerList<Double> scl = new StackControllerList<>(true);
    private final StackControllerVector<Double> scv = new StackControllerVector<>();
    @Test
    void add() {
        sca.add(5.0);
        sca.add(4.0);
        scl.add(6.0);
        scl.add(7.0);
        scv.add(3.0);
        scv.add(2.0);
    }

    @Test
    void remove() {
        sca.add(5.0);
        sca.add(4.0);
        assertEquals(4,sca.remove(),"Hay un error al remover el elemento del stack");
        scl.add(6.0);
        scl.add(7.0);
        assertEquals(7,scl.remove(),"Hay un error al remover el elemento del stack");
        scv.add(3.0);
        scv.add(2.0);
        assertEquals(2,scv.remove(),"Hay un error al remover el elemento del stack");
    }

    @Test
    void peek(){
        sca.add(5.0);
        sca.add(4.0);
        assertEquals(4,sca.peek(),"Hay un error al obtener el objeto del stack");
        scl.add(6.0);
        scl.add(7.0);
        assertEquals(7,scl.peek(),"Hay un error al obtener el objeto del stack");
        scv.add(3.0);
        scv.add(2.0);
        assertEquals(2,scv.peek(),"Hay un error al obtener el objeto del stack");
    }

    @Test
    void size(){
        sca.add(5.0);
        sca.add(4.0);
        assertEquals(2,sca.size(),"Hay un error al obtener el tamaño del objeto del stack");
        scl.add(7.0);
        assertEquals(1,scl.size(),"Hay un error al obtener el tamaño del objeto del stack");
        scv.add(3.0);
        scv.add(2.0);
        scv.add(1.0);
        assertEquals(3,scv.size(),"Hay un error al obtener el tamaño del objeto del stack");
    }

}
