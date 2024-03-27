package jp.files.SOLUCION_PARCIAL.POLY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import jp.linkedlist.singly.LinkedList;
import jp.util.iterator.Iterator;

public class InPolyOut {

    public InPolyOut(){
    }

    public LinkedList<Float> bringPolyNums(String filePath){

        LinkedList<Float> polyNumbers = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            
            line = line.substring(1, line.length() - 1);
            
            String[] splitedLine = line.split(",");

            for(int i=0; i <splitedLine.length; i++){
                polyNumbers.add(Float.parseFloat(splitedLine[i]));
            }

        } 
        catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        
        return polyNumbers;
    }

    public void writePolyNums(String filePath, LinkedList<Float> polyNums) {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {

            Iterator<Float> iterator = polyNums.iterator();
            int last = polyNums.size() - 1;
            int cnt = 0;

            writer.write("<");
            while (iterator.hasNext()) {

                if(cnt == last){
                    writer.write(iterator.next().toString());
                }else{
                    writer.write(iterator.next().toString() + ", ");
                }
                cnt++;
            }

            writer.write(">");

        } 
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
