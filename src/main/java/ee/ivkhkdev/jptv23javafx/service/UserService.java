package ee.ivkhkdev.jptv23javafx.service;

import ee.ivkhkdev.jptv23javafx.Jptv23JavaFxApplication;
import ee.ivkhkdev.jptv23javafx.model.entity.AppUser;
import ee.ivkhkdev.jptv23javafx.model.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    public enum ROLES {USER,MANAGER,ADMINISTRATOR};
    private final AppUserRepository appUserRepository;

    public UserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public boolean add(String firstname,String lastname, String username, String password) {
        AppUser user = new AppUser(firstname,lastname,username,password,ROLES.USER.toString());
        Optional<AppUser> optionalAppUser = Optional.of(appUserRepository.save(user));
        if(optionalAppUser.isEmpty()){
            return false;
        }
        return true;
    }

    public boolean authenticate(String username, String password) {
        Optional<AppUser> optionalAppUser = appUserRepository.findByUsername(username);
        if (optionalAppUser.isEmpty()) {
            return false;
        }
        AppUser appUser = optionalAppUser.get();
        if (!appUser.getPassword().equals(password)) {
            return false;
        }
        Jptv23JavaFxApplication.currentUser = appUser;
        return true;
    }
}
