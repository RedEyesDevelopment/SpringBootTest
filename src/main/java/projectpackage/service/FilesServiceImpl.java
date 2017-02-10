package projectpackage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import projectpackage.model.Files.FileOnServer;
import projectpackage.repositories.FilesRepositories.FilesRepository;
import projectpackage.support.SortingTool;

/**
 * Created by Admin on 10.02.2017.
 */
@Service
public class FilesServiceImpl implements FilesService {

    @Autowired
    FilesRepository filesRepository;

    @Override
    public void save(FileOnServer file) {
        filesRepository.save(file);
    }

    @Override
    public FileOnServer findByFilename(String filename) {
        return filesRepository.findByFilename(filename);
    }

    @Override
    public FileOnServer findOne(Integer id) {
        return filesRepository.findOne(id);
    }

    public Page<FileOnServer> findAll(int startingCount, int endingCount, String sortingParameter, boolean ascend){
        return filesRepository.findAll(new PageRequest(startingCount, endingCount, SortingTool.getSort(sortingParameter, ascend)));
    }


}
