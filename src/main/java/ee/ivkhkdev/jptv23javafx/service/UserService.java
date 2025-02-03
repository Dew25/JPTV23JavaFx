package ee.ivkhkdev.jptv23javafx.service;

import ee.ivkhkdev.jptv23javafx.model.entity.AppUser;
import ee.ivkhkdev.jptv23javafx.repository.AppUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final AppUserRepository appUserRepository;
    public UserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }
    public AppUser add(String firstname,String lastname, String username, String password) {
        AppUser user = new AppUser(firstname,lastname,username,password,"USER");
        return appUserRepository.save(user);
    }
}
