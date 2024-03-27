package jp.files.SOLUCION_PARCIAL.SETs;

import jp.linkedlist.singly.LinkedList;
import jp.util.iterator.Iterator;

public class SETs {

    public static void interseccion(String pathA,String pathB){

        InSETsOut inter = new InSETsOut();

        LinkedList<String> interseccion = new LinkedList<>();

        LinkedList<String> A = inter.bringSet(pathA);
        LinkedList<String> B = inter.bringSet(pathB);

        System.out.println("A: "+A.toString());
        System.out.println("B: "+B.toString());
        
        Iterator<String> iteratorA = A.iterator();
        while (iteratorA.hasNext()){
            String comparator = iteratorA.next();
            if(B.contains(comparator)){
                interseccion.add(comparator);
            }
        }
        
        System.out.println(interseccion.toString());

        inter.writeSet("Conjuntos\\OutSet.txt", interseccion);
    }

    public static void diferencia(String pathA,String pathB){

        LinkedList<String> diferencia = new LinkedList<>();

        InSETsOut inter = new InSETsOut();
        LinkedList<String> A = inter.bringSet(pathA);
        LinkedList<String> B = inter.bringSet(pathB);

        diferencia.add(A);

        Iterator<String> iteratorB = B.iterator();
        while (iteratorB.hasNext()) {
            String elementB = iteratorB.next();
            diferencia.remove(elementB);
        }
        System.out.println(diferencia.toString());
        inter.writeSet("Conjuntos\\OutSet.txt", diferencia);
        
    }

    public static void main(String[] args) {
        LinkedList<String> A = new LinkedList<>();
        A.add("A");
        A.add("B");
        A.add("C");
        A.add("D");
        A.add("E");

        LinkedList<String> B = new LinkedList<>();
        B.add("A");
        B.add("A");
        B.add("A");
        B.add("A");
        B.add("E");

        interseccion("Conjuntos\\A.txt","Conjuntos\\B.txt");

        System.out.println("-----------------------------");

        diferencia("Conjuntos\\A.txt","Conjuntos\\B.txt");
    }
}
