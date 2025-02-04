package ee.ivkhkdev.jptv23javafx.model.repository;

import ee.ivkhkdev.jptv23javafx.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
