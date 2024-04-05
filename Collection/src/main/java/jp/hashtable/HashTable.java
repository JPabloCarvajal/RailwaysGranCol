package jp.hashtable;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;

public class HashTable<E> {

    private Array<LinkedList<E>> table;
    private int oddNumber;

    public HashTable(int dimension) {

        this.oddNumber = dimension;
        this.table = new Array<>(dimension);
        for (int i = 0; i < dimension; i++) {
            table.add(new LinkedList<>());
        }

        previusOddNumber();
    }

    public boolean put(String key, E element) {
        try {
            table.get(dispertionFunction(key)).add(element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public E get(String key) {
        try {
            return table.get(dispertionFunction(key)).peekLast();
        } catch (Exception e) {
            return null;
        }
    }

    private int keyToIndex(String key) {
        int sum = 0;
        for (int i = 2; i < key.length(); i++) {
            sum += key.charAt(i);
        }
        return sum;
    }

    private int dispertionFunction(String key) {
        int value = keyToIndex(key);
        int rKey = (int) Math.pow(value, 2) % oddNumber;
        return rKey;
    }

    private int dispersionUniversal(String key) {
        int hash = 0;
        int prime = 31; // Un número primo para mejorar la distribución
    
        for (int i = 0; i < key.length(); i++) {
            hash = prime * hash + key.charAt(i);
        }
    
        // Ajusta el valor de hash para que esté dentro del rango de la tabla
        hash = Math.abs(hash) % oddNumber;
    
        return hash;
    }

    
    private void previusOddNumber() {
        if (oddNumber % 2 == 0) {
            oddNumber--;
        }
        while (!isOdd(oddNumber)) {
            oddNumber -= 2;
        }
    }

    private boolean isOdd(int number) {
        return number % 2 != 0;
    }

}
