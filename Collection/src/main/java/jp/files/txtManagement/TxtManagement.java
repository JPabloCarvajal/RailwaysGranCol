package jp.files.txtManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import jp.linkedlist.doubly.LinkedList;
import jp.util.iterator.Iterator;

public class TxtManagement {

    public TxtManagement(){
    }

    public static String readHTML(String ruta){
        StringBuilder texto = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String linea = br.readLine();
            while (linea != null) {
                texto.append(linea);
                texto.append("\n");
                linea = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
        return texto.toString();
    }

    public static void writeStringLine(String filePath, String string ){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))){
            writer.write(string);
            writer.newLine();
        } 
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void writeIntLine(String filePath, int num){

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {

            writer.write(Integer.toString(num));
            writer.newLine();
        } 
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void writeFloatLine(String filePath, float num){

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {

            writer.write(Float.toString(num));
            writer.newLine();
        } 
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static LinkedList<String> bringTxtToWordList(String filePath) {
        LinkedList<String> wordList = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Dividir la línea en palabras y agregarlas a la lista
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordList.add(word);
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return wordList;
    }

    public static void writeAllStringListInTxt(String filePath, LinkedList<String> linesList){

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))){
            Iterator<String> iterator = linesList.iterator();

            while (iterator.hasNext()) {
                writer.write(iterator.next());
                writer.newLine();
            }
        } 
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static LinkedList<Integer> BringTxtToIntList(String filePath){
        LinkedList<Integer> numbers = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null){
                int number = Integer.parseInt(line.trim());
                numbers.add(number);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return numbers;
    }

    public static void clearTxt(String filePath){
        String emptyString = "";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            writer.write(emptyString);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "D:/Collection_7/example.txt";
        clearTxt(filePath);
        LinkedList<String> linesList = bringTxtToWordList(filePath);
        System.out.println("Lines before modification: " + linesList.toString());

        linesList.add("New line 1");
        linesList.add("New line 2");
        writeAllStringListInTxt(filePath, linesList);

        System.out.println(linesList.toString());
        linesList.clear();
        
    }
}
