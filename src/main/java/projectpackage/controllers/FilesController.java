package projectpackage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import projectpackage.service.FilesService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Gvozd on 12.02.2017.
 */
@Controller
@RequestMapping(value = "/fileapi")
public class FilesController {

    @Autowired
    FilesService filesService;

    @RequestMapping("upload")
    public String fileUploadPage() {
        return "fileupload";
    }

    @RequestMapping(value="doUpload", method = RequestMethod.POST)
    public String fileUploading(@RequestParam("file") MultipartFile file, String publicity, String alternative, HttpServletRequest request, HttpServletResponse response) {
        return "fileupload";
    }

    @RequestMapping("uploadedFileProperties")
    public String fileAfterUploadPAge() {
        return "fileproperties";
    }
}
