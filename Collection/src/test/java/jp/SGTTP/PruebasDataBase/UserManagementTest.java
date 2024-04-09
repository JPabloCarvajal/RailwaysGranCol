package jp.SGTTP.PruebasDataBase;

import jp.array.Array;
import jp.sgttp.model.domain.persons.AbstractPerson;
import jp.sgttp.model.domain.persons.User;
import jp.sgttp.model.repository.Users.UserRepository;
import jp.util.iterator.Iterator;

public class UserManagementTest {/*    public static void main(String[] args) {
        // Ruta del archivo JSON de usuarios
        String pathFile = "C:\\Users\\juanp\\OneDrive\\Escritorio\\RailwaysGranCol\\EDDJP\\Collection\\src\\main\\java\\jp\\sgttp\\database\\users.json";

        // Instancia de UserRepository
        UserRepository userRepository = new UserRepository(pathFile);

        try {
            // Agregar un nuevo usuario
            User newUser = new User(new AbstractPerson("pepe botellas","lopez",new Array<>(new String[]{"3","1","6","4","9","9","1","0","2","8"})), "pepe223221", "password123", 3);
            boolean added = userRepository.addUser(newUser);
            if (added) {
                System.out.println("New user added successfully.");
            } else {
                System.out.println("Failed to add new user.");
            }

            // Eliminar un usuario existente
            String usernameToRemove = "sopapon"; // Cambiar por el nombre de usuario que deseas remover
            boolean removed = userRepository.removeUser(usernameToRemove);
            if (removed) {
                System.out.println("User removed successfully.");
            } else {
                System.out.println("Failed to remove user with username: " + usernameToRemove);
            }

            // Modificar un usuario existente
            String usernameToModify = "newuser"; // Cambiar por el nombre de usuario que deseas modificar
            User modifiedUser = new User(new AbstractPerson(), "modifieduser", "newpassword123", 2);
            boolean modified = userRepository.modifyUser(usernameToModify, modifiedUser);
            if (modified) {
                System.out.println("User modified successfully.");
            } else {
                System.out.println("Failed to modify user with username: " + usernameToModify);
            }

            // Obtener todos los usuarios como una lista enlazada y mostrarlos
            Iterator<User> iterator = userRepository.getAllUsersAsLinkedList().iterator();
            System.out.println("All users:");
            while(iterator.hasNext()) {
                User user = iterator.next();
                System.out.println(user.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */ 
}
