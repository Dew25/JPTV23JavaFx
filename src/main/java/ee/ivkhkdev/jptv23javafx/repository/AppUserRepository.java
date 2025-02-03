package ee.ivkhkdev.jptv23javafx.repository;

import ee.ivkhkdev.jptv23javafx.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
