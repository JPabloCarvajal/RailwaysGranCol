package upb.sgttp.model.repository.Routes;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.RouteUtilities.Route;
import upb.sgttp.shared.filejsonadapter.FileJsonAdapter;
import upb.sgttp.shared.filejsonadapter.FileJsonInterface;

public class RouteRepository {
    
    private FileJsonInterface<RouteEntity> fileJson;
    private String pathFile;

    public RouteRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public boolean addRoute(Route route) {

        RouteEntity[] RouteEntities = fileJson.getObjects(pathFile, RouteEntity[].class);

        if (RouteEntities == null) {
            RouteEntities = new RouteEntity[0];
        }
        RouteEntity newRouteEntity = new RouteEntity(
                route.getStations(),
                route.getStartPoint(),
                route.getDestinationPoint(),
                route.getDepartureTime(),
                route.getArrivalTime(),
                route.getTotalKmToTravel(),
                route.getTrainToDoRoute(),
                route.getRouteId()
        );

        Array<RouteEntity> updatedRouteEntities = new Array<>(RouteEntities.length + 1);
        for (RouteEntity entity : RouteEntities) {
            updatedRouteEntities.add(entity);
        }
        updatedRouteEntities.add(newRouteEntity);

        RouteEntity[] updatedRouteEntitiesArray = new RouteEntity[updatedRouteEntities.size()];
        for (int i = 0; i < updatedRouteEntities.size(); i++) {
            updatedRouteEntitiesArray[i] = updatedRouteEntities.get(i);
        }

        return fileJson.writeObjects(pathFile, updatedRouteEntitiesArray);
    }

    public boolean removeRoute(String routeId) {
        RouteEntity[] routeEntities = fileJson.getObjects(pathFile, RouteEntity[].class);
    
        if (routeEntities == null) {
            return false;
        }
        Array<RouteEntity> updatedRouteEntities = new Array<>(routeEntities);
    
        int indexToRemove = -1;
        for (int i = 0; i < updatedRouteEntities.size(); i++) {
            if (updatedRouteEntities.get(i).getRouteId().equals(routeId)) {
                indexToRemove = i;
                break;
            }
        }
    
        if (indexToRemove != -1) {
            updatedRouteEntities.remove(indexToRemove);

            RouteEntity[] updatedRouteEntitiesArray = new RouteEntity[updatedRouteEntities.size()];

            for (int i = 0; i < updatedRouteEntities.size(); i++) {
                updatedRouteEntitiesArray[i] = updatedRouteEntities.get(i);
            }

            return fileJson.writeObjects(pathFile, updatedRouteEntitiesArray);
        } else {
            return false;
        }
    }
    
    public boolean modifyRoute(String routeId, Route modifiedRoute) {
        Array<RouteEntity> routeEntities = new Array<>(fileJson.getObjects(pathFile, RouteEntity[].class));

        int indexToModify = -1;
        for (int i = 0; i < routeEntities.size(); i++) {
            if (routeEntities.get(i).getRouteId().equals(routeId)) {
                indexToModify = i;
                break;
            }
        }
        if (indexToModify != -1) {
            RouteEntity modifiedRouteEntity = new RouteEntity(
                    modifiedRoute.getStations(),
                    modifiedRoute.getStartPoint(),
                    modifiedRoute.getDestinationPoint(),
                    modifiedRoute.getDepartureTime(),
                    modifiedRoute.getArrivalTime(),
                    modifiedRoute.getTotalKmToTravel(),
                    modifiedRoute.getTrainToDoRoute(),
                    modifiedRoute.getRouteId()
            );
            routeEntities.set(indexToModify, modifiedRouteEntity);

            RouteEntity[] updatedRouteEntitiesArray = new RouteEntity[routeEntities.size()];
            for (int i = 0; i < routeEntities.size(); i++) {
                updatedRouteEntitiesArray[i] = routeEntities.get(i);
            }
            return fileJson.writeObjects(pathFile, updatedRouteEntitiesArray);
        } 
        else {
            return false;
        }
    }
    public LinkedList<Route> getAllRoutesAsLinkedList() {
        RouteEntity[] routeEntities = fileJson.getObjects(pathFile, RouteEntity[].class);

        LinkedList<Route> routeList = new LinkedList<>();
            
        for (RouteEntity entity : routeEntities) {
            Route route = new Route(
                    entity.getStations(),
                    entity.getStartPoint(),
                    entity.getDestinationPoint(),
                    entity.getDepartureTime(),
                    entity.getArrivalTime(),
                    entity.getTotalKmToTravel(),
                    entity.getTrainToDoRoute(),
                    entity.getRouteId()
            );
            routeList.add(route);
        }

        return routeList;
    }

    public Route getRoute(String routeId) {
        RouteEntity[] routeEntities = fileJson.getObjects(pathFile, RouteEntity[].class);

        for (RouteEntity entity : routeEntities) {
            if (entity.getRouteId().equals(routeId)) {
                return new Route(
                        entity.getStations(),
                        entity.getStartPoint(),
                        entity.getDestinationPoint(),
                        entity.getDepartureTime(),
                        entity.getArrivalTime(),
                        entity.getTotalKmToTravel(),
                        entity.getTrainToDoRoute(),
                        entity.getRouteId()
                );
            }
        }
        return null;
    }
}
