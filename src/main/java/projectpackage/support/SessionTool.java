package projectpackage.support;

import org.springframework.stereotype.Service;
import projectpackage.i18n.WebLocale;
import projectpackage.model.AuthEntities.User;
import projectpackage.model.AuthEntities.UserSession;
import projectpackage.model.Files.FileOnServer;
import projectpackage.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * Created by Lenovo on 16.02.2017.
 */
@Service
public class SessionTool {

    public static void fillSessionWithUserParameters(HttpSession httpSession, UserSession userSession){
        httpSession.setAttribute("UserId", userSession.getUserId());
        httpSession.setAttribute("Username", userSession.getUsername());
        httpSession.setAttribute("Fullname", userSession.getFullname());
        httpSession.setAttribute("filesQuantity", userSession.getFilesQuantity());
        httpSession.setAttribute("filesOffset", userSession.getFilesOffset());
        httpSession.setAttribute("filesSortParameter", userSession.getFilesSortParameter());
        httpSession.setAttribute("filesAscend", userSession.isFilesAscend());
        httpSession.setAttribute("userLocale",userSession.getLocale());
    }

    public static UserSession getUserSessionParametersFromSession(HttpSession session, UserService userService){
        UserSession userSession = new UserSession();
        User user = userService.findOne((Long) session.getAttribute("UserId"));
        userSession.setUsername(user.getUsername());
        userSession.setFullname(user.getFullname());

        if (session.getAttribute("UserId").getClass().isInstance(Long.class)){
            userSession.setUserId((Long) session.getAttribute("UserId"));
        } else userSession.setUserId(0);

        if (session.getAttribute("Username").getClass().isInstance(String.class)){
            userSession.setUsername((String) session.getAttribute("Username"));
        } else userSession.setUsername("Anonymous");

        if (session.getAttribute("Fullname").getClass().isInstance(String.class)){
            userSession.setFullname((String) session.getAttribute("Fullname"));
        } else userSession.setFullname("Anonymous");

        if (session.getAttribute("filesQuantity").getClass().isInstance(Integer.class)){
            userSession.setFilesQuantity((Integer) session.getAttribute("filesQuantity"));
        } else userSession.setFilesQuantity(FileOnServer.DEFAULTSHOWQUANTITY);

        if (session.getAttribute("filesOffset").getClass().isInstance(Integer.class)){
            userSession.setFilesOffset((Integer) session.getAttribute("filesOffset"));
        } else userSession.setFilesOffset(1);

        if (session.getAttribute("filesSortParameter").getClass().isInstance(String.class)){
            userSession.setFilesSortParameter((String) session.getAttribute("filesSortParameter"));
        } else userSession.setFilesSortParameter("uploadDate");

        if (session.getAttribute("filesAscend").getClass().isInstance(Boolean.class)){
            userSession.setFilesAscend((Boolean) session.getAttribute("filesAscend"));
        } else userSession.setFilesAscend(true);

        if (session.getAttribute("userLocale").getClass().isInstance(WebLocale.class)){
            userSession.setLocale((WebLocale) session.getAttribute("userLocale"));
        } else userSession.setLocale(WebLocale.ru);

        return userSession;
    }
}
