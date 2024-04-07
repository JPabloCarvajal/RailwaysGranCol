package jp.sgttp.model.repository.Users;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import jp.sgttp.model.domain.persons.AbstractPerson;
import jp.sgttp.model.domain.persons.Admin;
import jp.sgttp.model.domain.persons.Contact;
import jp.sgttp.model.domain.persons.Customer;
import jp.sgttp.model.domain.persons.Employee;
import jp.sgttp.model.domain.persons.User;
import jp.sgttp.shared.filejsonadapter.FileJsonAdapter;
import jp.sgttp.shared.filejsonadapter.FileJsonInterface;

public class UserRepository {

    private FileJsonInterface<UserEntity> fileJson;
    private String pathFile;

    public UserRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public boolean addUser(User user) {
        // Obtener todos los usuarios del archivo JSON
        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);

        // Verificar si userEntities es null antes de continuar
        if (userEntities == null) {
            userEntities = new UserEntity[0]; // Si es null, asignamos un array vacío
        }

        // Crear una nueva instancia de UserEntity a partir del usuario proporcionado
        UserEntity newUserEntity = new UserEntity(
                user.getPerson(),
                user.getUsername(),
                user.getPassword(),
                user.getType()
        );

        // Crear un nuevo array para almacenar todos los usuarios, incluido el nuevo usuario
        Array<UserEntity> updatedUserEntities = new Array<>(userEntities.length + 1);
        for (UserEntity entity : userEntities) {
            updatedUserEntities.add(entity);
        }
        updatedUserEntities.add(newUserEntity);

        // Convertir el Array<UserEntity> a un array regular de UserEntity[]
        UserEntity[] updatedUserEntitiesArray = new UserEntity[updatedUserEntities.size()];
        for (int i = 0; i < updatedUserEntities.size(); i++) {
            updatedUserEntitiesArray[i] = updatedUserEntities.get(i);
        }

        return fileJson.writeObjects(pathFile, updatedUserEntitiesArray);
    }

    public boolean removeUser(String username) {
        // Obtener todos los usuarios del archivo JSON
        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);

        // Buscar el usuario con el nombre de usuario especificado
        int indexToRemove = -1;
        for (int i = 0; i < userEntities.length; i++) {
            if (userEntities[i].getUsername().equals(username)) {
                indexToRemove = i;
                break;
            }
        }

        // Si se encontró el usuario, eliminarlo y escribir de nuevo los usuarios actualizados en el archivo JSON
        if (indexToRemove != -1) {
            Array<UserEntity> updatedUserEntities = new Array<>(userEntities.length - 1);
            for (int i = 0; i < userEntities.length; i++) {
                if (i != indexToRemove) {
                    updatedUserEntities.add(userEntities[i]);
                }
            }

            UserEntity[] updatedUserEntitiesArray = new UserEntity[updatedUserEntities.size()];
            for (int i = 0; i < updatedUserEntities.size(); i++) {
                updatedUserEntitiesArray[i] = updatedUserEntities.get(i);
            }

            return fileJson.writeObjects(pathFile, updatedUserEntitiesArray);
        } else {
            // Si no se encontró el usuario con el nombre de usuario especificado, devolver false
            return false;
        }
    }

    public boolean modifyUser(String username, User modifiedUser) {
        // Obtener todos los usuarios del archivo JSON
        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);

        // Buscar el usuario con el nombre de usuario especificado
        int indexToModify = -1;
        for (int i = 0; i < userEntities.length; i++) {
            if (userEntities[i].getUsername().equals(username)) {
                indexToModify = i;
                break;
            }
        }

        // Si se encontró el usuario, modificarlo y escribir de nuevo los usuarios actualizados en el archivo JSON
        if (indexToModify != -1) {
            userEntities[indexToModify].setPerson(modifiedUser.getPerson());
            userEntities[indexToModify].setUsername(modifiedUser.getUsername());
            userEntities[indexToModify].setPassword(modifiedUser.getPassword());
            userEntities[indexToModify].setType(modifiedUser.getType());

            return fileJson.writeObjects(pathFile, userEntities);
        } else {
            // Si no se encontró el usuario con el nombre de usuario especificado, devolver false
            return false;
        }
    }

    public LinkedList<User> getAllUsersAsLinkedList() {
        // Obtener todos los usuarios del archivo JSON
        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);

        // Crear una lista enlazada para almacenar los usuarios
        LinkedList<User> userList = new LinkedList<>();

        // Agregar cada usuario a la lista enlazada
        for (UserEntity entity : userEntities) {
            User user = new User(
                    entity.getPerson(),
                    entity.getUsername(),
                    entity.getPassword(),
                    entity.getType()
            );
            userList.add(user);
        }

        return userList;
    }

    public boolean modifyUsers(LinkedList<User> modifiedUsers) {
        // Convertir la lista de usuarios modificados a un arreglo de entidades de usuario
        UserEntity[] modifiedUserEntities = new UserEntity[modifiedUsers.size()];
        for (int i = 0; i < modifiedUsers.size(); i++) {
            User modifiedUser = modifiedUsers.get(i);
            modifiedUserEntities[i] = new UserEntity(
                    modifiedUser.getPerson(),
                    modifiedUser.getUsername(),
                    modifiedUser.getPassword(),
                    modifiedUser.getType()
            );
        }

        // Escribir los nuevos objetos en el archivo JSON
        return fileJson.writeObjects(pathFile, modifiedUserEntities);
    }
}
