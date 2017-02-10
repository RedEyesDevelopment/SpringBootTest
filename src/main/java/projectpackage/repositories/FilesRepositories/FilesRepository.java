package projectpackage.repositories.FilesRepositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import projectpackage.model.Files.FileOnServer;

/**
 * Created by Admin on 10.02.2017.
 */
@Repository
public interface FilesRepository extends PagingAndSortingRepository<FileOnServer, Integer>{
    FileOnServer findByFilename(String filename);
}
