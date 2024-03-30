package jp.sgttp.model.repository; 

import jp.array.Array;
import jp.sgttp.model.domain.trainUtilities.Train;
import jp.sgttp.shared.filejsonadapter.FileJsonAdapter;
import jp.sgttp.shared.filejsonadapter.FileJsonInterface;

public class TrainRepository {

    private FileJsonInterface<TrainEntity> fileJson;
    private String pathFile;


    public TrainRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public Train getTrain(String trainId) {
        TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);
        for (TrainEntity trainEntity : trainEntities) {
        if (trainEntity.getTrainId().equals(trainId)) {
            return new Train(
                trainEntity.getTrainName(),
                trainEntity.getTrainId(),
                trainEntity.getKilometers(),
                trainEntity.getLoadingCapacity(),
                trainEntity.getBrand(),
                trainEntity.getCustomersWagons(),
                trainEntity.getLuggageWagons());
        }
        }
        return Train.getNullTrain();
    }

    public boolean addTrain(Train train) {
        // Obtener todos los trenes del archivo JSON
        TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);
    
        // Verificar si trainEntities es null antes de continuar
        if (trainEntities == null) {
            trainEntities = new TrainEntity[0]; // Si es null, asignamos un array vacío
        }
    
        // Crear una nueva instancia de TrainEntity a partir del tren proporcionado
        TrainEntity newTrainEntity = new TrainEntity(
                train.getTrainName(),
                train.getTrainId(),
                train.getKilometers(),
                train.getLoadingCapacity(),
                train.getBrand(),
                train.getCustomersWagons(),
                train.getLuggageWagons());
    
        // Crear un nuevo array para almacenar todos los trenes, incluido el nuevo tren
        Array<TrainEntity> updatedTrainEntities = new Array<>(trainEntities.length + 1);
        for (TrainEntity entity : trainEntities) {
            updatedTrainEntities.add(entity);
        }
        updatedTrainEntities.add(newTrainEntity);
    
        // Convertir el Array<TrainEntity> a un array regular de TrainEntity[]
        TrainEntity[] updatedTrainEntitiesArray = new TrainEntity[updatedTrainEntities.size()];
        for (int i = 0; i < updatedTrainEntities.size(); i++) {
            updatedTrainEntitiesArray[i] = updatedTrainEntities.get(i);
        }
    
        return fileJson.writeObjects(pathFile, updatedTrainEntitiesArray);
    }
    

    public boolean removeTrain(String trainId) {
        // Obtener todos los trenes del archivo JSON
        TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);
    
        // Buscar el tren con el ID especificado
        int indexToRemove = -1;
        for (int i = 0; i < trainEntities.length; i++) {
            if (trainEntities[i].getTrainId().equals(trainId)) {
                indexToRemove = i;
                break;
            }
        }
    
        // Si se encontró el tren, eliminarlo y escribir de nuevo los trenes actualizados en el archivo JSON
        if (indexToRemove != -1) {
            Array<TrainEntity> updatedTrainEntities = new Array<>(trainEntities.length - 1);
            for (int i = 0; i < trainEntities.length; i++) {
                if (i != indexToRemove) {
                    updatedTrainEntities.add(trainEntities[i]);
                }
            }
    
            TrainEntity[] updatedTrainEntitiesArray = new TrainEntity[updatedTrainEntities.size()];
            for (int i = 0; i < updatedTrainEntities.size(); i++) {
                updatedTrainEntitiesArray[i] = updatedTrainEntities.get(i);
            }
    
            return fileJson.writeObjects(pathFile, updatedTrainEntitiesArray);
        } 
        else {
            // Si no se encontró el tren con el ID especificado, devolver false
            return false;
        }
    }
    /*Nombre: Gestión de trenes. 
    Como empleado, quiero un sistema de gestión de trenes, para garantizar una 
    buena operación. 
    Criterio de aceptación: 
    el administrador podrá //YA//agregar un tren, darlo de baja, //YA// consultar, modificar 
    los datos de los trenes, cada tren debe tener los siguientes datos nombre, 
    identificador, capacidad de carga y kilometraje.
    Prioridad: Alto.  */
}

