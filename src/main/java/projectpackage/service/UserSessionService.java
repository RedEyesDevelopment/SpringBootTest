package projectpackage.service;

import projectpackage.model.AuthEntities.UserSession;

/**
 * Created by Lenovo on 17.02.2017.
 */
public interface UserSessionService {
    UserSession findByUserId(Long userId);
    UserSession createUserSession(Long userId);
}