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
    private static User userLogin;

    public boolean login(String username, String password) {
        // Obtiene el usuario del repositorio
        UserRepository userRepository = new UserRepository("src\\main\\java\\upb\\sgttp\\database\\users.json");
        User user = userRepository.getUserByUsername(username);

        // Verifica si se encontró un usuario
        if (user != null) {
            // Verifica si la contraseña coincide y retorna el resultado de la autenticación
            setUserLogin(user);
            return user.getPassword().equals(password) && user.getType() == 3;
        } else {
            // El usuario no fue encontrado, por lo que la autenticación falla
            return false;
        }
    }

    public static User getUserLogin() {
        return userLogin;
    }

    @SuppressWarnings("static-access")
    public void setUserLogin(User userLogin) {
        this.userLogin = userLogin;
    }

}
