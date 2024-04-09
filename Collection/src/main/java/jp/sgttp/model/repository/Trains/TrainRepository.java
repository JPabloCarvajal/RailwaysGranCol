package jp.sgttp.model.repository.Trains;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
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
                        trainEntity.getLuggageWagons()
                        );
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
                train.getLuggageWagons()
                );

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
        } else {
            // Si no se encontró el tren con el ID especificado, devolver false
            return false;
        }
    }

    public boolean modifyTrain(String trainId, Train modifiedTrain) {
        // Obtener todos los trenes del archivo JSON
        TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);

        // Buscar el tren con el ID especificado
        int indexToModify = -1;
        for (int i = 0; i < trainEntities.length; i++) {
            if (trainEntities[i].getTrainId().equals(trainId)) {
                indexToModify = i;
                break;
            }
        }

        // Si se encontró el tren, modificarlo y escribir de nuevo los trenes actualizados en el archivo JSON
        if (indexToModify != -1) {
            trainEntities[indexToModify].setTrainName(modifiedTrain.getTrainName());
            trainEntities[indexToModify].setKilometers(modifiedTrain.getKilometers());
            trainEntities[indexToModify].setLoadingCapacity(modifiedTrain.getLoadingCapacity());
            trainEntities[indexToModify].setBrand(modifiedTrain.getBrand());
            trainEntities[indexToModify].setCustomersWagons(modifiedTrain.getCustomersWagons());
            trainEntities[indexToModify].setLuggageWagons(modifiedTrain.getLuggageWagons());

            return fileJson.writeObjects(pathFile, trainEntities);
        } else {
            // Si no se encontró el tren con el ID especificado, devolver false
            return false;
        }
    }

    public LinkedList<Train> getAllTrainsAsLinkedList() {
        // Obtener todos los trenes del archivo JSON
        TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);

        // Crear una lista enlazada para almacenar los trenes
        LinkedList<Train> trainList = new LinkedList<>();

        for (int i = 0; i < trainEntities.length; i++) {
            TrainEntity entity = trainEntities[i];
            Train train = new Train(
                    entity.getTrainName(),
                    entity.getTrainId(),
                    entity.getKilometers(),
                    entity.getLoadingCapacity(),
                    entity.getBrand(),
                    entity.getCustomersWagons(),
                    entity.getLuggageWagons()
                    
            );
            trainList.add(train);
        }

        return trainList;
    }

//    public boolean modifyTrain(LinkedList<Train> modifiedTrains) {
//        // Convertir la LinkedList a un arreglo de TrainEntity
//        TrainEntity[] modifiedTrainEntities = new TrainEntity[modifiedTrains.size()];
//        for (int i = 0; i < modifiedTrains.size(); i++) {
//            Train train = modifiedTrains.get(i);
//            modifiedTrainEntities[i] = new TrainEntity(
//                    train.getTrainName(),
//                    train.getTrainId(),
//                    train.getKilometers(),
//                    train.getLoadingCapacity(),
//                    train.getBrand(),
//                    train.getCustomersWagons(),
//                    train.getLuggageWagons(),
//                    train.getUbication()
//            );
//        }
//        return fileJson.writeObjects(pathFile, modifiedTrainEntities);
//    }
    public boolean modifyTrain(LinkedList<Train> modifiedTrains) {
        // Convertir la LinkedList a un arreglo de TrainEntity
        TrainEntity[] modifiedTrainEntities = new TrainEntity[modifiedTrains.size()];
        for (int i = 0; i < modifiedTrains.size(); i++) {
            Train train = modifiedTrains.get(i);
            modifiedTrainEntities[i] = new TrainEntity(
                    train.getTrainName(),
                    train.getTrainId(),
                    train.getKilometers(),
                    train.getLoadingCapacity(),
                    train.getBrand(),
                    train.getCustomersWagons(),
                    train.getLuggageWagons()
            );
        }

        // Escribir los nuevos objetos en el archivo JSON
        return fileJson.writeObjects(pathFile, modifiedTrainEntities);
    }
}
