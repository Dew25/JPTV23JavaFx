package ee.ivkhkdev.jptv23javafx.service;
import ee.ivkhkdev.jptv23javafx.model.entity.AppUser;


public interface UserService extends AppService<AppUser> {
    void initSuperAdmin();
    boolean authenticate(String username, String password);
}
