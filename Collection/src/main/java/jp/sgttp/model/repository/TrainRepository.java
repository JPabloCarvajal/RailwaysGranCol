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
        if (trainEntity.getTrainId() == trainId) {
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

        // Escribir el nuevo array de trenes en el archivo JSON
        return fileJson.writeObjects(pathFile, updatedTrainEntitiesArray);
    }

}

