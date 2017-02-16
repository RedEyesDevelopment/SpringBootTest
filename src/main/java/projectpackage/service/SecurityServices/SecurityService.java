package projectpackage.service.SecurityServices;

import projectpackage.errors.AuthError;

/**
 * Created by Gvozd on 07.01.2017.
 */
public interface SecurityService {
    String findLoggedInUsername();
    AuthError autologin(String username, String password);
}
