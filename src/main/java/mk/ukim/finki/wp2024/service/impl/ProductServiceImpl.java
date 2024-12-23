package mk.ukim.finki.wp2024.service.impl;

import mk.ukim.finki.wp2024.model.Category;
import mk.ukim.finki.wp2024.model.Manufacturer;
import mk.ukim.finki.wp2024.model.Product;
import mk.ukim.finki.wp2024.model.exceptions.CategoryNotFoundException;
import mk.ukim.finki.wp2024.model.exceptions.ManufacturerNotFoundException;
import mk.ukim.finki.wp2024.model.exceptions.ProductNotFoundException;
import mk.ukim.finki.wp2024.repository.inmemory.InMemoryCategoryRepository;
import mk.ukim.finki.wp2024.repository.inmemory.InMemoryManufacturerRepository;
import mk.ukim.finki.wp2024.repository.inmemory.InMemoryProductRepository;

import mk.ukim.finki.wp2024.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static mk.ukim.finki.wp2024.service.specifications.FieldFilterSpecification.filterContainsText;
import static mk.ukim.finki.wp2024.service.specifications.FieldFilterSpecification.filterEquals;

@Service
public class ProductServiceImpl implements ProductService {
    private final InMemoryCategoryRepository categoryRepository;
    private final InMemoryProductRepository productRepository;
    private final InMemoryManufacturerRepository manufacturerRepository;

//    private final InMemoryCategoryRepository categoryRepository;

    public ProductServiceImpl(InMemoryProductRepository inMemoryProductRepository,
                              InMemoryManufacturerRepository manufacturerRepository,
                              InMemoryCategoryRepository categoryRepository) {
        this.productRepository = inMemoryProductRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Page<Product> findPage(String name, Long categoryId, Long manufacturerId, Integer pageNum, Integer pageSize) {
        return null;
    }

//    @Override
//    public Page<Product> findPage(String name, Long categoryId, Long manufacturerId, Integer pageNum, Integer pageSize) {
//        Specification<Product> specification = Specification
//                .where(filterContainsText(Product.class, "name", name))
//                .and(filterEquals(Product.class, "category.id", categoryId))
//                .and(filterEquals(Product.class, "manufacturer.id", manufacturerId));
//
//        return this.productRepository.findAll(
//                specification,
//                PageRequest.of(pageNum - 1, pageSize, Sort.by(Sort.Direction.DESC, "name"))
//        );
//    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return this.productRepository.findByName(name);
    }

    @Override
    public Optional<Product> save(String name, Double price, Integer quantity, Long categoryId, Long manufacturerId) {
          Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new CategoryNotFoundException(categoryId));

          Manufacturer manufacturer = this.manufacturerRepository.findById(manufacturerId).orElseThrow(
                  () -> new ManufacturerNotFoundException(manufacturerId));
          return this.productRepository.save(name,price,quantity,category,manufacturer);
//        Category category = categoryRepository.findById(categoryId)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));
//        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid manufacturer ID"));
//
//        Product product = new Product(name, price, quantity, category, manufacturer);
//       return this.productRepository.save(product);
    }




    @Override
    public Optional<Product> update(
            Long id,
            String name,
            Double price,
            Integer quantity,
            Long categoryId,
            Long manufacturerId
    ) {
        Product product = this.productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));
        Manufacturer manufacturer = this.manufacturerRepository.findById(manufacturerId)
                .orElseThrow(() -> new ManufacturerNotFoundException(manufacturerId));

        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setCategory(category);
        product.setManufacturer(manufacturer);

        return Optional.of(product);
    }

    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }
}

