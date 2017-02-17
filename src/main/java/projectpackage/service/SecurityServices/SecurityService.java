package projectpackage.service.SecurityServices;

import projectpackage.validators.AuthValidation;

/**
 * Created by Gvozd on 07.01.2017.
 */
public interface SecurityService {
    String findLoggedInUsername();
    AuthValidation autologin(String username, String password);
}
