package jp.SGTTP.PruebasDataBase;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import jp.sgttp.model.domain.persons.Admin;
import jp.sgttp.model.repository.Admins.AdminRepository;
import jp.util.iterator.Iterator;

public class AdminManagementTest {
    public static void main(String[] args) {
        // Ruta del archivo JSON de administradores
        String pathFile = "C:\\Users\\juanp\\OneDrive\\Escritorio\\RailwaysGranCol\\EDDJP\\Collection\\src\\main\\java\\jp\\sgttp\\database\\admins.json";

        // Instancia de AdminRepository
        AdminRepository adminRepository = new AdminRepository(pathFile);

        try {
            // Agregar un nuevo administrador
            Admin newAdmin = new Admin("John", "Doe", new Array<>(new String[]{"123456789"}), "JD123");
            boolean added = adminRepository.addAdmin(newAdmin);
            if (added) {
                System.out.println("New admin added successfully.");
            } else {
                System.out.println("Failed to add new admin.");
            }

            // Eliminar un administrador existente
            String adminIdToRemove = "JD123"; // Cambiar por el ID del administrador que deseas remover
            boolean removed = adminRepository.removeAdmin(adminIdToRemove);
            if (removed) {
                System.out.println("Admin removed successfully.");
            } else {
                System.out.println("Failed to remove admin with ID: " + adminIdToRemove);
            }

            // Modificar un administrador existente
            String adminIdToModify = "JD456"; // Cambiar por el ID del administrador que deseas modificar
            Admin modifiedAdmin = new Admin("John", "ModifiedDoe", new Array<>(new String[]{"987654321"}), "JD456");
            boolean modified = adminRepository.modifyAdmin(adminIdToModify, modifiedAdmin);
            if (modified) {
                System.out.println("Admin modified successfully.");
            } else {
                System.out.println("Failed to modify admin with ID: " + adminIdToModify);
            }

            // Obtener todos los administradores como una lista enlazada y mostrarlos
            LinkedList<Admin> adminsList = adminRepository.getAllAdminsAsLinkedList();
            System.out.println("All admins:");
            Iterator<Admin> iterator = adminsList.iterator();
            while(iterator.hasNext()) {
                Admin admin = iterator.next();
                System.out.println(admin.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
