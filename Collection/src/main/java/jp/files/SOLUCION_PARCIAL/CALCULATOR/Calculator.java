package jp.files.SOLUCION_PARCIAL.CALCULATOR;

import jp.linkedlist.doubly.LinkedList;
import jp.util.iterator.Iterator;

import java.util.Scanner;



public class Calculator {
    
    public static LinkedList<Integer> stringToListDigits(String num) {
        LinkedList<Integer> digits = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            digits.add(num.charAt(i)-'0');
        }
        return digits;
    }

    public static void subtract(String numA, String numB) {
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<Integer> digitsA = stringToListDigits(numA);
        LinkedList<Integer> digitsB = stringToListDigits(numB);

        while (digitsA.size() < digitsB.size()) {
            digitsA.addFirst(0);
        }
        while (digitsB.size() < digitsA.size()) {
            digitsB.addFirst(0);
        }

        if(BisHigher(digitsA,digitsB)){
            subtractLower(numB,numA);
        }
        else{
        int borrow = 0;
        for (int i = digitsA.size() - 1; i >= 0; i--) {
            int digitA = digitsA.pollLast();
            int digitB = digitsB.pollLast();

            int difference = digitA - digitB - borrow;
            if (difference < 0) {
                difference += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.addFirst(difference);
        }
            System.out.println(result.toString());
    }
}

    public static boolean BisHigher(LinkedList<Integer> digitsA, LinkedList<Integer> digitsB){
        Iterator<Integer> iteratorA = digitsA.iterator();
        Iterator<Integer> iteratorB = digitsB.iterator();
    
        while(iteratorA.hasNext() && iteratorB.hasNext()){
            int digitA = iteratorA.next();
            int digitB = iteratorB.next();

            if(digitA < digitB){
                return true;
            }
        }
        return false;
    }


    public static void subtractLower(String numA, String numB) {

        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<Integer> digitsA = stringToListDigits(numA);
        LinkedList<Integer> digitsB = stringToListDigits(numB);

        while (digitsA.size() < digitsB.size()) {
            digitsA.addFirst(0);
        }
        while (digitsB.size() < digitsA.size()) {
            digitsB.addFirst(0);
        }

        int borrow = 0;
        for (int i = digitsA.size() - 1; i >= 0; i--) {
            int digitA = digitsA.pollLast();
            int digitB = digitsB.pollLast();
            

            int difference = digitA - digitB - borrow;
            if (difference < 0) {
                difference += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.addFirst(difference*-1);
        }

            System.out.println(result.toString());

    }

    public static void divide(String dividend, String divisor) {
        LinkedList<Integer> digitsDividend = stringToListDigits(dividend);
        LinkedList<Integer> digitsDivisor = stringToListDigits(divisor);
            
        if (digitsDivisor.isEmpty() || digitsDivisor.peek() == 0) {
            System.out.println("Error: división por cero.");
            return;
        }
            
        int quotient = 0;
        LinkedList<Integer> dividendTo = new LinkedList<>();
        dividendTo = digitsDividend;
        LinkedList<Integer> temp;

        for(int i =0; isHigherOrEqual(dividendTo, digitsDivisor); i++){
            temp = subtractDivision(dividendTo, digitsDivisor);
            quotient++;
            dividendTo.clear();
            dividendTo.add(temp);
            System.out.println(dividendTo.toString());
        }

        System.out.println("El cociente es: " + quotient);

    }
    
    public static LinkedList<Integer> subtractDivision(LinkedList<Integer> numA, LinkedList<Integer> numB) {
        LinkedList<Integer> result = new LinkedList<>();

        while (numA.size() < numB.size()) {
            numA.addFirst(0);
        }
        while (numB.size() < numA.size()) {
            numB.addFirst(0);
        }

        int borrow = 0;
        for (int i = numA.size() - 1; i >= 0; i--) {
            int digitA = numA.pollLast();
            int digitB = numB.pollLast();

            int difference = digitA - digitB - borrow;
            if (difference < 0) {
                difference += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.addFirst(difference);
        }
        return result;
    }

    public static boolean isHigherOrEqual(LinkedList<Integer> digitsA, LinkedList<Integer> digitsB) {
        if (digitsA.size() > digitsB.size()) {
            return true;
        } else if (digitsA.size() < digitsB.size()) {
            return false;
        } else {
            Iterator<Integer> iteratorA = digitsA.iterator();
            Iterator<Integer> iteratorB = digitsB.iterator();
            while (iteratorA.hasNext() && iteratorB.hasNext()) {
                int digitA = iteratorA.next();
                int digitB = iteratorB.next();
                if (digitA > digitB) {
                    return true;
                } else if (digitA < digitB) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        System.out.println("Dividendo: ");
        String dividend = scanner.nextLine().trim();

        System.out.println("Divisor: ");
        String divisor = scanner.nextLine().trim();

        divide(dividend,divisor);

        //222
        LinkedList<Integer> a = new LinkedList<>();
        a.add(2);
        a.add(2);
        a.add(2);
        //223
        LinkedList<Integer> b = new LinkedList<>();
        a.add(2);
        a.add(2);
        a.add(3);

        if(BisHigher(a, b)){
            System.out.println("OKOKKO");
        }
    }
}
