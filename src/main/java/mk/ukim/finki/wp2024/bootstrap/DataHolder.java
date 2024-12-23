package mk.ukim.finki.wp2024.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp2024.model.*;
//import mk.ukim.finki.wp2024.repository.jpa.CategoryRepository;
//import mk.ukim.finki.wp2024.repository.jpa.ManufacturerRepository;
//import mk.ukim.finki.wp2024.repository.jpa.UserRepository;
import mk.ukim.finki.wp2024.repository.inmemory.InMemoryCategoryRepository;
import mk.ukim.finki.wp2024.repository.inmemory.InMemoryManufacturerRepository;
import mk.ukim.finki.wp2024.repository.inmemory.InMemoryUserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// In-memory data holder
@Component
public class DataHolder {
    public static List<Category> categories = null;
    public static List<Manufacturer> manufacturers = null;
    public static List<Product> products = null;
    public static List<User> users = null;
    public static List<ShoppingCart> shoppingCarts = null;

    private final InMemoryCategoryRepository categoryRepository;
    private final InMemoryUserRepository userRepository;
    private final InMemoryManufacturerRepository
            manufacturerRepository;

    public DataHolder(InMemoryCategoryRepository categoryRepository, InMemoryUserRepository userRepository, InMemoryManufacturerRepository manufacturerRepository) {
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.manufacturerRepository = manufacturerRepository;
    }


    // On application startup, initialize the categories list
    // On each startup, the list will be initialized with the same values and the previous values will be lost
    @PostConstruct
    public void init() {
        categories = new ArrayList<>();
        if (this.categoryRepository.findAll().isEmpty()) {
            categories.add(new Category("Sports", "Sports category"));
            categories.add(new Category("Food", "Food category"));
            categories.add(new Category("Books", "Books category"));
            this.categoryRepository.saveAll(categories);
        }

        users = new ArrayList<>();
        if (this.userRepository.findAll().isEmpty()) {
            users.add(new User("elena.atanasoska", "ea", "Elena", "Atanasoska"));
            users.add(new User("darko.sasanski", "ds", "Darko", "Sasanski"));
            users.add(new User("ana.todorovska", "at", "Ana", "Todorovska"));
            users.add(new User("vigan", "vigan", "Vigan", "Demiri"));


            this.userRepository.saveAll(users);
        }

        manufacturers = new ArrayList<>();
        if (this.manufacturerRepository.findall().isEmpty() ) {
            manufacturers.add(new Manufacturer("Nike", "USA"));
            manufacturers.add(new Manufacturer("Coca Cola", "USA"));
            manufacturers.add(new Manufacturer("Literatura", "MK"));
            this.manufacturerRepository.saveAll(manufacturers);
        }
        Manufacturer manufacturer = new Manufacturer("Puma", "GERMANY");
        Category category = new Category("Sport", "Sport category");

        products= new ArrayList<>();
        products.add(new Product("Ball",235.8,7,category,manufacturer));
        products.add(new Product("Ball",235.8,7,category,manufacturer));
        products.add(new Product("Ball",235.8,7,category,manufacturer));

        shoppingCarts = new ArrayList<>();
    }
}
