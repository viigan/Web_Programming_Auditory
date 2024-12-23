package mk.ukim.finki.wp2024.service;

import mk.ukim.finki.wp2024.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> listCategories();

    List<Category> findAll();

    Optional<Boolean> create(String name, String description);

    Optional<Boolean> update(Long id, String name, String description);

    void delete(String name);

    void deleteById(Long id);

    List<Category> searchCategories(String text);

    Optional<Category> findById(Long id);
}
