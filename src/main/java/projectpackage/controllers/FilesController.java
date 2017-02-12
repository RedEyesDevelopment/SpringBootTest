package projectpackage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import projectpackage.service.FilesService;

/**
 * Created by Gvozd on 12.02.2017.
 */
@Controller
@RequestMapping(value = "/fileapi")
public class FilesController {

    @Autowired
    FilesService filesService;

    @RequestMapping("upload")
    public String fileUploadPAge() {
        return "fileupload";
    }
}
