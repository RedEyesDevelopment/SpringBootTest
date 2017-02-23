package projectpackage.repositories.FilesRepositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import projectpackage.model.Files.FileOnServer;

import java.util.List;

/**
 * Created by Admin on 10.02.2017.
 */
@Repository
public interface FilesRepository extends PagingAndSortingRepository<FileOnServer, Integer>{
    List<FileOnServer> findByAlternativeContaining(String searchable);
}