package upb.sgttp.shared.filejsonadapter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;

@SuppressWarnings("unused")
public class FileJsonAdapter<E> implements FileJsonInterface<E> ,Serializable{

    private static FileJsonAdapter<?> instance;
//    private Object fileWriterLock;
    private final Object fileWriterLock = new Object();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private FileJsonAdapter() {}
//    private FileJsonAdapter() {
//        this.fileWriterLock = new Object();
//    }
    
//    @SuppressWarnings("unchecked")
//    public static synchronized <E> FileJsonAdapter<E> getInstance() {
//        if (instance == null) {
//            instance = new FileJsonAdapter<>();
//        }
//        return (FileJsonAdapter<E>) instance;
//    }

    @Override
//    public E getObject(String pathFile, Class<E> classOfT) {
//        E object = null;
//        try {
//            // Leer el JSON utilizando ObjectMapper de Jackson
//            ObjectMapper objectMapper = new ObjectMapper();
//            object = objectMapper.readValue(new File(pathFile), classOfT);
//        } catch (IOException e) {
//            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
//        }
//        return object;
//    }
    public E getObject(String pathFile, Class<E> classOfT) {
        E object = null;
        try {
            Gson gson = new GsonBuilder().create();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
            object = gson.fromJson(bufferedReader, classOfT);
        } catch (FileNotFoundException | RuntimeException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return object;
    }

    public E[] getObjects(String pathFile, Class<E[]> classOfT) {
        E[] objArray = null;
        try {
            Gson gson = new GsonBuilder().create();
            // BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile,
            // StandardCharsets.UTF_8));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
            objArray = gson.fromJson(bufferedReader, classOfT);
        } catch (RuntimeException | IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return objArray;
    }

//    public Boolean writeObject(String pathFile, E object) {
//        boolean successful = false;
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        try (FileWriter writer = new FileWriter(pathFile)) {
//            synchronized (fileWriterLock) {
//                gson.toJson(object, writer);
//            }
//            successful = true;
//        } catch (IOException e) {
//            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
//        }
//        return successful;
//    }
//
//    public Boolean writeObjects(String pathFile, E[] objects) {
//        boolean successful = false;
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        try (FileWriter writer = new FileWriter(pathFile)) {
//            synchronized (fileWriterLock) {
//                gson.toJson(objects, writer);
//            }
//            successful = true;
//        } catch (IOException e) {
//            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
//        }
//        return successful;
//    }

//    @Override
//    public E[] getObjects(String filePath, Class<E[]> clazz, Class<?> entityType) throws IOException {
//        // Leer el archivo JSON y deserializar los objetos
//        File file = new File(filePath);
//        E[] objects = objectMapper.readValue(file, clazz);
//
//        // Determinar el tipo de persona y castearla adecuadamente
//        for (int i = 0; i < objects.length; i++) {
//            if (entityType.isInstance(objects[i])) {
//                objects[i] = (E) clazz.cast(objects[i]);
//            }
//        }
//
//        // Devolver los objetos deserializados del tipo correcto
//        return objects;
//    }
//    @Override
//    public E[] getObjects(String filePath, Class<E[]> clazz, Class<?> entityType) throws IOException {
//        try {
//            // Leer el archivo JSON y deserializar los objetos
//            File file = new File(filePath);
//            E[] objects = objectMapper.readValue(file, clazz);
//
//            // Verificar si los objetos son instancias de la clase entityType y realizar el casting adecuado
//            for (int i = 0; i < objects.length; i++) {
//                Object object = objects[i];
//                if (entityType.isInstance(object)) {
//                    objects[i] = (E) clazz.cast(object);
//                }
//            }
//
//            // Devolver los objetos deserializados
//            return objects;
//        } catch (IOException e) {
//            // Manejar la excepción adecuadamente según los requisitos de tu aplicación
//            throw e;
//        }
//    }
    @SuppressWarnings("unchecked")
    public static synchronized <E> FileJsonAdapter<E> getInstance() {
        if (instance == null) {
            instance = new FileJsonAdapter<>();
        }
        return (FileJsonAdapter<E>) instance;
    }

    @Override
    public E[] getObjects(String filePath, Class<E[]> clazz, Class<?> entityType) throws IOException {
        // Leer el archivo JSON y deserializar los objetos
        File file = new File(filePath);
        E[] objects = objectMapper.readValue(file, clazz);

        // Devolver los objetos deserializados del tipo correcto
        return objects;
    }
    public Boolean writeObject(String pathFile, E object) {
        boolean successful = false;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(pathFile)) {
            synchronized (fileWriterLock) {
                gson.toJson(object, writer);
            }
            successful = true;
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return successful;
    }

    public Boolean writeObjects(String pathFile, E[] objects) {
        boolean successful = false;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(pathFile)) {
            synchronized (fileWriterLock) {
                gson.toJson(objects, writer);
            }
            successful = true;
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return successful;
    }
}
