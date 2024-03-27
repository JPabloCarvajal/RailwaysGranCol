package jp.files.SOLUCION_PARCIAL.BIN_HEX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import jp.linkedlist.doubly.LinkedList;
import jp.util.iterator.Iterator;

public class InBinHexOut {

    public InBinHexOut(){
    }

    public static String bringNumber(String filePath) {
        StringBuilder result = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Iterar sobre cada carácter de la línea y concatenarlo al resultado
                for (char c : line.toCharArray()) {
                    result.append(c);
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public static void writeNumber(String filePath, LinkedList<String> set) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            Iterator<String> iterator = set.iterator();
            int last = set.size() - 1;
            int cnt = 0;
    
            while (iterator.hasNext()) {
                writer.write(iterator.next().toString()); // Escribir el elemento actual en el archivo
                if (cnt != last) {
                }
                cnt++;
            }
            writer.newLine(); // Agregar una nueva línea al final
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String filePathfrom = "BinHex/in.bin";
        String contenido = bringNumber(filePathfrom);
        System.out.println("Contenido del archivo: " + contenido);

        // Crear un conjunto de prueba
        LinkedList<String> set = new LinkedList<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");

        // Especificar la ruta del archivo donde se escribirá el conjunto
        String filePathto = "BinHex/numero.hex"; // Reemplazar con la ruta adecuada

        // Llamar al método para escribir el conjunto en el archivo
        writeNumber(filePathto, set);
    }

}
