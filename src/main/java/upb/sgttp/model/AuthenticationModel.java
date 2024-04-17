/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upb.sgttp.model;

import upb.sgttp.model.domain.persons.User;
import upb.sgttp.model.repository.Users.UserRepository;

/**
 *
 * @author thewe
 */
public class AuthenticationModel {
    public boolean login(String username, String password) {
        // Obtiene el usuario del repositorio
        UserRepository userRepository = new UserRepository("C:\\Users\\thewe\\OneDrive\\Escritorio\\nuevo train\\SGTTP\\src\\main\\java\\upb\\sgttp\\database\\users.json");
        User user = userRepository.getUserByUsername(username);

        // Verifica si se encontró un usuario
        if (user != null) {
            // Verifica si la contraseña coincide y retorna el resultado de la autenticación
            return user.getPassword().equals(password) && user.getType() == 3;
        } else {
            // El usuario no fue encontrado, por lo que la autenticación falla
            return false;
        }
    }
}
