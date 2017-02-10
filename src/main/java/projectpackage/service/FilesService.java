package projectpackage.service;

import org.springframework.data.domain.Page;
import projectpackage.model.Files.FileOnServer;

/**
 * Created by Admin on 10.02.2017.
 */
public interface FilesService {
    void save(FileOnServer file);
    FileOnServer findByFilename(String filename);
    FileOnServer findOne(Integer id);
    Page<FileOnServer> findAll(int startingCount, int endingCount, String sortingParameter, boolean ascend);

}
