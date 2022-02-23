package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import controllers.lists.DoublyList;
import controllers.lists.SinglyList;
import org.junit.jupiter.api.Test;

public class ListFactoryTest {
    private final SinglyList<Double> sl = new SinglyList<>();
    private final DoublyList<Double> dl = new DoublyList<>();

    @Test
    void add(){
        sl.add(1.0);
        dl.add(3.0);
    }

    @Test
    void get(){
        sl.add(1.0);
        sl.add(2.0);
        assertEquals(2,sl.get(),"Hay un error");
        dl.add(3.0);
        dl.add(4.0);
        assertEquals(4,dl.get(),"Hay un error");
    }

    @Test
    void remove(){
        sl.add(1.0);
        sl.add(2.0);
        assertEquals(2,sl.size(),"Hay un error al obtener el tamaño ");
        sl.remove();
        assertEquals(1,sl.size(),"Hay un error al obtener el tamaño ");
        dl.add(1.0);
        dl.add(2.0);
        dl.add(2.0);
        assertEquals(3,dl.size(),"Hay un error al obtener el tamaño ");
        dl.remove();
        assertEquals(2,dl.size(),"Hay un error al obtener el tamaño ");
    }

    @Test
    void size(){
        sl.add(1.0);
        sl.add(2.0);
        sl.add(5.0);
        assertEquals(3,sl.size(),"Hay un error al obtener el tamaño ");
        dl.add(3.0);
        dl.add(4.0);
        assertEquals(2,dl.size(),"Hay un error al obtener el tamaño ");
    }
}
