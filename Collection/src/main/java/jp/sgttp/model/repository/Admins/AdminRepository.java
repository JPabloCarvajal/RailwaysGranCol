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
        // Obtener todos los administradores del archivo JSON
        AdminEntity[] adminEntities = fileJson.getObjects(pathFile, AdminEntity[].class);
    
        // Verificar si adminEntities es null antes de continuar
        if (adminEntities == null) {
            adminEntities = new AdminEntity[0]; // Si es null, asignamos un array vacío
        }
    
        // Crear una nueva instancia de AdminEntity a partir del administrador proporcionado
        AdminEntity newAdminEntity = new AdminEntity(
            admin.getNames(),
            admin.getLastNames(),
            admin.getPhoneNumbers(),
            admin.getId()
        );
    
        // Crear un nuevo array para almacenar todos los administradores, incluido el nuevo administrador
        Array<AdminEntity> updatedAdminEntities = new Array<>(adminEntities.length + 1);
        for (AdminEntity entity : adminEntities) {
            updatedAdminEntities.add(entity);
        }
        updatedAdminEntities.add(newAdminEntity);
    
        // Convertir el Array<AdminEntity> a un array regular de AdminEntity[]
        AdminEntity[] updatedAdminEntitiesArray = new AdminEntity[updatedAdminEntities.size()];
        for (int i = 0; i < updatedAdminEntities.size(); i++) {
            updatedAdminEntitiesArray[i] = updatedAdminEntities.get(i);
        }
    
        return fileJson.writeObjects(pathFile, updatedAdminEntitiesArray);
    }

    public boolean removeAdmin(String adminId) {
        // Obtener todos los administradores del archivo JSON
        AdminEntity[] adminEntities = fileJson.getObjects(pathFile, AdminEntity[].class);

        // Buscar el administrador con el ID especificado
        int indexToRemove = -1;
        for (int i = 0; i < adminEntities.length; i++) {
            if (adminEntities[i].getId().equals(adminId)) {
                indexToRemove = i;
                break;
            }
        }

        // Si se encontró el administrador, eliminarlo y escribir de nuevo los administradores actualizados en el archivo JSON
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
            // Si no se encontró el administrador con el ID especificado, devolver false
            return false;
        }
    }

    public boolean modifyAdmin(String adminId, Admin modifiedAdmin) {
        // Obtener todos los administradores del archivo JSON
        AdminEntity[] adminEntities = fileJson.getObjects(pathFile, AdminEntity[].class);

        // Buscar el administrador con el ID especificado
        int indexToModify = -1;
        for (int i = 0; i < adminEntities.length; i++) {
            if (adminEntities[i].getId().equals(adminId)) {
                indexToModify = i;
                break;
            }
        }

        // Si se encontró el administrador, modificarlo y escribir de nuevo los administradores actualizados en el archivo JSON
        if (indexToModify != -1) {
            adminEntities[indexToModify].setNames(modifiedAdmin.getNames());
            adminEntities[indexToModify].setLastNames(modifiedAdmin.getLastNames());
            adminEntities[indexToModify].setPhoneNumbers(modifiedAdmin.getPhoneNumbers());
            adminEntities[indexToModify].setId(modifiedAdmin.getId());

            return fileJson.writeObjects(pathFile, adminEntities);
        } else {
            // Si no se encontró el administrador con el ID especificado, devolver false
            return false;
        }
    }

    public LinkedList<Admin> getAllAdminsAsLinkedList() {
        // Obtener todos los administradores del archivo JSON
        AdminEntity[] adminEntities = fileJson.getObjects(pathFile, AdminEntity[].class);
    
        // Crear una lista enlazada para almacenar los administradores
        LinkedList<Admin> adminList = new LinkedList<>();
    
        // Agregar cada administrador a la lista enlazada
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
}

