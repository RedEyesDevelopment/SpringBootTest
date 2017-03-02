package projectpackage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import projectpackage.model.AuthEntities.UserSession;
import projectpackage.service.UserService;
import projectpackage.service.UserSessionService;
import projectpackage.support.SessionTool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Lenovo on 02.03.2017.
 */
@Controller
@RequestMapping(value = "/localeapi/")
public class LocalesController {

    @Value("${server.defaultLocale}")
    private String defaultLocale;

    @Autowired
    UserSessionService userSessionService;

    @Autowired
    private UserService userService;

    @Autowired
    LocaleResolver localeResolver;

    @RequestMapping(value = "/change={localeName}")
    public String selectMyIdea(@PathVariable("localeName") String localeName, Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) {

        System.out.println("stringparameter: "+localeName);

        String previouspage = request.getHeader("Referer");
        if (null==previouspage){
            previouspage="index";
        }

        if (null==localeName || (!localeName.equals("ru") || (!localeName.equals("en")))){
            localeName= defaultLocale;
        }

        Locale locale = new Locale.Builder().setLanguage(localeName).setRegion(localeName).build();
        localeResolver.setLocale(request,response,locale);
        UserSession userSession = SessionTool.getUserSessionParametersFromSession(request.getSession(),userService);

        if (null!=userSession){
            userSession.setLocale(localeName);
            userSessionService.save(userSession);
        }

        System.out.println("previouspage is "+previouspage);
        return "redirect:/"+previouspage;
    }

}
