package projectpackage.support;

import org.springframework.stereotype.Service;
import projectpackage.model.AuthEntities.User;
import projectpackage.model.AuthEntities.UserSession;
import projectpackage.model.Files.FileOnServer;
import projectpackage.model.support.FilespageParameters;
import projectpackage.service.UserService;
import projectpackage.service.UserSessionService;

import javax.servlet.http.HttpSession;

/**
 * Created by Lenovo on 16.02.2017.
 */
@Service
public class SessionTool {

    //    Заполнить объект сессии параметрами из UserSession
    public static void fillSessionWithUserParameters(HttpSession httpSession, UserSession userSession, boolean justLoggedIn) {
        httpSession.setAttribute("UserId", userSession.getUserId());
        httpSession.setAttribute("Username", userSession.getUsername());
        httpSession.setAttribute("Fullname", userSession.getFullname());
        httpSession.setAttribute("filesQuantity", userSession.getFilesQuantity());
        httpSession.setAttribute("filesSortParameter", userSession.getFilesSortParameter());
        httpSession.setAttribute("filesAscend", userSession.isFilesAscend());
        httpSession.setAttribute("userLocale", userSession.getLocale());
        if (justLoggedIn) httpSession.setAttribute("filesOffset", 0);

    }

    // Получить объект UserSession из HttpSession
    public static UserSession getUserSessionParametersFromSession(HttpSession session, UserService userService) {
        UserSession userSession = new UserSession();

        Long userId = (Long) session.getAttribute("UserId");
        if (null == userId) {
            return null;
        }

        User user = userService.findOne(userId);
        userSession.setUsername(user.getUsername());
        userSession.setFullname(user.getFullname());

        if (session.getAttribute("UserId").getClass().isInstance(Long.class)) {
            userSession.setUserId((Long) session.getAttribute("UserId"));
        } else userSession.setUserId(0);

        if (session.getAttribute("Username").getClass().isInstance(String.class)) {
            userSession.setUsername((String) session.getAttribute("Username"));
        } else userSession.setUsername("Anonymous");

        if (session.getAttribute("Fullname").getClass().isInstance(String.class)) {
            userSession.setFullname((String) session.getAttribute("Fullname"));
        } else userSession.setFullname("Anonymous");

        if (session.getAttribute("filesQuantity").getClass().isInstance(Integer.class)) {
            userSession.setFilesQuantity((Integer) session.getAttribute("filesQuantity"));
        } else userSession.setFilesQuantity(FileOnServer.DEFAULTSHOWQUANTITY);

        if (session.getAttribute("filesSortParameter").getClass().isInstance(String.class)) {
            userSession.setFilesSortParameter((String) session.getAttribute("filesSortParameter"));
        } else userSession.setFilesSortParameter("uploadDate");

        if (session.getAttribute("filesAscend").getClass().isInstance(Boolean.class)) {
            userSession.setFilesAscend((Boolean) session.getAttribute("filesAscend"));
        } else userSession.setFilesAscend(true);

        if (session.getAttribute("userLocale").getClass().isInstance(String.class)) {
            userSession.setLocale((String) session.getAttribute("userLocale"));
        } else userSession.setLocale("ru");

        return userSession;
    }

    // Обновить параметры в сессии и обновить в БД объект UserSession
    public static void updateSessionWithFileParametersAndPassItToDatabase(HttpSession httpSession, UserSessionService userSessionService, Integer newQuantity, Integer newOffset, String newSortingParameter, Boolean newAscendOrder) {
        Boolean sessionNeedsUpdate = false;
        UserSession userSession = userSessionService.findByUserId((Long) httpSession.getAttribute("UserId"));

        if (!httpSession.getAttribute("filesQuantity").equals(newQuantity)) {
            httpSession.setAttribute("filesQuantity", newQuantity);
            userSession.setFilesQuantity(newQuantity);
            sessionNeedsUpdate = true;
        }

        if (!httpSession.getAttribute("filesOffset").equals(newOffset)) {
            httpSession.setAttribute("filesOffset", newOffset);
            sessionNeedsUpdate = true;
        }

        if (!httpSession.getAttribute("filesSortParameter").equals(newSortingParameter)) {
            httpSession.setAttribute("filesSortParameter", newSortingParameter);
            if (userSession == null) {
                userSession = userSessionService.findByUserId((Long) httpSession.getAttribute("UserId"));
            }
            userSession.setFilesSortParameter(newSortingParameter);
            sessionNeedsUpdate = true;
        }

        if (!httpSession.getAttribute("filesAscend").equals(newAscendOrder)) {
            httpSession.setAttribute("filesAscend", newAscendOrder);
            if (userSession == null) {
                userSession = userSessionService.findByUserId((Long) httpSession.getAttribute("UserId"));
            }
            userSession.setFilesAscend(newAscendOrder);
            sessionNeedsUpdate = true;
        }

        if (sessionNeedsUpdate) {
            userSessionService.save(userSession);
        }
    }

    public static FilespageParameters getFilespageParameters(HttpSession session){
        FilespageParameters filespageParameters = new FilespageParameters();
        int quantity = (null!=session.getAttribute("filesQuantity"))? (int) session.getAttribute("filesQuantity"): 5;
        int offset = (null!=session.getAttribute("filesOffset"))? (int) session.getAttribute("filesOffset"): 0;
        String sort = (null!=session.getAttribute("filesSortParameter"))? (String) session.getAttribute("filesSortParameter"): "alternative";
        boolean ascend = (null!=session.getAttribute("filesAscend"))? (Boolean) session.getAttribute("filesAscend"): true;
        filespageParameters.setQuantity(quantity);
        filespageParameters.setOffset(offset);
        filespageParameters.setSort(sort);
        filespageParameters.setAscend(ascend);
        return filespageParameters;
    }
}
