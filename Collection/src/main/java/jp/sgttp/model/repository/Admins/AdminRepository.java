package jp.sgttp.model.repository.Admins;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import jp.sgttp.model.domain.persons.Admin;
import jp.sgttp.shared.filejsonadapter.FileJsonAdapter;
import jp.sgttp.shared.filejsonadapter.FileJsonInterface;

public class AdminRepository {

    private FileJsonInterface<AdminEntity> fileJson;
    private String pathFile;

    public AdminRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public boolean addAdmin(Admin admin) {
        AdminEntity[] adminEntities = fileJson.getObjects(pathFile, AdminEntity[].class);

        if (adminEntities == null) {
            adminEntities = new AdminEntity[0];
        }
        AdminEntity newAdminEntity = new AdminEntity(
                admin.getNames(),
                admin.getLastNames(),
                admin.getPhoneNumbers(),
                admin.getId()
        );

        Array<AdminEntity> updatedAdminEntities = new Array<>(adminEntities.length + 1);
        for (AdminEntity entity : adminEntities) {
            updatedAdminEntities.add(entity);
        }
        updatedAdminEntities.add(newAdminEntity);

        AdminEntity[] updatedAdminEntitiesArray = new AdminEntity[updatedAdminEntities.size()];
        for (int i = 0; i < updatedAdminEntities.size(); i++) {
            updatedAdminEntitiesArray[i] = updatedAdminEntities.get(i);
        }

        return fileJson.writeObjects(pathFile, updatedAdminEntitiesArray);
    }

    public boolean removeAdmin(String adminId) {
        AdminEntity[] adminEntities = fileJson.getObjects(pathFile, AdminEntity[].class);

        int indexToRemove = -1;
        for (int i = 0; i < adminEntities.length; i++) {
            if (adminEntities[i].getId().equals(adminId)) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            Array<AdminEntity> updatedAdminEntities = new Array<>(adminEntities.length - 1);
            for (int i = 0; i < adminEntities.length; i++) {
                if (i != indexToRemove) {
                    updatedAdminEntities.add(adminEntities[i]);
                }
            }

            AdminEntity[] updatedAdminEntitiesArray = new AdminEntity[updatedAdminEntities.size()];
            for (int i = 0; i < updatedAdminEntities.size(); i++) {
                updatedAdminEntitiesArray[i] = updatedAdminEntities.get(i);
            }

            return fileJson.writeObjects(pathFile, updatedAdminEntitiesArray);
        } else {
            return false;
        }
    }

    public boolean modifyAdmin(String adminId, Admin modifiedAdmin) {
        AdminEntity[] adminEntities = fileJson.getObjects(pathFile, AdminEntity[].class);

        int indexToModify = -1;
        for (int i = 0; i < adminEntities.length; i++) {
            if (adminEntities[i].getId().equals(adminId)) {
                indexToModify = i;
                break;
            }
        }

        if (indexToModify != -1) {
            adminEntities[indexToModify].setNames(modifiedAdmin.getNames());
            adminEntities[indexToModify].setLastNames(modifiedAdmin.getLastNames());
            adminEntities[indexToModify].setPhoneNumbers(modifiedAdmin.getPhoneNumbers());
            adminEntities[indexToModify].setId(modifiedAdmin.getId());

            return fileJson.writeObjects(pathFile, adminEntities);
        } else {
            return false;
        }
    }

    public LinkedList<Admin> getAllAdminsAsLinkedList() {
        AdminEntity[] adminEntities = fileJson.getObjects(pathFile, AdminEntity[].class);

        LinkedList<Admin> adminList = new LinkedList<>();

        for (AdminEntity entity : adminEntities) {
            Admin admin = new Admin(
                    entity.getNames(),
                    entity.getLastNames(),
                    entity.getPhoneNumbers(),
                    entity.getId()
            );
            adminList.add(admin);
        }

        return adminList;
    }

    public boolean modifyAdmin(LinkedList<Admin> modifiedAdmins) {
        AdminEntity[] modifiedAdminEntities = new AdminEntity[modifiedAdmins.size()];
        for (int i = 0; i < modifiedAdmins.size(); i++) {
            Admin admin = modifiedAdmins.get(i);
            modifiedAdminEntities[i] = new AdminEntity(
                    admin.getNames(),
                    admin.getLastNames(),
                    admin.getPhoneNumbers(),
                    admin.getId()
            );
        }

        return fileJson.writeObjects(pathFile, modifiedAdminEntities);
    }
}
