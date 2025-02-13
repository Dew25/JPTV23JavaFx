package ee.ivkhkdev.jptv23javafx.service;
import ee.ivkhkdev.jptv23javafx.model.entity.AppUser;
public interface UserService {
    boolean add(AppUser user);
    boolean authenticate(String username, String password);
}
