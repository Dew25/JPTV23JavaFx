package ee.ivkhkdev.jptv23javafx.service;

public interface UserService {
    boolean add(String firstname,String lastname, String username, String password);
    boolean authenticate(String username, String password);
}
