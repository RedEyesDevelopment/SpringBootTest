package projectpackage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import projectpackage.model.Files.FileOnServer;
import projectpackage.repositories.FilesRepositories.FilesRepository;
import projectpackage.support.SortingTool;

import java.util.List;

/**
 * Created by Admin on 10.02.2017.
 */
public class FilesServiceImpl implements FilesService {

    @Autowired
    FilesRepository filesRepository;

    @Override
    public void save(FileOnServer file) {
        filesRepository.save(file);
    }

    @Override
    public FileOnServer findByFilename(String filename) {
        return filesRepository.findByFilname(filename);
    }

    @Override
    public FileOnServer findOne(Long id) {
        return filesRepository.findOne(id);
    }

    public Page<FileOnServer> findAll(int startingCount, int endingCount, String sortingParameter, boolean ascend){
        return filesRepository.findAll(new PageRequest(startingCount, endingCount, SortingTool.getSort(sortingParameter, ascend)));
    }


}
