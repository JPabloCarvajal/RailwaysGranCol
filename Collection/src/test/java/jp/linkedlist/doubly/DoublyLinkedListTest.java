package jp.linkedlist.doubly;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Function;
import java.util.function.Predicate;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jp.util.iterator.Iterator;

class DoublyLinkedListTest {
    private LinkedList<Integer> intDoublyList;
    private LinkedList<String> stringDoublyList;
 
    @BeforeEach
    void setUp() {
        intDoublyList = new LinkedList<>();
        stringDoublyList = new LinkedList<>();
    }

    @Test
    void testAdd() {
        // Verifica que la lista esté vacía inicialmente
        assertTrue(intDoublyList.isEmpty());
        assertEquals(0, intDoublyList.size());

        // Agrega un elemento a la lista
        assertTrue(intDoublyList.add(1));

        // Verifica que la lista ya no esté vacía y tenga el tamaño esperado
        assertFalse(intDoublyList.isEmpty());
        assertEquals(1, intDoublyList.size());

         

        // Agrega más elementos a la lista
        assertTrue(intDoublyList.add(2));
        assertTrue(intDoublyList.add(3));

        // Verifica que la lista tenga el tamaño esperado después de agregar más elementos
        assertEquals(3, intDoublyList.size());

        // Verifica que los elementos estén en el orden esperado
        assertEquals(1, intDoublyList.peek());
        assertEquals(3, intDoublyList.peekLast());
    }
    @Test
    public void testAddArray() {
        String[] elements = {"apple", "orange", "banana"};
        assertTrue(stringDoublyList.add(elements));
        assertEquals(3, stringDoublyList.size());
        assertTrue(stringDoublyList.contains("apple"));
        assertTrue(stringDoublyList.contains("banana"));
    }

    @Test
    @DisplayName("Test Add Collection for CircularLinkedList")
    void testAddCollection() {
        LinkedList<Integer> intCircularList = new LinkedList<>();
        intCircularList.add(1);
        intCircularList.add(2);
        intCircularList.add(3);
        LinkedList<Integer> intCircularList2 = new LinkedList<>();
        intCircularList2.add(4);
        intCircularList2.add(5);
        intCircularList2.add(6);
        assertTrue(intCircularList.add(intCircularList2));
        assertEquals(6, intCircularList.size());
    }

    @Test
    void testAddFirst() {
        // Agrega al principio en lista vacía
        assertTrue(intDoublyList.addFirst(1));
        assertEquals(1, intDoublyList.size());
        assertEquals(1, intDoublyList.peek());
        assertEquals(1, intDoublyList.peekLast());

        // Agrega al principio en lista no vacía
        assertTrue(intDoublyList.addFirst(0));
        assertEquals(2, intDoublyList.size());
        assertEquals(0, intDoublyList.peek());
        assertEquals(1, intDoublyList.peekLast());

    }

    @Test
    public void testAddFirstWithArray() {
        String[] elements = { "One", "Two", "Three" };
        assertTrue(stringDoublyList.addFirst(elements));

        assertTrue(stringDoublyList.contains("One"));
        assertTrue(stringDoublyList.contains("Two"));
        assertTrue(stringDoublyList.contains("Three"));
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
        assertTrue(intDoublyList.addFirst(elementsToAdd));

        // Verificar que los elementos fueron añadidos correctamente al principio de la lista
        Iterator<Integer> iterator = intDoublyList.iterator();
        assertEquals(3, iterator.next()); // Primer elemento añadido
        assertEquals(2, iterator.next()); // Segundo elemento añadido
        assertEquals(1, iterator.next()); // Tercer elemento añadido
    }

    @Test
    @DisplayName("Prueba para el método peek()")
    public void testPeek() {
        assertNull(intDoublyList.peek());  // La lista está vacía, se espera null

        intDoublyList.add(5);
        assertEquals(5, intDoublyList.peek());  // La cabeza de la lista debería ser 5

        intDoublyList.add(10);
        assertEquals(5, intDoublyList.peek());  // La cabeza no debería cambiar
    }
    
    @Test
    @DisplayName("Prueba para el método peekLast()")
    public void testPeekLast() {
        assertNull(stringDoublyList.peekLast());  // La lista está vacía, se espera null

        stringDoublyList.add("First");
        assertEquals("First", stringDoublyList.peekLast());  // La cola de la lista debería ser "First"

        stringDoublyList.add("Second");
        assertEquals("Second", stringDoublyList.peekLast());  // La cola debería cambiar a "Second"
    }

    @Test
    @DisplayName("PEEK ARRAY: Retrieve the first n elements of the list.")
    void testPeekArray() {
        intDoublyList.add(1);
        intDoublyList.add(2);
        intDoublyList.add(3);
        intDoublyList.add(4);

        // Probamos peekArray con un tamaño mayor al de la lista
        Object[] result = intDoublyList.peekArray(10);
        assertEquals(4, result.length);
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, result);

        // Probamos peekArray con un tamaño igual al de la lista
        result = intDoublyList.peekArray(4);
        assertEquals(4, result.length);
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, result);

        // Probamos peekArray con un tamaño menor al de la lista
        result = intDoublyList.peekArray(2);
        assertEquals(2, result.length);
        assertArrayEquals(new Integer[]{1, 2}, result);

        // Probamos peekArray con un tamaño 0
        result = intDoublyList.peekArray(0);
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
        intDoublyList.add(1);
        intDoublyList.add(2);
        intDoublyList.add(3);
        intDoublyList.add(4);

        Object[] expectedArray = {2, 3, 4};
        Object[] resultArray = intDoublyList.peekLastArray(3);

        assertArrayEquals(expectedArray, resultArray);
    }
    
    @Test
    void testPoll() {
        intDoublyList.add(1);
        intDoublyList.add(2);
        intDoublyList.add(3);

        assertEquals(1, intDoublyList.poll());
        assertEquals(2, intDoublyList.poll());
        assertEquals(3, intDoublyList.poll());
        assertNull(intDoublyList.poll());
    }
    @Test
    public void testPollLastMethod() {
        // Test 1: Lista vacía
        LinkedList<String> list1 = new LinkedList<>();
        assertNull(list1.pollLast());

        // Test 2: Lista con un solo elemento
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("Element");
        assertEquals("Element", list2.pollLast());
        assertTrue(list2.isEmpty());

        // Test 3: Lista con varios elementos
        LinkedList<String> list3 = new LinkedList<>();
        list3.add("Element1");
        list3.add("Element2");
        list3.add("Element3");
        assertEquals("Element3", list3.pollLast());
        assertTrue(list3.size() == 2);

        // Test 4: Llamadas consecutivas con lista vacía
        LinkedList<String> list4 = new LinkedList<>();
        assertNull(list4.pollLast());

        // Test 5: Llamadas consecutivas con un solo elemento
        LinkedList<String> list5 = new LinkedList<>();
        list5.add("SoloElemento");
        assertEquals("SoloElemento", list5.pollLast());
        assertTrue(list5.isEmpty());

        // Test 6: Llamadas consecutivas con varios elementos
        LinkedList<String> list6 = new LinkedList<>();
        list6.add("Elem1");
        list6.add("Elem2");
        list6.add("Elem3");
        assertEquals("Elem3", list6.pollLast());
        assertEquals("Elem2", list6.pollLast());
        assertEquals("Elem1", list6.pollLast());
        assertNull(list6.pollLast());
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
      assertArrayEquals(new String[]{ "Three","Two"}, result3);

      // Probamos pollLastArray en una lista vacía
      LinkedList<Double> doubleList = new LinkedList<>();
      Object[] result5 = doubleList.pollLastArray(5);
      assertArrayEquals(new Double[]{}, result5);
    }
    @Test
    void testsRemove() {
            // Caso 1: Lista vacía
            assertFalse(intDoublyList.remove(5));

            // Caso 2: Eliminar elemento que no está en la lista
            intDoublyList.add(1);
            intDoublyList.add(2);
            intDoublyList.add(3);
            assertFalse(intDoublyList.remove(5));
            assertEquals(3, intDoublyList.size());
      
            // Caso 3: Eliminar elemento al principio
            assertTrue(intDoublyList.remove(1));
            assertEquals(2,intDoublyList.size());
      
            // Caso 4: Eliminar elemento en medio
            intDoublyList.add(4);
            assertTrue(intDoublyList.remove(2));
            assertEquals(2, intDoublyList.size());
      
            // Caso 5: Eliminar elemento al final
            assertTrue(intDoublyList.remove(4));
            assertEquals(1, intDoublyList.size());
    }

    @Test
    public void testRemoveFromArray() {
        // Agregar algunos elementos a la lista
        intDoublyList.add(1);
        intDoublyList.add(2);
        intDoublyList.add(3);
        intDoublyList.add(4);
        intDoublyList.add(5);

        // Crear un array con elementos a ser eliminados
        Integer[] elementsToRemove = {2, 4, 6}; // Intentamos eliminar 2 y 4

        // Ejecutar el método remove con el array
        boolean result = intDoublyList.remove(elementsToRemove);

        // Verificar que el método haya eliminado al menos un elemento
        assertTrue(result);

        // Verificar que los elementos 2 y 4 han sido eliminados
        assertFalse(intDoublyList.contains(2));
        assertTrue(intDoublyList.contains(1));
        assertFalse(intDoublyList.contains(4));
        assertTrue(intDoublyList.contains(5));
    }
    @Test
    public void testRemoveFromCollection() {
        // Agregar algunos elementos a la lista
        intDoublyList.add(1);
        intDoublyList.add(2);
        intDoublyList.add(3);
        intDoublyList.add(4);
        intDoublyList.add(5);

        // Crear una lista enlazada con elementos a ser eliminados
        LinkedList<Integer> elementsToRemove = new LinkedList<>();
        elementsToRemove.add(2);
        elementsToRemove.add(4);
        elementsToRemove.add(6);  // Intentamos eliminar 2 y 4

        // Ejecutar el método remove con la colección
        boolean result = intDoublyList.remove(elementsToRemove);

        // Verificar que el método haya eliminado al menos un elemento
        assertTrue(result);

        // Verificar que los elementos 2 y 4 han sido eliminados
        assertFalse(intDoublyList.contains(2));
        assertTrue(intDoublyList.contains(1));
        assertFalse(intDoublyList.contains(4));
        assertTrue(intDoublyList.contains(5));
    }

    @Test
    public void testRemoveWithPredicate() {
        // Agregar algunos elementos a la lista
        intDoublyList.add(1);
        intDoublyList.add(2);
        intDoublyList.add(3);
        intDoublyList.add(4);
        intDoublyList.add(5);

        // Definir un filtro para eliminar números pares
        Predicate<Integer> filter = num -> num % 2 == 0;

        // Ejecutar el método remove con el filtro
        boolean result = intDoublyList.remove(filter);

        // Verificar que el método haya eliminado al menos un elemento
        assertTrue(result);

        // Verificar que los números pares han sido eliminados
        assertFalse(intDoublyList.contains(2));
        assertFalse(intDoublyList.contains(4));

        // Verificar que los números impares permanecen en la lista
        assertTrue(intDoublyList.contains(1));
        
        assertTrue(intDoublyList.contains(3));
        assertTrue(intDoublyList.contains(5));
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
    void testReplaceArray() {
        // Crear una lista circular
        LinkedList<Integer> circularList = new LinkedList<>();
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);

        // Crear un array y un nuevo array para reemplazar
        Integer[] originalArray = {-1, -2, -3};
        Integer[] newArray = {4, 5, 6};

        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer nmr) {
                if(nmr == null){
                    return false;
                }

                return nmr < 0;
            }
        };

        // Reemplazar los elementos en la lista circular
        boolean result = circularList.replace(originalArray, newArray,predicate);

        // Verificar que el reemplazo fue exitoso
        assertTrue(result);

        // Verificar que los elementos fueron reemplazados correctamente
        assertTrue(circularList.contains(4)); // 1 no debería ser reemplazado
        assertTrue(circularList.contains(5)); // 2 debería ser reemplazado
        assertTrue(circularList.contains(6)); // 3 no debería ser reemplazado
        assertFalse(circularList.contains(4)); // 4 debería ser agregado
        assertFalse(circularList.contains(5)); // 5 no debería ser agregado
        assertFalse(circularList.contains(6)); // 6 debería ser agregado
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
    //@Test
    void testRetainCollection() {
        // Crear una lista circular
        LinkedList<Integer> circularList = new LinkedList<>();
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        circularList.add(4);
        circularList.add(5);

        // Crear una LinkedList con elementos para retener
        LinkedList<Integer> elementsToRetain = new LinkedList<>();
        elementsToRetain.add(2);
        elementsToRetain.add(4);
        elementsToRetain.add(6);

        // Retener solo los elementos presentes en la LinkedList
        boolean result = circularList.retain(elementsToRetain);

        // Verificar que la retención fue exitosa
        assertTrue(result);

        // Verificar que la lista circular contiene solo los elementos retenidos
        assertTrue(circularList.contains(2));
        assertTrue(circularList.contains(4));
        assertTrue(circularList.contains(1));
        assertFalse(circularList.contains(3));
        assertFalse(circularList.contains(5));
        assertFalse(circularList.contains(6));

        // Verificar que el tamaño de la lista circular se ajusta correctamente
        assertEquals(2, circularList.size());
    }
    @Test
    void testSet() {
        // Crear una lista circular
        LinkedList<Integer> circularList = new LinkedList<>();
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);

        // Reemplazar el elemento 2 con el valor 4
        boolean result = circularList.set(2, 4);

        // Verificar que el reemplazo fue exitoso
        assertTrue(result);

        // Verificar que los elementos fueron reemplazados correctamente
        assertTrue(circularList.contains(1)); // 1 no debería ser reemplazado
        assertFalse(circularList.contains(2)); // 2 debería ser reemplazado
        assertTrue(circularList.contains(3)); // 3 no debería ser reemplazado
        assertTrue(circularList.contains(4)); // 4 debería ser agregado

        // Intentar reemplazar un elemento que no está en la lista
        boolean nonExistentResult = circularList.set(5, 6);

        // Verificar que el reemplazo de un elemento inexistente sea falso
        assertFalse(nonExistentResult);
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
        assertTrue(intDoublyList.add(23));
        assertTrue(intDoublyList.add(30));
        assertTrue(intDoublyList.add(20));

        Integer[] expected = {23, 30, 20};
        assertArrayEquals(expected, intDoublyList.toArray());
    }

    @Test
    @DisplayName("CLEAR: Clear the list")
    void testClear() {
        // Add elements
        assertTrue(intDoublyList.add(23));
        assertTrue(intDoublyList.add(30));
        assertTrue(intDoublyList.add(20));

        // Verify the list is not empty
        assertFalse(intDoublyList.isEmpty());

        // Clear the list
        assertTrue(intDoublyList.clear());

        // Verify the list is empty after clearing
        assertTrue(intDoublyList.isEmpty());
        assertEquals(0, intDoublyList.size());
        assertNull(intDoublyList.head);
        assertNull(intDoublyList.tail);
        assertNull(intDoublyList.inode);
    }

    @Test
    void testContainsArray() {
        
        intDoublyList.add(1);
        intDoublyList.add(2);
        intDoublyList.add(3);

        // Caso 1: El array está contenido en la lista
        Integer[] array1 = {1, 2};
        assertTrue(intDoublyList.contains(array1));

        // Caso 2: El array está parcialmente contenido en la lista
        Integer[] array2 = {2, 4};
        assertFalse(intDoublyList.contains(array2));

        // Caso 3: El array está vacío
        Integer[] array3 = {};
        assertFalse(intDoublyList.contains(array3));
    }

    @Test
    void testContainsCollection() {

        intDoublyList.add(1);
        intDoublyList.add(2);
        intDoublyList.add(3);

        // Crear una colección con elementos que están en la lista
        LinkedList<Integer> collectionInList = new LinkedList<>();
        collectionInList.add(1);
        collectionInList.add(2);
        collectionInList.add(3);

        // Crear una colección con un elemento que no está en la lista
        LinkedList<Integer> collectionNotInList = new LinkedList<>();
        collectionNotInList.add(4);

        // Verificar que la lista contiene la colección con elementos que están en la lista
        assertTrue(intDoublyList.contains(collectionInList));

        // Verificar que la lista no contiene la colección con elementos que no están en la lista
        assertFalse(intDoublyList.contains(collectionNotInList));
    }
    @Test
    void testForEach() {
        intDoublyList.add(1);
        intDoublyList.add(2);
        intDoublyList.add(3);

        // Crear una Function para sumar los elementos
        Function<Integer, Void> sumFunction = element -> {
            // Realizar alguna acción con el elemento (en este caso, sumar)
            // Devolver null ya que Function no tiene un método void
            return null;
        };

        // Probar el forEach
        intDoublyList.forEach(sumFunction);

        // Verificar que la suma sea correcta (o la acción realizada)
        // Aquí puedes agregar aserciones según lo que hagas en la Function

        // Verificar excepción si la Function es null
        assertThrows(NullPointerException.class, () -> intDoublyList.forEach(null));
    }
    @Test
    void testReverse() {
        intDoublyList.add(1);
        intDoublyList.add(2);
        intDoublyList.add(3);

        // Verificar el estado inicial
        assertEquals(1, intDoublyList.peek());
        assertEquals(3, intDoublyList.size());

        // Aplicar la reversión
        boolean result = intDoublyList.reverse();

        // Verificar que la reversión fue exitosa
        assertTrue(result);

        // Verificar el nuevo estado después de la reversión
        assertEquals(3, intDoublyList.peek()); // Ahora, el último elemento se convierte en el primero
        assertEquals(3, intDoublyList.size());
    }

    @Test
    @DisplayName("Test Iterator for LinkedListCircular")
    void testIterator() {
        intDoublyList = new LinkedList<>();
        intDoublyList.add(1);
        intDoublyList.add(2);
        intDoublyList.add(3);

        StringBuilder result = new StringBuilder();
        Iterator<Integer> iterator = intDoublyList.iterator();
        while (iterator.hasNext()) {
        Integer element = iterator.next();
        result.append(element).append(" ");
        }

        // Verificar que el iterador recorre la lista circular correctamente
        assertEquals("1 2 3 ", result.toString());
    }

    

}
