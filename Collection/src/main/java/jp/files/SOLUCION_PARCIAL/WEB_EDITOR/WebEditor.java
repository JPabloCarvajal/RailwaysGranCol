package jp.files.SOLUCION_PARCIAL.WEB_EDITOR;

import jp.linkedlist.singly.LinkedList;
import jp.util.iterator.Iterator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// pedir a carlitos explicacion 
public class WebEditor {


    public static LinkedList<LinkedList<String>> ObtenerElementos(String txt){

        LinkedList<LinkedList<String>> resultados = new LinkedList<>();
        LinkedList<String> apertura = new LinkedList<>();
        LinkedList<String> cierre = new LinkedList<>();
        String tag = "";


        for (int i = 0; i < txt.length(); i++) {
            //revisar el cerrado </>
            if (txt.charAt(i) == '<' && txt.charAt(i + 1) == '/') {
                tag = "";
                while (txt.charAt(i) != '>') {
                    tag += txt.charAt(i);
                    i++;
                }
                tag += txt.charAt(i);
                cierre.add(tag);
            }

            //revisa el inicio <>
            else if (txt.charAt(i) == '<') {
                tag = "";
                while (txt.charAt(i) != '>') {
                    tag += txt.charAt(i);
                    i++;
                }
                tag += txt.charAt(i);
                apertura.add(tag);
            }
        }
        resultados.add(apertura);
        resultados.add(cierre);
        return resultados;
    }

    public static String verificarCierre(LinkedList<LinkedList<String>> elementos){

        LinkedList<String> apertura = elementos.get(0);
        LinkedList<String> cierre = elementos.get(1);
        String resultado = "";
    
        Iterator<String> aperturaIterator = apertura.iterator();
        while (aperturaIterator.hasNext()){

            String a = aperturaIterator.next();
            boolean encontrado = false;
            Iterator<String> cierreIterator = cierre.iterator();

            while (cierreIterator.hasNext()){

                String b = cierreIterator.next();

                if (a.substring(1, a.length() - 1).equals(b.substring(2, b.length() - 1))){
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado){
                resultado += "Error:"+ a + "no tiene apertura\n";
            }
        }
        return resultado;
    }

    public static String verificarApertura(LinkedList<LinkedList<String>> elementos){

        LinkedList<String> apertura = elementos.get(0);
        LinkedList<String> cierre = elementos.get(1);
        String resultado = "";

        Iterator<String> cierreIterator = cierre.iterator();
        while (cierreIterator.hasNext()){

            String a = cierreIterator.next();
            boolean encontrado = false;
            Iterator<String> aperturaIterator = apertura.iterator();

            while (aperturaIterator.hasNext()){
                String b = aperturaIterator.next();
                //quitar los caracteres < y > para comparar y si ninguno de los elementos de cierre es igual a los de apertura
                if (a.substring(2, a.length() - 1).equals(b.substring(1, b.length() - 1))){
                    encontrado = true;
                    break;
                }

            }
            if (!encontrado){
                resultado += "Error:"+ a + "no tiene apertura\n";
            }
        }
        return resultado;
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

    public static void main(String[] args) {
        String texto = readHTML("web.html");
        LinkedList<LinkedList<String>> elementos = ObtenerElementos(texto);
        String Cierre = verificarCierre(elementos);
        String Apertura = verificarApertura(elementos);
        if (Cierre.equals("") && Apertura.equals("")){

            System.out.println("OK.");
            
        }
        else{
            System.out.println(Cierre);
            System.out.println(Apertura);
        }

    }
}
