package projectpackage.repositories.FilesRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import projectpackage.model.AuthEntities.User;
import projectpackage.model.Files.FileOnServer;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Lenovo on 13.02.2017.
 */
@Repository
public class CustomFilesRepositoryImpl implements CustomFilesRepository {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public List<FileOnServer> findAllPublicityTrueOrUserIsAuthor(User user, int startingCount, int offset, String sortingParameter, boolean ascend) {
        TypedQuery query = entityManagerFactory.createEntityManager().createQuery("select f from FileOnServer f where f.publicity = true or f.author = ?1 order by ?2", FileOnServer.class);
        query.setParameter(1, user);
        query.setParameter(2, sortingParameter);
        query.setFirstResult(startingCount);
        query.setMaxResults(offset);
        return query.getResultList();
    }
}
