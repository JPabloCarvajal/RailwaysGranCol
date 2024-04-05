package jp.files.SOLUCION_PARCIAL.SETs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import jp.linkedlist.singly.LinkedList;
import jp.util.iterator.Iterator;

public class InSETsOut {

    public InSETsOut(){

    }

    public LinkedList<String> bringSet(String filePath) {
        LinkedList<String> set = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Iterar sobre cada carácter de la línea
                for (char c : line.toCharArray()) {
                    // Verificar si el carácter es una letra y agregarlo a la lista si lo es
                    if (Character.isLetter(c)) {
                        set.add(String.valueOf(c));
                    }
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        return set;
    }

    public void writeSet(String filePath, LinkedList<String> set) {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {

            Iterator<String> iterator = set.iterator();
            int last = set.size() - 1;
            int cnt = 0;

            writer.write("{");
            while (iterator.hasNext()) {

                if(cnt == last){
                    writer.write(iterator.next().toString());
                }else{
                    writer.write(iterator.next().toString() + ",");
                }
                cnt++;
            }

            writer.write("}");

        } 
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    
}
