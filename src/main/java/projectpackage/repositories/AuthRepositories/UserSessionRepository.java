package projectpackage.repositories.AuthRepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import projectpackage.model.AuthEntities.UserSession;

/**
 * Created by Lenovo on 17.02.2017.
 */
@Repository
public interface UserSessionRepository extends CrudRepository<UserSession, Long> {
    UserSession findByUserId(Long userId);
}
