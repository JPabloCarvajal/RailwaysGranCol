package jp.sgttp.shared.filejsonadapter;

import java.io.IOException;

public interface FileJsonInterface<E>{
    
    E getObject(String pathFile, Class<E> classOfT);
  
    E[] getObjects(String pathFile, Class<E[]> classOfT);
  
    Boolean writeObject(String pathFile, E object);
  
    Boolean writeObjects(String pathFile, E[] objects);
    E[] getObjects(String filePath, Class<E[]> clazz, Class<?> entityType) throws IOException;
  }
