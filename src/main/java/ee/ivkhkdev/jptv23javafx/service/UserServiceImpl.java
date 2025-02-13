package ee.ivkhkdev.jptv23javafx.service;

import ee.ivkhkdev.jptv23javafx.Jptv23JavaFxApplication;
import ee.ivkhkdev.jptv23javafx.model.entity.AppUser;
import ee.ivkhkdev.jptv23javafx.model.repository.AppUserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private final AppUserRepository appUserRepository;

    public UserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }
    @Override
    public boolean add(AppUser user) {
        Optional<AppUser> optionalAppUser = Optional.of(appUserRepository.save(user));
        if(optionalAppUser.isEmpty()){
            return false;
        }
        return true;
    }

    @Override
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
