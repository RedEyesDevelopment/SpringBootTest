package tests.database;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import projectpackage.model.AuthEntities.Role;
import projectpackage.model.AuthEntities.User;
import projectpackage.model.Files.FileOnServer;
import projectpackage.repositories.AuthRepositories.RolesRepository;
import projectpackage.repositories.FilesRepositories.CustomFilesRepository;
import projectpackage.repositories.InternationalizationRepositories.InterMessageRepository;
import projectpackage.service.FilesService;
import projectpackage.service.UserService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Gvozd on 06.01.2017.
 */
@Transactional
public class RepositoryTests extends AbstractDatabaseTest {

    @Autowired
    UserService userService;

    @Autowired
    InterMessageRepository interMessageRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    FilesService filesService;

    @Autowired
    CustomFilesRepository customFilesRepository;

    @Test
    @Rollback(true)
    public void getUser(){
        System.out.println(userService.toString());
        System.out.println("****************************************************************");
        System.out.println(userService.findOne(2L).toString());
        System.out.println("****************************************************************");
    }

    @Test
    @Rollback(true)
    public void getUserByLogin(){
        System.out.println(userService.toString());
        System.out.println("****************************************************************");
        User user = userService.findByUsername("qwerty");
        System.out.println(user.toString());
        System.out.println("****************************************************************");
    }

    @Test
    @Rollback(true)
    public void getUserList(){
        System.out.println(userService.toString());
        System.out.println("****************************************************************");
        for (User user:userService.findAll()){
            System.out.println(user.toString());
        }
        System.out.println("****************************************************************");
    }

    @Test
    @Rollback(true)
    public void createUser(){
        System.out.println(userService.toString());
        System.out.println("****************************************************************");
        User user = new User();
        user.setFullname("QuackUser");
        user.setUsername("quack");
        user.setPassword("quack");
        user.setEnabled(true);
        Role role = rolesRepository.findOne(2);
        Set<Role> newRolesSet = new HashSet<Role>();
        newRolesSet.add(role);
        user.setRoles(newRolesSet);
        userService.save(user);
        System.out.println(user);
        System.out.println("****************************************************************");

    }

    @Test
    @Rollback(true)
    public void getMessage(){
        System.out.println(interMessageRepository.toString());
        System.out.println("****************************************************************");
        System.out.println(interMessageRepository.findOne(1).toString());
        System.out.println("****************************************************************");

    }

    @Test
    @Rollback(true)
    public void getFile(){
        System.out.println(filesService.toString());
        System.out.println("****************************************************************");
        System.out.println(filesService.findOne(2).toString());
        System.out.println("****************************************************************");
    }

    @Test
    @Rollback(true)
    public void getFilePageableList(){
        System.out.println(filesService.toString());
        System.out.println("****************************************************************");
        for (FileOnServer file:filesService.findAll(0,10, "alternative", true)){
            System.out.println(file.toString());
        }
        System.out.println("****************************************************************");
    }

    @Test
    @Rollback(true)
    public void getFilePageableListFromCustomRepository(){
        System.out.println(customFilesRepository.toString());
        System.out.println("****************************************************************");
        User user = userService.findOne(2L);
        for (FileOnServer file:customFilesRepository.findAllPublicityTrueOrUserIsAuthor(user,1,5,"uploadDate",true)){
            System.out.println(file.toString());
        }
        System.out.println("****************************************************************");
    }
}