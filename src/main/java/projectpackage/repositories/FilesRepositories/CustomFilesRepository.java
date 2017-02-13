package projectpackage.repositories.FilesRepositories;

import projectpackage.model.AuthEntities.User;
import projectpackage.model.Files.FileOnServer;

import java.util.List;

/**
 * Created by Lenovo on 13.02.2017.
 */
public interface CustomFilesRepository {
    List<FileOnServer> findAllPublicityTrueOrUserIsAuthor(User user, int startingCount, int offset, String sortingParameter, boolean ascend);
}
