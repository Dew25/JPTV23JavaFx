package ee.ivkhkdev.jptv23javafx.service;

import ee.ivkhkdev.jptv23javafx.Jptv23JavaFxApplication;
import ee.ivkhkdev.jptv23javafx.model.entity.AppUser;
import ee.ivkhkdev.jptv23javafx.model.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private final AppUserRepository appUserRepository;

    public UserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
        initSuperAdmin();
    }
    public void initSuperAdmin(){
        if(appUserRepository.count() > 0){
            return;
        }
        AppUser admin = new AppUser();
        admin.setUsername("admin");
        admin.setPassword("12345");
        admin.setFirstname("Admin");
        admin.setLastname("Superadmin");
        admin.getRoles().add(Jptv23JavaFxApplication.ROLES.ADMINISTRATOR.toString());
        admin.getRoles().add(Jptv23JavaFxApplication.ROLES.MANAGER.toString());
        admin.getRoles().add(Jptv23JavaFxApplication.ROLES.USER.toString());
        appUserRepository.save(admin);
    }
    @Override
    public Optional<AppUser> add(AppUser user) {
        return Optional.of(appUserRepository.save(user));
    }

    @Override
    public List<AppUser> loadAll() {
        return appUserRepository.findAll();
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
