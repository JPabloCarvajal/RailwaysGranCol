package jp.array;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Predicate;
import org.junit.jupiter.api.Test;

public class ArrayTest {
    
    @Test
    public void testAdd() {
        // Crear una instancia de tu clase Array
        Array<String> array = new Array<>(new String[10]);
        // Agregar un elemento
        assertTrue(array.add("Elemento1"));
        // Verificar que el tamaño sea 1 después de agregar un elemento
        assertEquals(1, array.size());
        // Verificar que el primer elemento sea "Elemento1"
        assertEquals("Elemento1", array.get(0));
    }

    @Test
    public void testAddArray() {
        // Crear un array de prueba
        Integer[] initialArray = {1, 2, 3, 4, 5};

        // Crear una instancia de la clase Array
        Array<Integer> array = new Array<>(initialArray);

        // Elementos a agregar
        Integer[] elementsToAdd = {10, 11, 12};

        // Índice en el que se agregarán los elementos
        int indexToAdd = 2;

        // Llamar al método add
        boolean result = array.add(indexToAdd, elementsToAdd);

        // Verificar el resultado del test
        assertTrue(result);
    }
    
    @Test
    public void testAddWithIndex() {
        Array<Integer> array = new Array<>(new Integer[5]);
        Integer[] elementsToAdd = { 1, 2, 3 };
        assertTrue(array.add(2, elementsToAdd));
        assertEquals(3, array.size());
        assertEquals(1, (int) array.get(2));
        assertEquals(2, (int) array.get(3));
        assertEquals(3, (int) array.get(4));
    }
    

    @Test
    public void testDefragment() {
        // Crear una instancia de tu clase Array
        Array<String> array = new Array<>(new String[5]);

        // Agregar elementos en posiciones específicas
        array.add("A");
        array.add("B");
        array.add("C");
        array.add("D");

        // Eliminar elementos en posiciones específicas
        array.remove(1);
        array.remove(2);

        // Realizar defragmentación
        array.defragment();

        // Verificar que la defragmentación haya ocurrido correctamente
        assertEquals("A", array.get(0));
        assertEquals("D", array.get(1));
        assertEquals(null, array.get(2));
        assertNull(array.get(3));
        assertNull(array.get(4));
    }
    @Test
    public void testGetMethod() {
        // Crear un array de prueba
        String[] testArray = {"apple", "banana", "cherry", "date"};
        // Crear una instancia de la clase Array
        Array<String> array = new Array<>(testArray);

        // Llamar al método get
        String result = array.get(2);

        // Verificar el resultado del test
        assertEquals("cherry", result);
    }

    @Test
    public void testIndexOfMethod() {
        // Crear un array de prueba
        Integer[] testArray = {10, 20, 30, 40, 50};

        // Crear una instancia de la clase Array
        Array<Integer> array = new Array<>(testArray);

        // Elemento que queremos buscar

        // Llamar al método indexOf
        int result = array.indexOf(30);

        // Verificar el resultado del test
        assertEquals(2, result);
    }
    @Test
    public void testLastIndexOfMethod() {
        // Crear un array de prueba
        Integer[] testArray = {10, 20, 30, 40, 30};

        // Crear una instancia de la clase Array
        Array<Integer> array = new Array<>(testArray);

        // Elemento que queremos buscar

        // Llamar al método lastIndexOf
        int result = array.lastIndexOf(30);

        // Verificar el resultado del test
        assertEquals(4, result);
    }
    @Test
    public void testRemoveAtIndex() {
        // Crear un array con elementos
        Integer[] elements = {1, 2, 3, 4, 5};
        Array<Integer> array = new Array<>(elements);

        // Remover elemento en el índice 2
        assertTrue(array.remove(2));

        // Verificar que el elemento en el índice 2 ahora es null
        assertNull(array.get(2));

        // Intentar remover un índice fuera del rango
        assertFalse(array.remove(10));
    }
    @Test
    public void testRemoveWithPredicate() {
        // Crea una instancia de Array con algunos elementos
        String[] elements = {"apple", "orange", "banana", "grape"};
        Array<String> array = new Array<>(elements);

        // Define un filtro para eliminar el elemento que contiene la letra 'a'
        Predicate<String> filter = s -> s != null && s.contains("a");

        // Llama al método remove con el filtro
        boolean result = array.remove(filter);

        // Verifica que el elemento "banana" fue eliminado
        assertTrue(result);
        assertNull(array.get(2)); // Comprueba que el tercer elemento es nulo después de la eliminación
    }

    @Test
    public void testRemoveRange() {
        // Crea una instancia de Array con algunos elementos
        String[] elements = {"apple", "orange", "banana", "grape"};
        Array<String> array = new Array<>(elements);

        // Llama al método remove con un rango
        boolean result = array.remove(1, 3);

        // Verifica que los elementos en el rango fueron eliminados
        assertTrue(result);
        assertNull(array.get(1)); // Comprueba que el segundo elemento es nulo después de la eliminación
        assertNull(array.get(2)); // Comprueba que el tercer elemento es nulo después de la eliminación
        assertNotNull(array.get(0)); // Comprueba que el primer elemento no fue eliminado
        assertNotNull(array.get(3)); // Comprueba que el cuarto elemento no fue eliminado
    }
    @Test
    public void testDimension() {
        // Crea una instancia de Array con algunos elementos
        String[] elements = {"apple", "orange", "banana", "grape"};
        Array<String> array = new Array<>(elements);

        // Llama al método dimension con una nueva dimensión
        boolean result = array.dimension(8);

        // Verifica que la dimensión fue ajustada correctamente
        assertTrue(result);
        assertNotNull(array.get(0));  // Comprueba que el primer elemento sigue siendo "apple"
        assertNotNull(array.get(3));  // Comprueba que el cuarto elemento sigue siendo "grape"
        assertNull(array.get(4));      // Comprueba que los elementos agregados son nulos
        assertNull(array.get(7));
    }
    @Test
    public void testSetValidIndex() {
        // Crea una instancia de Array con algunos elementos
        String[] elements = {"apple", "orange", "banana", "grape"};
        Array<String> array = new Array<>(elements);

        // Llama al método set para modificar un elemento existente en un índice válido
        boolean result = array.set(2, "kiwi");

        // Verifica que la modificación fue exitosa
        assertTrue(result);
        assertEquals("kiwi", array.get(2)); // Comprueba que el elemento en el índice 2 es ahora "kiwi"
    }
    @Test
    public void testClear() {
        // Crea una instancia de Array con algunos elementos
        String[] elements = {"apple", "orange", "banana", "grape"};
        Array<String> array = new Array<>(elements);

        // Llama al método clear para limpiar el array
        boolean result = array.clear();

        // Verifica que la limpieza fue exitosa
        assertTrue(result);
        // Comprueba que todos los elementos son nulos después de la limpieza
        assertNull(array.get(0));
        assertNull(array.get(1));
        assertNull(array.get(2));
        assertNull(array.get(3));
    }

    @Test
    public void testContainsElement() {
        // Crea una instancia de Array con algunos elementos
        String[] elements = {"apple", "orange", "banana", "grape"};
        Array<String> array = new Array<>(elements);

        // Llama al método contains con un elemento que existe en el array
        boolean result = array.contains("orange");

        // Verifica que el elemento está presente en el array
        assertTrue(result);
    }

    @Test
    public void testContainsElementArray() {
        // Crea una instancia de Array con algunos elementos
        String[] elements = {"apple", "orange", "banana", "grape"};
        Array<String> array = new Array<>(elements);

        // Llama al método contains con un array de elementos que existen en el array
        boolean result = array.contains(new String[]{"orange", "banana"});

        // Verifica que todos los elementos del array están presentes en el array principal
        assertTrue(result);
    }
    @Test
    public void testIsEmptyWhenNotEmpty() {
        // Crea una instancia de Array con algunos elementos
        String[] elements = {"apple", "orange", "banana", "grape"};
        Array<String> array = new Array<>(elements);

        // Verifica que el array no está vacío
        assertFalse(array.isEmpty());
    }

    @Test
    public void testIsEmptyWhenEmpty() {
        // Crea una instancia de Array vacío
        Array<String> array = new Array<>(new String[0]);

        // Verifica que el array está vacío
        assertTrue(array.isEmpty());
    }

    @Test
    public void testReverse() {
        // Crea una instancia de Array con algunos elementos
        String[] elements = {"apple", "orange", "banana", "grape"};
        Array<String> array = new Array<>(elements);

        // Llama al método reverse para invertir el array
        boolean result = array.reverse();

        // Verifica que la inversión fue exitosa
        assertTrue(result);
        // Comprueba que el primer elemento ahora es "grape" y el último es "apple"
        assertEquals("grape", array.get(0));
        assertEquals("banana", array.get(1));
        assertEquals("orange", array.get(2));
        assertEquals("apple", array.get(3));
    }

    @Test
    public void testReverseEmptyArray() {
        // Crea una instancia de Array vacío
        Array<String> array = new Array<>(new String[0]);

        // Llama al método reverse en un array vacío
        boolean result = array.reverse();

        // Verifica que la inversión fue exitosa (en un array vacío)
        assertTrue(result);
        // Verifica que el array vacío sigue siendo vacío
        assertTrue(array.isEmpty());
    }

    

}




