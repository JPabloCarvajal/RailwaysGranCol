package jp.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jp.stack.array.StackArray;


public class StackArrayTest {

    private StackArray<Integer> stack;

    @BeforeEach
    void setUp() {
        // Inicializa el stack antes de cada test
        stack = new StackArray<>(5);
    }

    @Test
    void clearTest(){
        // Agrega algunos elementos al stack
        assertTrue(stack.push(1));
        assertTrue(stack.push(2));
        assertTrue(stack.push(3));
        assertTrue(stack.push(4));
        assertTrue(stack.push(5));

        // Asegúrate de que el stack no esté vacío antes de clear
        assertFalse(stack.isEmpty());
        assertEquals(5, stack.peek());

        // Llama al método clear
        stack.clear();

        // Asegúrate de que el stack esté vacío después de clear
        assertTrue(stack.isEmpty());
        assertEquals(-1, stack.getTop());
    }

    @Test
    void containsTest() {
        // Caso 1: La pila está vacía
        assertFalse(stack.contains(1));

        // Caso 2: La pila contiene el elemento
        stack.push(1);
        stack.push(2);
        assertTrue(stack.contains(1));

        // Caso 3: La pila no contiene el elemento
        assertFalse(stack.contains(3));

        // Caso 4: La pila contiene el elemento después de invertirla
        stack.reverse();
        assertTrue(stack.contains(1));
    }

    @Test
    void testContainsWithArray() {
        // Crear un array con algunos elementos
        Integer[] elements = {1, 2, 3, 4, 5};
        StackArray<Integer> stackArray = new StackArray<>(5);

        // Agregar elementos al stack
        for (Integer element : elements) {
            stackArray.push(element);
        }

        // Crear otro array con algunos elementos que están en el stack
        Integer[] subset = {2, 4};

        // Verificar que el stack contiene el subconjunto
        assertTrue(stackArray.contains(subset));

        // Crear otro array con elementos que no están en el stack
        Integer[] nonSubset = {7, 9};

        // Verificar que el stack no contiene este subconjunto
        assertFalse(stackArray.contains(nonSubset));
    }

    @Test
    void peekOnStack() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Verificar que el peek() devuelve el elemento superior
        assertEquals(3, stack.peek());

        // Realizar pop para simular retirar elementos y dejar la pila vacía
        stack.pop();
        stack.pop();
        stack.pop();

        // Verificar que el peek() devuelve null en una pila vacía
        assertNull(stack.peek());
    }

    @Test
    void popOnStack() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Verificar que el pop() devuelve el elemento superior
        assertEquals(3, stack.pop());

        // Verificar que el top se actualiza después del pop
        assertEquals(1, stack.getTop());

        // Realizar pop hasta vaciar la pila
        stack.pop();
        stack.pop();

        // Verificar que el pop() devuelve null en una pila vacía
        assertNull(stack.pop());

        // Verificar que el top sigue siendo -1 en una pila vacía
        assertEquals(-1, stack.getTop());
    }
}

