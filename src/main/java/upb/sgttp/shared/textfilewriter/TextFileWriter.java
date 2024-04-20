/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upb.sgttp.shared.textfilewriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author thewe
 */
public class TextFileWriter {
    private String rutaArchivo;

    public TextFileWriter(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public void agregarTexto(String texto) {
        try {
            // Crea un objeto FileWriter para escribir en el archivo
            FileWriter fileWriter = new FileWriter(rutaArchivo, true); // El segundo parámetro true indica que se agregarán datos al final del archivo

            // Crea un objeto BufferedWriter para mejorar la eficiencia de escritura
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Escribe el string en el archivo
            bufferedWriter.write(texto);
            bufferedWriter.newLine(); // Agrega una nueva línea después del string

            // Cierra el BufferedWriter
            bufferedWriter.close();
        } catch (IOException e) {
            // Maneja cualquier excepción de E/S (IOException) que pueda ocurrir
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
