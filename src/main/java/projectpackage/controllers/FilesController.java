package projectpackage.controllers;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import projectpackage.model.AuthEntities.User;
import projectpackage.model.AuthEntities.UserSession;
import projectpackage.model.Files.FileOnServer;
import projectpackage.pagination.PagesCollection;
import projectpackage.service.FilesService;
import projectpackage.service.UserService;
import projectpackage.service.UserSessionService;
import projectpackage.support.PaginationTool;
import projectpackage.support.SessionTool;
import projectpackage.support.StringTool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by Gvozd on 12.02.2017.
 */
@Log4j
@Controller
@RequestMapping(value = "/fileapi/")
public class FilesController {

    @Autowired
    private FilesService filesService;

    @Autowired
    private UserService userService;

    @Autowired
    UserSessionService userSessionService;

    @RequestMapping("upload")
    public String fileUploadPage(Model model) {
        Boolean publicity = true;
        model.addAttribute("publicity", publicity);
        return "files/fileupload";
    }

    @RequestMapping(value="uploadfile", method = RequestMethod.POST)
    public String fileUploading(@RequestParam("file") MultipartFile file, @RequestParam(value="publicity", defaultValue = "false") Boolean publicity, @RequestParam("alternative") String alternative, HttpServletRequest request, HttpServletResponse response) {
        String name = null;

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                name = file.getOriginalFilename();

                StringBuilder rootPath = new StringBuilder(request.getServletContext().getRealPath("/").toString());
                rootPath.append("dynamic");
                System.out.println(rootPath.toString());
                File dir = new File(rootPath.toString() + File.separator);

                if (!dir.exists()) {
                    dir.mkdirs();
                }

                String extension;
                if (name.contains(".")) {
                    String[] nameParts = name.split("\\.");
                    int result = nameParts.length;
                    extension = nameParts[result-1];
                } else extension="file";

                File uploadedFile = new File(dir.getAbsolutePath() + File.separator + name);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                stream.write(bytes);
                stream.flush();
                stream.close();

                log.info("uploaded: " + uploadedFile.getAbsolutePath());

                String fileName;
                if (alternative!=null && !alternative.equals("")) {
                    fileName = alternative;
                } else fileName= uploadedFile.getName();

                Long userId = (Long) request.getSession().getAttribute("UserId");
                System.out.println(userId.toString());

                FileOnServer newFile = new FileOnServer();
                newFile.setFilename(uploadedFile.getName());
                newFile.setAlternative(fileName);
                newFile.setAuthor(userService.findOne(userId));
                newFile.setUploadDate(new Timestamp(System.currentTimeMillis()));
                newFile.setPublicity(publicity);
                newFile.setNotDeletable(false);
                newFile.setExtension(extension);
                filesService.save(newFile);

                UserSession userSession = SessionTool.getUserSessionParametersFromSession(request.getSession(), userService);
                StringBuilder stringBuilder = new StringBuilder("redirect:/fileapi/filelist?for=");
                stringBuilder.append(userSession.getFilesQuantity());
                stringBuilder.append("&show=0&sort=");
                stringBuilder.append(userSession.getFilesSortParameter());
                stringBuilder.append("&ascend=");
                stringBuilder.append(userSession.isFilesAscend());
                return stringBuilder.toString();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return "You failed to upload " + file.getOriginalFilename() + " because the file was empty.";
        }
        return "/error/404";
    }

    @RequestMapping(value="filelist", params = {"for", "show", "sort", "ascend"})
    public String fileListPage(@RequestParam(value = "for") Integer quantity, @RequestParam(value = "show") Integer offset, @RequestParam(value = "sort") String parameter, @RequestParam(value = "ascend") String ascendString, Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) {

        Long userId = (Long) request.getSession().getAttribute("UserId");
        User myself = userService.findOne(userId);
        Boolean ascend = Boolean.parseBoolean(ascendString);

        List<FileOnServer> filesList = filesService.findAllPublicityTrueOrUserIsAuthor(myself, offset, quantity, parameter, ascend);

        SessionTool.updateSessionWithFileParametersAndPassItToDatabase(request.getSession(), userSessionService, quantity, offset, parameter, ascend);

        PagesCollection filesPagesCollection = PaginationTool.getFilesPageCollection(filesService.count(), quantity, offset, parameter, ascend);

        map.put("digitMatch", StringTool.getMatcher("\\d+"));
        map.put("pagesCollection", filesPagesCollection);
        map.put("filesList", filesList);
        map.put("offset", offset);
        map.put("sortingParameter", parameter);
        map.put("ascendParameter", ascend);
        return "files/filelistPage";
    }

    @RequestMapping("search")
    public String fileSearchResultPage(String searchString, Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) {
        List<FileOnServer> fileOnServers = filesService.findByAlternativeLike(searchString);

        UserSession userSession = SessionTool.getUserSessionParametersFromSession(request.getSession(), userService);
        map.put("filesList", fileOnServers);
        map.put("sort", userSession.getFilesSortParameter());
        map.put("quantity", userSession.getFilesQuantity());
        map.put("ascend", userSession.isFilesAscend());
        return "files/filesearch";
    }

//    @RequestMapping("uploadedFileProperties")
//    public String fileAfterUploadPAge() {
//        return "fileproperties";
//    }
}