package projectpackage.support;

import projectpackage.model.AuthEntities.User;
import projectpackage.model.AuthEntities.UserSession;

import javax.servlet.http.HttpSession;

/**
 * Created by Lenovo on 16.02.2017.
 */
public class SessionTool {

    public static void fillSessionWithUserSessionInfo(HttpSession httpSession, User user, UserSession userSession){
        httpSession.setAttribute("UserId", user.getId());
        httpSession.setAttribute("Username", user.getUsername());
        httpSession.setAttribute("Fullname", user.getFullname());
        httpSession.setAttribute("filesQuantity", userSession.getFilesQuantity());
        httpSession.setAttribute("filesOffset", userSession.getFilesOffset());
        httpSession.setAttribute("filesSortParameter", userSession.getFilesSortParameter());
        httpSession.setAttribute("filesAscend", userSession.isFilesAscend());
        httpSession.setAttribute("userLocale",userSession.getLocale());
    }
}
