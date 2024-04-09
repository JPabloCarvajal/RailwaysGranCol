package jp.sgttp.model.repository.Users;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
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
        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);

        if (userEntities == null) {
            userEntities = new UserEntity[0];
        }

        UserEntity newUserEntity = new UserEntity(
                user.getPerson(),
                user.getUsername(),
                user.getPassword(),
                user.getType()
        );

        Array<UserEntity> updatedUserEntities = new Array<>(userEntities.length + 1);
        for (UserEntity entity : userEntities) {
            updatedUserEntities.add(entity);
        }
        updatedUserEntities.add(newUserEntity);

        UserEntity[] updatedUserEntitiesArray = new UserEntity[updatedUserEntities.size()];
        for (int i = 0; i < updatedUserEntities.size(); i++) {
            updatedUserEntitiesArray[i] = updatedUserEntities.get(i);
        }

        return fileJson.writeObjects(pathFile, updatedUserEntitiesArray);
    }

    public boolean removeUser(String username) {
        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);

        int indexToRemove = -1;
        for (int i = 0; i < userEntities.length; i++) {
            if (userEntities[i].getUsername().equals(username)) {
                indexToRemove = i;
                break;
            }
        }

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
            return false;
        }
    }

    public boolean modifyUser(String username, User modifiedUser) {
        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);

        int indexToModify = -1;
        for (int i = 0; i < userEntities.length; i++) {
            if (userEntities[i].getUsername().equals(username)) {
                indexToModify = i;
                break;
            }
        }

        if (indexToModify != -1) {
            userEntities[indexToModify].setPerson(modifiedUser.getPerson());
            userEntities[indexToModify].setUsername(modifiedUser.getUsername());
            userEntities[indexToModify].setPassword(modifiedUser.getPassword());
            userEntities[indexToModify].setType(modifiedUser.getType());

            return fileJson.writeObjects(pathFile, userEntities);
        } else {
            return false;
        }
    }

    public LinkedList<User> getAllUsersAsLinkedList() {
        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);

        LinkedList<User> userList = new LinkedList<>();

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

        return fileJson.writeObjects(pathFile, modifiedUserEntities);
    }
}
