package jp.files.SOLUCION_PARCIAL.BIN_HEX;

import jp.linkedlist.doubly.LinkedList;
import jp.util.iterator.Iterator;

public class BinHex {

    public static LinkedList<String> stringToListDigits(String num) {

        LinkedList<String> digits = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            digits.add(String.valueOf(num.charAt(i)));
        }
        return digits;
        
    }

    public static void binarioAHexadecimalArchivo(String pathfile) {
    
        InBinHexOut bringer = new InBinHexOut();
        String numeroBinario = bringer.bringNumber(pathfile);

        //se agregan ceros a la izquierda para que la longitud sea múltiplo de 4
        while (numeroBinario.length() % 4 != 0) {
            numeroBinario = "0" + numeroBinario;
        }

        LinkedList<String> hexadecimalList = new LinkedList<>();

        LinkedList<String> digitosBinarios = stringToListDigits(numeroBinario);

        // Iterar sobre cada grupo de 4 dígitos binarios
        Iterator<String> iterator = digitosBinarios.iterator();
        StringBuilder grupoBinario = new StringBuilder();
        while (iterator.hasNext()) {
            grupoBinario.append(iterator.next());
            // Cuando el grupo binario tenga 4 dígitos, convertirlo a hexadecimal y agregarlo a la lista
            if (grupoBinario.length() == 4) {
                int decimal = Integer.parseInt(grupoBinario.toString(), 2);
                hexadecimalList.add(Integer.toHexString(decimal).toUpperCase());
                grupoBinario.setLength(0); // Reiniciar el grupo binario para el próximo conjunto de 4 dígitos
            }
        }
        bringer.writeNumber("BinHex/numero.hex", hexadecimalList);
    }


    public static void hexadecimalABinarioArchivo(String pathfile) {
        InBinHexOut bringer = new InBinHexOut();
        
        String numeroHexadecimal = bringer.bringNumber(pathfile);

        LinkedList<String> digitosHexadecimales = stringToListDigits(numeroHexadecimal);

        LinkedList<String> digitosBinarios = new LinkedList<>();

        Iterator<String> iterator = digitosHexadecimales.iterator();
        while (iterator.hasNext()) {
            // Convertir el dígito hexadecimal a binario y agregar los dígitos a la lista
            String hex = iterator.next();
            String binario = Integer.toBinaryString(Integer.parseInt(hex, 16));
            // Añadir ceros a la izquierda si es necesario
            while (binario.length() < 4) {
                binario = "0" + binario;
            }
            // Agregar los dígitos binarios a la lista
            for (char c : binario.toCharArray()) {
                digitosBinarios.add(String.valueOf(c));
            }
        }

        // Escribir los dígitos binarios en el archivo
        bringer.writeNumber("BinHex/numero.bin", digitosBinarios);
    }

    public static void main(String[] args) {
        String numeroBinario = "101011010101100000000000000000000001111111111111111111100000000000000011111111111100000011101011110";
        String numeroHexadecimal = "1123AFFFFFFFFFFA3";
        
        binarioAHexadecimalArchivo("BinHex/in.bin");
        System.out.println("Pasado de binario a hexadecimal exitoso");
        System.out.println("______________________________________________");

        hexadecimalABinarioArchivo("BinHex/in.hex");
        System.out.println("Pasado de hexadecimal a binario exitoso");
    }

}
