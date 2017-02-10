package projectpackage.service;

import projectpackage.model.Files.FileOnServer;

/**
 * Created by Admin on 10.02.2017.
 */
public interface FilesService {
    void save(FileOnServer file);
    FileOnServer findByFilename(String filename);
    FileOnServer findOne(Long id);

}
