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
        String order;
        if (ascend) {
            order="asc";
        } else order="desc";

        StringBuilder hql = new StringBuilder("SELECT f from FileOnServer f WHERE f.publicity = true or f.author = :author ORDER BY f.");
        hql.append(sortingParameter);
        hql.append(" ");
        hql.append(order);

        TypedQuery query = entityManagerFactory.createEntityManager().createQuery(hql.toString(), FileOnServer.class);
        query.setParameter("author", user);
        query.setFirstResult(startingCount);
        query.setMaxResults(offset);
        return query.getResultList();
    }
}
