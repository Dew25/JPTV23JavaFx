package ee.ivkhkdev.jptv23javafx.service;

import ee.ivkhkdev.jptv23javafx.model.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AppService<T>{
    Optional<T> add(T t);
    public List<T> loadAll();

}
