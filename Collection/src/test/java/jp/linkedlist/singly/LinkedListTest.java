package jp.linkedlist.singly;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jp.util.iterator.Iterator;

class LinkedListTest {
  private LinkedList<Integer> integerLinkedList;
  private LinkedList<String> stringLinkedList;

    @BeforeEach
    public void setUp() {
        integerLinkedList = new LinkedList<>();
        stringLinkedList = new LinkedList<>();
    }

    @Test
    @DisplayName("ADD: Add an element to the list.")
    void testAdd() {
        assertTrue(integerLinkedList.add(23));
        assertTrue(integerLinkedList.add(30));
        assertTrue(integerLinkedList.add(20));
        assertEquals(3, integerLinkedList.size());

        Object[] expected = {23, 30, 20, null};
        int i = 0;
        for(Iterator<Integer> it = integerLinkedList.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }

    @Test
    public void testAddArray() {
        String[] elements = {"apple", "orange", "banana"};
        assertTrue(stringLinkedList.add(elements));
        assertEquals(3, stringLinkedList.size());
        assertTrue(stringLinkedList.contains("apple"));
        assertTrue(stringLinkedList.contains("banana"));
    }
    @Test
    void testAddCollection() {
        // Crear una lista con algunos elementos
        LinkedList<Integer> elementsToAdd = new LinkedList<>();
        elementsToAdd.add(1);
        elementsToAdd.add(2);
        elementsToAdd.add(3);

        // Añadir la colección a la lista
        assertTrue(integerLinkedList.add(elementsToAdd));

        // Verificar que los elementos fueron añadidos correctamente
        assertEquals(3, integerLinkedList.size());
        assertTrue(integerLinkedList.contains(1));
        assertTrue(integerLinkedList.contains(2));
        assertTrue(integerLinkedList.contains(3));
    }

    @Test
    @DisplayName("Prueba para el método addFirst(element)")
    public void testAddFirst() {
        assertTrue(integerLinkedList.addFirst(5));
        assertTrue(integerLinkedList.contains(5));  

        assertTrue(integerLinkedList.addFirst(10));
        assertTrue(integerLinkedList.contains(10));
        assertTrue(integerLinkedList.contains(5));   
    }

    @Test
    public void testAddFirstWithArray() {
        String[] elements = { "One", "Two", "Three" };
        assertTrue(stringLinkedList.addFirst(elements));

        assertTrue(stringLinkedList.contains("One"));
        assertTrue(stringLinkedList.contains("Two"));
        assertTrue(stringLinkedList.contains("Three"));
    }

    @Test
    @DisplayName("ADD FIRST: Add elements from a collection to the beginning of the list.")
    void testAddFirstCollection() {
        // Crear una lista con algunos elementos
        LinkedList<Integer> elementsToAdd = new LinkedList<>();
        elementsToAdd.add(1);
        elementsToAdd.add(2);
        elementsToAdd.add(3);

        // Añadir todos los elementos de la colección al principio de la lista
        assertTrue(integerLinkedList.addFirst(elementsToAdd));

        // Verificar que los elementos fueron añadidos correctamente al principio de la lista
        Iterator<Integer> iterator = integerLinkedList.iterator();
        assertEquals(3, iterator.next()); // Primer elemento añadido
        assertEquals(2, iterator.next()); // Segundo elemento añadido
        assertEquals(1, iterator.next()); // Tercer elemento añadido
    }
    @Test
    @DisplayName("Prueba para el método peek()")
    public void testPeek() {
        assertNull(integerLinkedList.peek());  // La lista está vacía, se espera null

        integerLinkedList.add(5);
        assertEquals(5, integerLinkedList.peek());  // La cabeza de la lista debería ser 5

        integerLinkedList.add(10);
        assertEquals(5, integerLinkedList.peek());  // La cabeza no debería cambiar
    }

    @Test
    @DisplayName("Prueba para el método peekLast()")
    public void testPeekLast() {
        assertNull(stringLinkedList.peekLast());  // La lista está vacía, se espera null

        stringLinkedList.add("First");
        assertEquals("First", stringLinkedList.peekLast());  // La cola de la lista debería ser "First"

        stringLinkedList.add("Second");
        assertEquals("Second", stringLinkedList.peekLast());  // La cola debería cambiar a "Second"
    }
    
    @Test
    @DisplayName("PEEK ARRAY: Retrieve the first n elements of the list.")
    //revisar metodo pq el test no da
    void testPeekArray() {
      LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // Probamos peekArray con un tamaño mayor al de la lista
        Object[] result = list.peekArray(10);// el error esta aqui 
        assertEquals(4, result.length);
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, result);

        // Probamos peekArray con un tamaño igual al de la lista
        result = list.peekArray(4);
        assertEquals(4, result.length);
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, result);

        // Probamos peekArray con un tamaño menor al de la lista
        result = list.peekArray(2);
        assertEquals(2, result.length);
        assertArrayEquals(new Integer[]{1, 2}, result);

        // Probamos peekArray con un tamaño 0
        result = list.peekArray(0);
        assertEquals(0, result.length);
        assertArrayEquals(new Integer[]{}, result);

        // Probamos peekArray en una lista vacía
        LinkedList<String> emptyList = new LinkedList<>();
        Object[] emptyResult = emptyList.peekArray(5);
        assertEquals(0, emptyResult.length);
    }

    @Test
    @DisplayName("PEEK LAST ARRAY: Retrieve the last n elements of the list.")
    void testPeekLastArray() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        Object[] expectedArray = {2, 3, 4};
        Object[] resultArray = linkedList.peekLastArray(3);

        assertArrayEquals(expectedArray, resultArray);
    }



    @Test
    void testPoll() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        assertEquals(1, linkedList.poll());
        assertEquals(2, linkedList.poll());
        assertEquals(3, linkedList.poll());
        assertNull(linkedList.poll());
    }
      @Test
      @DisplayName("POLL LAST: Retrieve and remove the last element of the list.")
      void testPollLast() {
      // Caso 1: Lista vacía, se espera null
      assertNull(integerLinkedList.pollLast());

      // Caso 2: Lista con un solo elemento
      integerLinkedList.add(5);
      assertEquals(5, integerLinkedList.pollLast());  // Se espera 5, y la lista debería quedar vacía

      // Caso 3: Lista con varios elementos
      integerLinkedList.add(10);
      integerLinkedList.add(15);
      integerLinkedList.add(20);
      assertEquals(20, integerLinkedList.pollLast());  // Se espera 20
      assertEquals(15, integerLinkedList.pollLast());  // Se espera 15
      assertEquals(10, integerLinkedList.pollLast());  // Se espera 10
      assertNull(integerLinkedList.pollLast());        // La lista está vacía, se espera null
      }

    @Test
    void testPollArray() {
        // Caso 1: Lista vacía
        LinkedList<Integer> emptyList = new LinkedList<>();
        Object[] resultEmpty = emptyList.pollArray(3);
        assertArrayEquals(new Integer[]{}, resultEmpty);

        // Caso 2: Lista con elementos
        LinkedList<String> stringList = new LinkedList<>();
        stringList.add("One");
        stringList.add("Two");
        stringList.add("Three");

        // Probamos pollArray con un tamaño igual al de la lista
        Object[] result2 = stringList.pollArray(3);
        assertArrayEquals(new String[]{"One", "Two", "Three"}, result2);

        // Probamos pollArray en una lista vacía
        LinkedList<Double> doubleList = new LinkedList<>();
        Object[] result5 = doubleList.pollArray(5);
        assertArrayEquals(new Double[]{}, result5);
    }

    @Test
    void testPollLastArray() {
      // Caso 1: Lista vacía
      LinkedList<Integer> emptyList = new LinkedList<>();
      Object[] resultEmpty = emptyList.pollLastArray(3);
      assertArrayEquals(new Integer[]{}, resultEmpty);

      // Caso 2: Lista con elementos
      LinkedList<String> stringList = new LinkedList<>();
      stringList.add("One");
      stringList.add("Two");
      stringList.add("Three");

      // Probamos pollLastArray con un tamaño menor al de la lista
      Object[] result3 = stringList.pollLastArray(2);
      assertArrayEquals(new String[]{"Two", "Three"}, result3);

      // Probamos pollLastArray en una lista vacía
      LinkedList<Double> doubleList = new LinkedList<>();
      Object[] result5 = doubleList.pollLastArray(5);
      assertArrayEquals(new Double[]{}, result5);
    }

    @Test
    void testPollCollection() {
      // Caso 1: Lista vacía
      LinkedList<Integer> emptyList = new LinkedList<>();
      LinkedList<Integer> resultEmpty = (LinkedList<Integer>) emptyList.pollCollection(3);
      assertTrue(resultEmpty.isEmpty());

      // Caso 2: Lista con elementos
      LinkedList<String> stringList = new LinkedList<>();
      stringList.add("One");
      stringList.add("Two");
      stringList.add("Three");

      // Probamos pollCollection con un tamaño mayor al de la lista
      LinkedList<String> result1 = (LinkedList<String>) stringList.pollCollection(10);
      assertEquals(3, result1.size());

      // Probamos pollCollection con un tamaño igual al de la lista
      LinkedList<String> result2 = (LinkedList<String>) stringList.pollCollection(3);
      assertEquals(3, result2.size());
      assertTrue(stringList.isEmpty()); // La lista original debería quedar vacía

      // Probamos pollCollection con un tamaño menor al de la lista
      LinkedList<String> result3 = (LinkedList<String>) stringList.pollCollection(2);
      assertEquals(2, result3.size());
      assertTrue(stringList.isEmpty()); // La lista original debería quedar vacía

      // Probamos pollCollection con un tamaño 0
      LinkedList<String> result4 = (LinkedList<String>) stringList.pollCollection(0);
      assertTrue(result4.isEmpty());
      assertTrue(stringList.isEmpty()); // La lista original debería quedar vacía

      // Probamos pollCollection en una lista vacía
      LinkedList<Double> doubleList = new LinkedList<>();
      LinkedList<Double> result5 = (LinkedList<Double>) doubleList.pollCollection(5);
      assertTrue(result5.isEmpty());
      assertTrue(doubleList.isEmpty()); // La lista original debería quedar vacía
    }
    
    @Test
    void testPollLastCollection() {
      // Caso 1: Lista vacía
      LinkedList<Integer> emptyList = new LinkedList<>();
      LinkedList<Integer> resultEmpty = (LinkedList<Integer>) emptyList.pollLastCollection(3);
      assertTrue(resultEmpty.isEmpty());

      // Caso 2: Lista con elementos
      LinkedList<String> stringList = new LinkedList<>();
      stringList.add("One");
      stringList.add("Two");
      stringList.add("Three");

      // Probamos pollLastCollection con un tamaño mayor al de la lista
      LinkedList<String> result1 = (LinkedList<String>) stringList.pollLastCollection(10);
      assertEquals(3, result1.size());
      assertTrue(stringList.isEmpty()); // La lista original debería quedar vacía

      // Probamos pollLastCollection con un tamaño igual al de la lista
      LinkedList<String> result2 = (LinkedList<String>) stringList.pollLastCollection(3);
      assertEquals(0, result2.size());
      assertTrue(stringList.isEmpty()); // La lista original debería quedar vacía

      // Probamos pollLastCollection con un tamaño menor al de la lista
      LinkedList<String> result3 = (LinkedList<String>) stringList.pollLastCollection(2);
      assertEquals(2, result3.size());
      assertTrue(stringList.isEmpty()); // La lista original debería quedar vacía

      // Probamos pollLastCollection con un tamaño 0
      LinkedList<String> result4 = (LinkedList<String>) stringList.pollLastCollection(0);
      assertTrue(result4.isEmpty());
      assertTrue(stringList.isEmpty()); // La lista original debería quedar vacía

      // Probamos pollLastCollection en una lista vacía
      LinkedList<Double> doubleList = new LinkedList<>();
      LinkedList<Double> result5 = (LinkedList<Double>) doubleList.pollLastCollection(5);
      assertTrue(result5.isEmpty());
      assertTrue(doubleList.isEmpty()); // La lista original debería quedar vacía
    }
    @Test
    void testRemove() {
      // Caso 1: Lista vacía
      assertFalse(integerLinkedList.remove(5));

      // Caso 2: Eliminar elemento que no está en la lista
      integerLinkedList.add(1);
      integerLinkedList.add(2);
      integerLinkedList.add(3);
      assertFalse(integerLinkedList.remove(5));
      assertEquals(3, integerLinkedList.size());

      // Caso 3: Eliminar elemento al principio
      assertTrue(integerLinkedList.remove(1));
      assertEquals(2, integerLinkedList.size());

      // Caso 4: Eliminar elemento en medio
      integerLinkedList.add(4);
      assertTrue(integerLinkedList.remove(2));
      assertEquals(2, integerLinkedList.size());

      // Caso 5: Eliminar elemento al final
      assertTrue(integerLinkedList.remove(4));
      assertEquals(1, integerLinkedList.size());
    }
    @Test
    void testRemoveArray() {
        // Caso 1: Lista vacía
        assertFalse(integerLinkedList.remove(new Integer[]{1, 2, 3}));

        // Caso 2: Eliminar array vacío
        assertFalse(integerLinkedList.remove(new Integer[]{}));
        assertTrue(integerLinkedList.isEmpty());

        // Caso 3: Eliminar elementos que no están en la lista
        integerLinkedList.add(1);
        integerLinkedList.add(2);
        assertFalse(integerLinkedList.remove(new Integer[]{3, 4, 5}));
        assertEquals(2, integerLinkedList.size());

        // Caso 4: Eliminar elementos que están en la lista
        assertTrue(integerLinkedList.remove(new Integer[]{1, 2}));
        assertTrue(integerLinkedList.isEmpty());
    }

    @Test
    void testRemoveWithFilter() {
      // Caso 1: Lista vacía, filtro siempre falso
      LinkedList<Integer> emptyList = new LinkedList<>();
      assertFalse(emptyList.remove(e -> e % 2 == 0)); // No hay elementos para remover

      // Caso 2: Lista con elementos, filtro que coincide con algunos elementos
      LinkedList<Integer> integerList = new LinkedList<>();
      integerList.add(1);
      integerList.add(2);
      integerList.add(3);
      integerList.add(4);
      assertTrue(integerList.remove(e -> e % 2 == 0)); // Se eliminan los números pares
      assertEquals(2, integerList.size()); // Deben quedar solo los números impares (1 y 3)
      assertTrue(integerList.contains(1));
      assertTrue(integerList.contains(3));
      assertFalse(integerList.contains(2));
      assertFalse(integerList.contains(4));

      // Caso 3: Lista con elementos, filtro que no coincide con ningún elemento
      LinkedList<String> stringList = new LinkedList<>();
      stringList.add("apple");
      stringList.add("banana");
      stringList.add("orange");
      assertFalse(stringList.remove(e -> e.contains("grape"))); // No hay "grape" para eliminar
      assertEquals(3, stringList.size()); // La lista no debe cambiar

      // Caso 4: Lista con elementos, filtro que coincide con todos los elementos
      LinkedList<String> fruitList = new LinkedList<>();
      fruitList.add("apple");
      fruitList.add("banana");
      fruitList.add("orange");
      assertTrue(fruitList.remove(e -> true)); // Se eliminan todos los elementos
      assertTrue(fruitList.isEmpty()); // La lista debe estar vacía después de la eliminación
    }

    @Test
    void testReplace() {
      // Caso 1: Lista vacía
      LinkedList<String> emptyList = new LinkedList<>();
      assertFalse(emptyList.replace("apple", "orange", e -> e.equals("apple"))); // No hay elementos para reemplazar
      assertTrue(emptyList.isEmpty()); // La lista debe seguir vacía

      // Caso 2: Lista con elementos, reemplazo exitoso
      LinkedList<String> stringList = new LinkedList<>();
      stringList.add("apple");
      stringList.add("banana");
      stringList.add("orange");
      assertTrue(stringList.replace("banana", "grape", e -> e.equals("banana"))); // Se reemplaza "banana" con "grape"
      assertEquals(3, stringList.size()); // La lista debe tener el mismo tamaño
      assertTrue(stringList.contains("apple"));
      assertTrue(stringList.contains("grape"));//lo agrega
      assertTrue(stringList.contains("orange"));//lo agrega
      assertFalse(stringList.contains("banana"));

      // Caso 3: Lista con elementos, reemplazo sin éxito (ningún elemento coincide con el comparador)
      LinkedList<Integer> integerList = new LinkedList<>();
      integerList.add(1);
      integerList.add(2);
      integerList.add(3);
      assertFalse(integerList.replace(2, 4, e -> e > 5)); // No hay elementos mayores a 5 para reemplazar
      assertEquals(3, integerList.size()); // La lista debe tener el mismo tamaño
      assertTrue(integerList.contains(1));
      assertTrue(integerList.contains(2));
      assertTrue(integerList.contains(3));
      assertFalse(integerList.contains(4));

      // Caso 4: Lista con elementos, reemplazo exitoso con múltiples coincidencias
      LinkedList<Integer> anotherIntegerList = new LinkedList<>();
      anotherIntegerList.add(1);
      anotherIntegerList.add(2);
      anotherIntegerList.add(2);
      anotherIntegerList.add(3);
      assertTrue(anotherIntegerList.replace(2, 4, e -> e == 2)); // Se reemplazan ambos 2 con 4
      assertEquals(4, anotherIntegerList.size()); // La lista debe tener un elemento más
      assertTrue(anotherIntegerList.contains(1));
      assertTrue(anotherIntegerList.contains(4));
      assertTrue(anotherIntegerList.contains(3));
      assertFalse(anotherIntegerList.contains(2));
    }
    
    @Test
    @DisplayName("REPLACE: Replace elements in the list")
    void testReplaceArray() {
        // Add elements
        assertTrue(integerLinkedList.add(10));
        assertTrue(integerLinkedList.add(20));
        assertTrue(integerLinkedList.add(30));

        // Define the arrays for replacement
        Integer[] array = {10, 30};
        Integer[] newArray = {15, 35};

        // Define the comparator
        Predicate<Integer> comparator = e -> e > 10;

        // Perform the replacement
        assertTrue(integerLinkedList.replace(array, newArray, comparator));

        // Verify that elements are replaced correctly
        assertEquals(3, integerLinkedList.size());
        assertTrue(integerLinkedList.contains(15));
        assertFalse(integerLinkedList.contains(10));
        assertTrue(integerLinkedList.contains(20));
        assertTrue(integerLinkedList.contains(35));
        assertFalse(integerLinkedList.contains(30));
    }
    @Test
    void testRetainArray() {
        // Crear una lista circular
        LinkedList<Integer> circularList = new LinkedList<>();
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        circularList.add(4);
        circularList.add(5);

        // Crear un array con elementos para retener
        Integer[] elementsToRetain = {2, 4, 6};

        // Retener solo los elementos presentes en el array
        boolean result = circularList.retain(elementsToRetain);

        // Verificar que la retención fue exitosa
        assertTrue(result);

        // Verificar que la lista circular contiene solo los elementos retenidos
        assertTrue(circularList.contains(2));
        assertTrue(circularList.contains(4));
        assertFalse(circularList.contains(1));
        assertFalse(circularList.contains(3));
        assertFalse(circularList.contains(5));
        assertFalse(circularList.contains(6));
        
        // Verificar que el tamaño de la lista circular se ajusta correctamente
        assertEquals(2, circularList.size());
    }

  @Test
    @DisplayName("RETAIN: Retain elements in the list based on a collection")
    void testRetainCollection() {
        integerLinkedList.add(1);
        integerLinkedList.add(2);
        integerLinkedList.add(3);
        integerLinkedList.add(4);
        integerLinkedList.add(5);

        // Create a collection to retain
        LinkedList<Integer> elementsToRetain = new LinkedList<>();
        elementsToRetain.add(2);
        elementsToRetain.add(4);

        // Perform the retain operation
        assertTrue(integerLinkedList.retain(elementsToRetain));

        // Verify that elements are retained correctly
        assertEquals(2, integerLinkedList.size());
        assertTrue(integerLinkedList.contains(2));
        assertFalse(integerLinkedList.contains(1));
        assertFalse(integerLinkedList.contains(3));
        assertFalse(integerLinkedList.contains(4));
        assertFalse(integerLinkedList.contains(5));
    }

    @Test
    @DisplayName("CONTAINS: Check if the list contains a specific element.")
    void testContains() {
        // Caso 1: Lista vacía
        assertFalse(integerLinkedList.contains(5));

        // Caso 2: Lista con elementos
        integerLinkedList.add(5);
        integerLinkedList.add(10);
        integerLinkedList.add(15);

        assertTrue(integerLinkedList.contains(5));
        assertTrue(integerLinkedList.contains(10));
        assertTrue(integerLinkedList.contains(15));
        assertFalse(integerLinkedList.contains(20));
        assertFalse(stringLinkedList.contains("Apple"));

        // Caso 3: Lista con elementos strings
        stringLinkedList.add("Banana");
        stringLinkedList.add("Orange");
        stringLinkedList.add("Grapes");

        assertTrue(stringLinkedList.contains("Banana"));
        assertTrue(stringLinkedList.contains("Orange"));
        assertTrue(stringLinkedList.contains("Grapes"));
        assertFalse(stringLinkedList.contains("Apple"));
    }

    @Test
    @DisplayName("CONTAINS ARRAY: Check if the list contains all elements from the array.")
    void testContainsArray() {
      // Caso 1: Lista vacía
      assertFalse(stringLinkedList.contains(new String[]{"Apple", "Banana", "Orange"}));

      // Caso 2: Lista con elementos
      stringLinkedList.add("Banana");
      stringLinkedList.add("Orange");
      stringLinkedList.add("Grapes");

      assertTrue(stringLinkedList.contains(new String[]{"Banana", "Orange"}));
      assertTrue(stringLinkedList.contains(new String[]{"Grapes"}));
      assertFalse(stringLinkedList.contains(new String[]{"Apple", "Banana"}));
    }

    @Test
    void testSet() {
      // Caso 1: Lista vacía
      LinkedList<Integer> emptyList = new LinkedList<>();
      assertFalse(emptyList.set(1, 10)); // No debería ser posible establecer un elemento en una lista vacía

      // Caso 2: Lista con elementos
      LinkedList<String> stringList = new LinkedList<>();
      stringList.add("apple");
      stringList.add("orange");
      stringList.add("banana");

      assertTrue(stringList.set("orange", "grapefruit")); // Debería ser posible cambiar "orange" a "grapefruit"
      assertFalse(stringList.set("nonexistent", "newElement")); // No debería ser posible cambiar un elemento que no existe

      // Verificar si los elementos se han establecido correctamente
      assertTrue(stringList.contains("grapefruit"));
      assertFalse(stringList.contains("orange"));
    }
    @Test
    void testSort() {
      // Caso 1: Lista vacía
      LinkedList<Integer> emptyList = new LinkedList<>();
      assertTrue(emptyList.sort(e -> e)); // Debería ser posible ordenar una lista vacía

      // Caso 2: Lista con elementos
      LinkedList<Integer> integerList = new LinkedList<>();
      integerList.add(5);
      integerList.add(3);
      integerList.add(7);

      assertTrue(integerList.sort(e -> e)); // Debería ser posible ordenar ascendente
      assertEquals(3, integerList.peek()); // El elemento más pequeño debería estar al principio

      assertTrue(integerList.sort(e -> -e)); // Debería ser posible ordenar descendente
      assertEquals(7, integerList.peek()); // El elemento más grande debería estar al principio

      // Caso 3: Lista con elementos duplicados
      LinkedList<Integer> duplicateList = new LinkedList<>();
      duplicateList.add(5);
      duplicateList.add(3);
      duplicateList.add(7);
      duplicateList.add(3);

      assertTrue(duplicateList.sort(e -> e)); // Debería ser posible ordenar ascendente con duplicados
      assertEquals(3, duplicateList.peek()); // El elemento más pequeño debería estar al principio

      assertTrue(duplicateList.sort(e -> -e)); // Debería ser posible ordenar descendente con duplicados
      assertEquals(7, duplicateList.peek()); // El elemento más grande debería estar al principio
    }
    
    @Test
    @DisplayName("SUBLIST: Get sublist of elements from the list")
    void testSubList() {
        // Create a linked list and add elements
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        integerLinkedList.add(1);
        integerLinkedList.add(2);
        integerLinkedList.add(3);
        integerLinkedList.add(4);
        integerLinkedList.add(5);

        // Define the range for subList
        Integer from = 2;
        Integer to = 4;

        // Get the sublist
        LinkedList<Integer> subList = (LinkedList<Integer>) integerLinkedList.subList(from, to);

        // Verify the elements in the sublist
        assertEquals(3, subList.size());
        assertTrue(subList.contains(2));
        assertTrue(subList.contains(3));
        assertTrue(subList.contains(4));
        assertFalse(subList.contains(1));
        assertFalse(subList.contains(5));
    }
    
    @Test
    @DisplayName("TOARRAY: Convert the list to an array.")
    void testToArray() {
        assertTrue(integerLinkedList.add(23));
        assertTrue(integerLinkedList.add(30));
        assertTrue(integerLinkedList.add(20));

        Integer[] expected = {23, 30, 20};
        assertArrayEquals(expected, integerLinkedList.toArray());
    }

    @Test
    @DisplayName("CLEAR: Clear the list")
    void testClear() {
        // Add elements
        assertTrue(integerLinkedList.add(23));
        assertTrue(integerLinkedList.add(30));
        assertTrue(integerLinkedList.add(20));

        // Verify the list is not empty
        assertFalse(integerLinkedList.isEmpty());

        // Clear the list
        assertTrue(integerLinkedList.clear());

        // Verify the list is empty after clearing
        assertTrue(integerLinkedList.isEmpty());
        assertEquals(0, integerLinkedList.size());
        assertNull(integerLinkedList.head);
        assertNull(integerLinkedList.tail);
        assertNull(integerLinkedList.inode);
    }

    @Test
    @DisplayName("REVERSE: Reverse the list")
    void testReverse() {
        // Add elements
        assertTrue(integerLinkedList.add(10));
        assertTrue(integerLinkedList.add(20));
        assertTrue(integerLinkedList.add(30));

        // Reverse the list
        assertTrue(integerLinkedList.reverse());

        // Verify the elements are in reverse order
        assertEquals(3, integerLinkedList.size());
        Integer[] expected = {30, 20, 10};
        int i = 0;
        for (Iterator<Integer> it = integerLinkedList.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }




    
}


    

    
    





