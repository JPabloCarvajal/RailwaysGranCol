package jp.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jp.queue.list.QueueList;
public class QueueListTest {

    QueueList<Integer> queue;

    @BeforeEach
    void setUp(){
        queue = new QueueList<>();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
    }

    @Test
    void testClear() {
        // Verificar que la cola no esté vacía antes de clear
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.peek());

        // Llamar al método clear
        assertTrue(queue.clear());

        // Verificar que la cola esté vacía después de clear
        assertTrue(queue.isEmpty());
        assertEquals(null, queue.peek());
    }

    @Test
    void testContains() {
        // Verificar que la cola contiene algunos elementos
        assertTrue(queue.contains(1));
        assertTrue(queue.contains(2));
        assertTrue(queue.contains(3));

        // Verificar que la cola no contiene un elemento que no está presente
        assertFalse(queue.contains(4));
    }

    @Test
    void testReverse() {
        // Insertar elementos en la cola
        assertTrue(queue.insert(4));
        assertTrue(queue.insert(5));
        assertTrue(queue.insert(6));
        assertTrue(queue.insert(7));
        assertTrue(queue.insert(8));
        assertTrue(queue.insert(9));
        assertTrue(queue.insert(10));
        // Invertir la cola
        assertTrue(queue.reverse());

        // Verificar que la cola esté en orden invertido
        assertEquals(10, queue.extract());
        assertEquals(9, queue.extract());
        assertEquals(8, queue.extract());
        assertEquals(7, queue.extract());
        assertEquals(6, queue.extract());
        assertEquals(5, queue.extract());
        assertEquals(4, queue.extract());
        assertEquals(3, queue.extract());
        assertEquals(2, queue.extract());
        assertEquals(1, queue.extract());
    }                        

    @Test
    void testSize(){
        assertEquals(3, queue.size());
    }

    @Test
    void testPeek() {
        assertEquals(1, queue.peek());
        
        assertEquals(3, queue.size());
    }

    @Test
    void testExtract() {
        // Caso normal
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.extract());
        assertEquals(2, queue.extract());
        assertEquals(3, queue.extract());
        assertTrue(queue.isEmpty());

        // Intentar extraer de una cola vacía
        assertNull(queue.extract());

        // Insertar nuevos elementos y probar la extracción nuevamente
        queue.insert(4);
        queue.insert(5);
        assertEquals(4, queue.extract());
        assertEquals(5, queue.extract());
        assertTrue(queue.isEmpty());
        assertNull(queue.extract());
    }

    @Test
    void testInsert() {
        // Caso normal
        assertTrue(queue.insert(4));
        assertEquals(1, queue.peek());
        assertEquals(4, queue.size());

        // Insertar varios elementos
        assertTrue(queue.insert(5));
        assertTrue(queue.insert(6));
        assertEquals(1, queue.peek());
        assertEquals(6, queue.size());

        // Insertar elementos y luego extraer algunos
        assertTrue(queue.insert(7));
        assertTrue(queue.insert(8));
        assertEquals(1, queue.extract());
        assertEquals(7, queue.size());

        // Intentar insertar elementos después de extraer
        assertTrue(queue.insert(9));
        assertEquals(2, queue.extract());
        assertEquals(3, queue.extract());
        assertEquals(4, queue.peek());
        assertEquals(6, queue.size());
    }


}
