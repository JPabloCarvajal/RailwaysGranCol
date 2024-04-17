package upb.SGTTP.PruebasDataBase;

import jp.array.Array;
import upb.sgttp.model.domain.RouteUtilities.RoutesMap;
import upb.sgttp.model.domain.trainUtilities.Train;
import upb.sgttp.model.repository.Trains.TrainRepository;
import jp.util.iterator.Iterator;

public class TrainManagementTest {
    // public static void main(String[] args) {
    //     // Ruta del archivo JSON de trenes
    //     String pathFile = "C:\\Users\\juanp\\OneDrive\\Escritorio\\SGTTP\\src\\main\\java\\upb\\sgttp\\database\\train.json";
    //     RoutesMap mapa = new RoutesMap();

    //     // Instancia de TrainRepository
    //     TrainRepository trainRepository = new TrainRepository(pathFile);

    //     try {
    //         // Agregar un nuevo tren
            
    //         Train newTrain = new Train("mamaguevo", "004", 800, 75.0f, "Passenger Transport", new Array<>(2), new Array<>(2));
    //         boolean added = trainRepository.addTrain(newTrain);
    //         if (added) {
    //             System.out.println("New train added successfully.");
    //         } else {
    //             System.out.println("Failed to add new train.");
    //         }

    //         // Prueba del método getTrain()
    //         String trainIdToSearch = "003";
    //         Train train = trainRepository.getTrain(trainIdToSearch);
    //         if (train != Train.getNullTrain()) {
    //             System.out.println("Train found:");
    //             System.out.println(train.toString());
    //         } else {
    //             System.out.println("Train not found for ID: " + trainIdToSearch);
    //         }

    //         // Eliminar tren
    //         String trainIdToRemove = "005"; // Cambiar por el ID del tren que deseas remover
    //         boolean removed = trainRepository.removeTrain(trainIdToRemove);
    //         if (removed) {
    //             System.out.println("Train removed successfully.");
    //         } else {
    //             System.out.println("Failed to remove train with ID: " + trainIdToRemove);
    //         }

    //         // Modificar un tren existente
    //         String trainIdToModify = "004"; // Cambiar por el ID del tren que deseas modificar
    //         Train modifiedTrain = new Train("Mercedes Updated", trainIdToModify, 900, 85.0f, "Passenger Transport Updated", new Array<>(3), new Array<>(3));
    //         boolean modified = trainRepository.modifyTrain(trainIdToModify, modifiedTrain);
    //         if (modified) {
    //             System.out.println("Train modified successfully.");
    //         } else {
    //             System.out.println("Failed to modify train with ID: " + trainIdToModify);
    //         }
    //         Iterator<Train> iterador = trainRepository.getAllTrainsAsLinkedList().iterator();
    //         System.out.println("[");
    //         while(iterador.hasNext()){
    //             Train temp = iterador.next();
    //             System.out.println(temp.toString());
    //         }
    //         System.out.println("]");

    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }
}
