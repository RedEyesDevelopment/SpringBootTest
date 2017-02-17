package projectpackage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectpackage.i18n.WebLocale;
import projectpackage.model.AuthEntities.UserSession;
import projectpackage.repositories.AuthRepositories.UserSessionRepository;

/**
 * Created by Lenovo on 17.02.2017.
 */
@Service
public class UserSessionServiceImpl implements UserSessionService {

    @Autowired
    UserSessionRepository userSessionRepository;

    @Override
    public UserSession findByUserId(Long userId) {
        return userSessionRepository.findByUserId(userId);
    }

    @Override
    public UserSession createUserSession(Long userId) {
        UserSession session = new UserSession();
        session.setUserId(userId);
        session.setLocale(WebLocale.ru);
        session.setFilesQuantity(10);
        session.setFilesOffset(1);
        session.setFilesSortParameter("uploadDate");
        session.setFilesAscend(true);
        return userSessionRepository.save(session);
    }
}
