package jp.files.practice.PromedioMedianaYModa;
import java.util.Scanner;
import java.util.function.ToIntFunction;

import jp.linkedlist.singly.LinkedList;
import jp.util.iterator.Iterator;

public class PromedioMedianaYModa {

    public PromedioMedianaYModa (){
    }

    LinkedList<Integer> numList = new LinkedList<>();

    public LinkedList<Integer> addNumToList(){
        int other=0;
        while(other == 0){
            System.out.println("add number: ");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            if(num!=0){
                numList.add(num);
            }
            System.out.println("want to add other num? 0/Y,n/N");
            other = scanner.nextInt();
        }
        System.out.println(numList.toString());
        return numList;
    }

    public float media(){
        int total = 0;
        Iterator<Integer> iterator = numList.iterator();
        while(iterator.hasNext()){
            total += iterator.next(); 
        }
        float average = total/numList.size();
        return average;
    }

    public int moda() {
        LinkedList<Integer> frequencies = new LinkedList<>();
        
        // Calcular frecuencias
        for (int i = 0; i < numList.size(); i++) {
            int num = numList.get(i);
            int index = frequencies.indexOf(num);
            if (index != -1) {
                // Incrementar la frecuencia si el número ya está en la lista de frecuencias
                int frequency = frequencies.get(index);
                frequencies.set(index, frequency + 1);
            } else {
                // Agregar el número a la lista de frecuencias si es la primera vez que se encuentra
                frequencies.add(1);
            }
        }
        
        // Encontrar el valor con la frecuencia más alta (la moda)
        int maxFrequency = 0;
        int moda = 0;
        for (int i = 0; i < frequencies.size(); i++) {
            int frequency = frequencies.get(i);
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                moda = numList.get(i); // El valor de la moda es el mismo que el número en la misma posición en numList
            }
        }
        
        return moda;
    }

    public int mediana(){
        LinkedList<Integer> copy = new LinkedList<>();
        copy.add(numList);

        //a(menor a mayor) -a(mayor a menor)
        ToIntFunction<Integer> comparator = (Integer a) -> a;
        copy.sort(comparator);
        System.out.println(copy.toString());

        int midIndex = numList.size() / 2;

        if (numList.size() % 2 != 0) {
            return copy.get(midIndex);
        } 
        else {
                // Si la cantidad de elementos es par, la mediana es el promedio de los dos valores centrales
                int midValue1 = copy.get(midIndex - 1);
                int midValue2 = copy.get(midIndex);
                return (midValue1 + midValue2) / 2;
            }
    }

    public int findHigherNum(){
        LinkedList<Integer> copy = new LinkedList<>();
        copy.add(numList);

        //a(menor a mayor) -a(mayor a menor)
        ToIntFunction<Integer> comparator = (Integer a) -> -a;
        copy.sort(comparator);
        return copy.get(0);
    }
    
    public int findLowerNum(){
        LinkedList<Integer> copy = new LinkedList<>();
        copy.add(numList);

        //a(menor a mayor) -a(mayor a menor)
        ToIntFunction<Integer> comparator = (Integer a) -> a;
        copy.sort(comparator);
        return copy.get(0);
    }


    public static void main(String[] args) {
        PromedioMedianaYModa lista = new PromedioMedianaYModa();

        lista.addNumToList();

        System.out.println(lista.media());

        System.out.println(lista.mediana());

        System.out.println(lista.moda());

        System.out.println(lista.findLowerNum());

        System.out.println(lista.findHigherNum());
    }
}
