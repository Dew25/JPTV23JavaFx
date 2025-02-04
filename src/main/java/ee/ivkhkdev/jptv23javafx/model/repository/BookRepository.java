package ee.ivkhkdev.jptv23javafx.model.repository;

import ee.ivkhkdev.jptv23javafx.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
