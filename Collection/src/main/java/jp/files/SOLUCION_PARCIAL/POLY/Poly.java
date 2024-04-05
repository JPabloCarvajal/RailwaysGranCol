package jp.files.SOLUCION_PARCIAL.POLY;

import jp.linkedlist.singly.LinkedList;
import jp.util.iterator.Iterator;

public class Poly {

    public static void integrarPolinomio(String path){

        InPolyOut reInPolyOut = new InPolyOut();

        LinkedList<Float> p = reInPolyOut.bringPolyNums(path);
        
        Iterator<Float> iterator = p.iterator();

        LinkedList<Float> integratedP = new LinkedList<>();
        int cnt = 0;
        while (iterator.hasNext()) {
            if(cnt==0){
                integratedP.add(0f);
                System.out.println("pipi");
            }
            else{
            integratedP.add(iterator.next()/cnt);
            }
            cnt++;
        }
        System.out.println(integratedP.toString());

        reInPolyOut.writePolyNums("result.poly",integratedP);

    }

    public static void sumarPolinomios(String path,String path2){

        InPolyOut reInPolyOut = new InPolyOut();

        LinkedList<Float> p1 = reInPolyOut.bringPolyNums(path);
        LinkedList<Float> p2 = reInPolyOut.bringPolyNums(path2);

        Iterator<Float> iterator = p1.iterator();
        Iterator<Float> iterator2 = p2.iterator();

        LinkedList<Float> sum = new LinkedList<>();

        while (iterator.hasNext() && iterator2.hasNext()) {
            sum.add(iterator.next() + iterator2.next());
        }
        while (iterator.hasNext()) {
            sum.add(iterator.next());
        }
        while(iterator2.hasNext()){
            sum.add(iterator2.next());
        }

        reInPolyOut.writePolyNums("result.poly",sum);

    }

    private static float evaluar(LinkedList<Float> p, double valor){
        int sum = 0;
        int cnt = 0;
        Iterator<Float> iterator = p.iterator();

        while(iterator.hasNext()){
            sum += iterator.next()*Math.pow(valor, cnt);
            cnt++;
        }
        return sum;
    }


    public static LinkedList<Float> evaluarPolinomiosPorRangoExcluyente( String path,float a, float b){
        
        InPolyOut reInPolyOut = new InPolyOut();

        LinkedList<Float> p = reInPolyOut.bringPolyNums(path);
        
        a += 1;
        if (a > b) {
            System.out.println("No es un intervalo válido");
            return null;
        }

        LinkedList<Float> evaluateList = new LinkedList<>();

        while (a < b) {
            evaluateList.add(evaluar(p, a));
            a++;
        }
        
        reInPolyOut.writePolyNums("result.poly",evaluateList);

        return evaluateList;
    }

    public static void main(String[] args) {

        System.out.println("_____________________INTEGRAR_______________________");
        /*2x^3+2x^1+2
        LinkedList<Float> polinomio = new LinkedList<>();
        polinomio.add(2f);
        polinomio.add(2f);
        polinomio.add(0f);
        polinomio.add(2f);
        integrarPolinomio()
        */
        String path = "inPoly.txt";
        integrarPolinomio(path);



        System.out.println("_____________________SUMA_______________________");
        System.out.println("Polimonio 1: ");
        //2x^4 -2x^2 + 3
        LinkedList<Float> polinomiosuma = new LinkedList<>();
        polinomiosuma.add(3f);
        polinomiosuma.add(0f);
        polinomiosuma.add(-2f);
        polinomiosuma.add(0f);
        polinomiosuma.add(2f);
        System.out.println(polinomiosuma.toString());

        System.out.println("Polimonio 2: ");
        LinkedList<Float> polinomiosuma2 = new LinkedList<>();
        polinomiosuma2.add(2f);
        polinomiosuma2.add(0f);
        polinomiosuma2.add(2f);
        polinomiosuma2.add(-1f);
        polinomiosuma2.add(1f);
        System.out.println(polinomiosuma.toString());

        System.out.println("suma polimonio");
        //System.out.println(sumarPolinomios(polinomiosuma, polinomiosuma2).toString());

        System.out.println("__________________EVALUAR_________________");

        //System.out.println(evaluarPolinomiosPorRangoExcluyente(polinomiosuma,2,5).toString());
    }
}

