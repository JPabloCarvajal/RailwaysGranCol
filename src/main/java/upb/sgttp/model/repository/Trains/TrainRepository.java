package upb.sgttp.model.repository.Trains;

import java.io.Serializable;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.trainUtilities.Train;
import upb.sgttp.shared.filejsonadapter.FileJsonAdapter;
import upb.sgttp.shared.filejsonadapter.FileJsonInterface;

public class TrainRepository implements Serializable{

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
                        trainEntity.getLuggageWagons(),
                        trainEntity.isAvailable()
                        );
            }
        }
        return Train.getNullTrain();
    }

    public boolean addTrain(Train train) {
        TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);

        if (trainEntities == null) {
            trainEntities = new TrainEntity[0]; 
        }

        TrainEntity newTrainEntity = new TrainEntity(
                train.getTrainName(),
                train.getTrainId(),
                train.getKilometers(),
                train.getLoadingCapacity(),
                train.getBrand(),
                train.getCustomersWagons(),
                train.getLuggageWagons(),
                train.isAvailable()
                );

        Array<TrainEntity> updatedTrainEntities = new Array<>(trainEntities.length + 1);
        for (TrainEntity entity : trainEntities) {
            updatedTrainEntities.add(entity);
        }
        updatedTrainEntities.add(newTrainEntity);

        TrainEntity[] updatedTrainEntitiesArray = new TrainEntity[updatedTrainEntities.size()];
        for (int i = 0; i < updatedTrainEntities.size(); i++) {
            updatedTrainEntitiesArray[i] = updatedTrainEntities.get(i);
        }

        return fileJson.writeObjects(pathFile, updatedTrainEntitiesArray);
    }

    public boolean removeTrain(String trainId) {
        TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);

        int indexToRemove = -1;
        for (int i = 0; i < trainEntities.length; i++) {
            if (trainEntities[i].getTrainId().equals(trainId)) {
                indexToRemove = i;
                break;
            }
        }

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
            return false;
        }
    }

    public boolean modifyTrain(String trainId, Train modifiedTrain) {
        TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);

        int indexToModify = -1;
        for (int i = 0; i < trainEntities.length; i++) {
            if (trainEntities[i].getTrainId().equals(trainId)) {
                indexToModify = i;
                break;
            }
        }
        if (indexToModify != -1) {
            trainEntities[indexToModify].setTrainName(modifiedTrain.getTrainName());
            trainEntities[indexToModify].setKilometers(modifiedTrain.getKilometers());
            trainEntities[indexToModify].setLoadingCapacity(modifiedTrain.getLoadingCapacity());
            trainEntities[indexToModify].setBrand(modifiedTrain.getBrand());
            trainEntities[indexToModify].setCustomersWagons(modifiedTrain.getCustomersWagons());
            trainEntities[indexToModify].setLuggageWagons(modifiedTrain.getLuggageWagons());
            trainEntities[indexToModify].setAvailable(modifiedTrain.isAvailable());
            return fileJson.writeObjects(pathFile, trainEntities);
        } else {
            return false;
        }
    }

    public LinkedList<Train> getAllTrainsAsLinkedList() {
        TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);
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
                    entity.getLuggageWagons(),
                    entity.isAvailable()
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
                    train.getLuggageWagons(),
                    train.isAvailable()
            );
        }

        return fileJson.writeObjects(pathFile, modifiedTrainEntities);
    }
}
