package jp.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jp.array.Array;
import jp.stack.list.StackList;


public class StackListTest {

    private StackList<Integer> stack;

    @BeforeEach
    void setUp() {
        // Inicializa el stack antes de cada test
        stack = new StackList<>();
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
        Array<Integer> elements;
        elements = new Array<>(new Integer[]{1, 2, 3, 4, 5});
    

        // Agregar elementos al stack
        for (int i = 0;i<elements.lenght(); i++ ) {
            stack.push(elements.get(i));
        }

        // Crear otro array con algunos elementos que están en el stack
        Integer[] subset = {2, 4};
        //o
        //Array<Integer> subbset;
        //subbset = new Array<>(subset);

        // Verificar que el stack contiene el subconjunto
        assertTrue(stack.contains(subset));

        // Crear otro array con elementos que no están en el stack
        Integer[] nonSubset = {7, 9};

        // Verificar que el stack no contiene este subconjunto
        assertFalse(stack.contains(nonSubset));
    }

    @Test
    void peekOnStack() {
        // Crear una pila no vacía
        StackList<Integer> stack = new StackList<>();
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
    void testPop() {
        // Agregar algunos elementos al stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Verificar que el tamaño sea correcto
        assertEquals(3, stack.size());

        // Hacer pop y verificar que se devuelve y elimina el elemento correcto
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());

        // Verificar que el tamaño se actualizó correctamente después de los pops
        assertEquals(0, stack.size());
        
        // Hacer otro pop y verificar el último elemento
        assertEquals(null, stack.pop());

        // Verificar que el stack está vacío después de los pops
        assertTrue(stack.isEmpty());
    }
}

