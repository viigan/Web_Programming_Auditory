//package mk.ukim.finki.wp2024.repository.inmemory;
//
//import mk.ukim.finki.wp2024.bootstrap.DataHolder;
//import mk.ukim.finki.wp2024.model.Category;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//// Repository for handling the in-memory storage of categories
//@Repository
//public class InMemoryCategoryRepository {
//    public Optional<Category> save(Category category) {
//        // If the category already exists, remove it and add the new one
//        DataHolder.categories.removeIf(c -> c.getName().equals(category.getName()));
//        DataHolder.categories.add(category);
//        return Optional.of(category);
//    }
//
//    public List<Category> findAll() {
//        return DataHolder.categories;
//    }
//
//    public Optional<Category> findByName(String name) {
//        return DataHolder.categories.stream()
//                .filter(c -> c.getName().equals(name))
//                .findFirst();
//    }
//
//    public List<Category> search(String text) {
//        return DataHolder.categories.stream()
//                .filter(c -> c.getName().contains(text) ||
//                        c.getDescription().contains(text))
//                .toList();
//    }
//
//    public void delete(String name) {
//        DataHolder.categories.removeIf(c -> c.getName().equals(name));
//    }
//
//    public void deleteById(Long id) {
//        DataHolder.categories.removeIf(i -> i.getId().equals(id));
//    }
//
//    public Optional<Category> findById(Long id) {
//        return DataHolder.categories.stream().filter(i -> i.getId().equals(id)).findFirst();
//    }
//}
package mk.ukim.finki.wp2024.repository.inmemory;

import mk.ukim.finki.wp2024.bootstrap.DataHolder;
import mk.ukim.finki.wp2024.model.Category;
import mk.ukim.finki.wp2024.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryCategoryRepository{
    public Optional<Category>findByName(String name){
        return DataHolder.categories.stream().filter(c->c.getName().equals(name)).findFirst();
    }
    public Optional<Category>findById(Long id){
        return DataHolder.categories.stream().filter(c->c.getId().equals(id)).findFirst();
    }
    public List<Category> search(String text){
        return DataHolder.categories.stream().filter(c->c.getName().contains(text) || c.getDescription().contains(text)).toList();
    }

    public List<Category> findAllByNameLike(String text){
        return DataHolder.categories.stream().filter(c->c.getName().contains(text) || c.getDescription().contains(text)).toList();
    }
    public Optional<Category>  save(String name, String description){

        DataHolder.categories.removeIf(p->p.getName().equals(name));
        Category category = new Category( name,description);
        findAll().add(category);
        return Optional.of(category);
    }


    public List<Category> findAll() {
        return DataHolder.categories;
    }

    public List<Category>deleteByName(String name) {
        List<Category>newList=new ArrayList<>();
        newList = DataHolder.categories;
        newList.removeIf(i->i.getName().equals(name));
        return newList;
    }

    public boolean save(Category category) {
        findAll().removeIf(c->c.getName().equals(category.getName()));
        return findAll().add(category);
    }

    public List<Category> deleteById(Long id) {
        List<Category>newList=new ArrayList<>();
        newList = DataHolder.categories;
        newList.removeIf(i->i.getId().equals(id));
        return newList;
    }

    public void saveAll(List<Category> list) {
        DataHolder.categories=list;
    }
}
