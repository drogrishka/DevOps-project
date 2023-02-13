package mk.ukim.finki.wpvezbi.service.impl;

import mk.ukim.finki.wpvezbi.model.Category;
import mk.ukim.finki.wpvezbi.model.Manufacturer;
import mk.ukim.finki.wpvezbi.model.Product;
import mk.ukim.finki.wpvezbi.model.exceptions.CategoryNotFoundException;
import mk.ukim.finki.wpvezbi.model.exceptions.ManufacturerNotFound;
import mk.ukim.finki.wpvezbi.model.exceptions.ProductNotFoundException;
import mk.ukim.finki.wpvezbi.repository.impl.InMemoryCategoryRepository;
import mk.ukim.finki.wpvezbi.repository.impl.InMemoryManufacturerRepository;
import mk.ukim.finki.wpvezbi.repository.impl.InMemoryProductRepository;
import mk.ukim.finki.wpvezbi.repository.jpa.CategoryRepository;
import mk.ukim.finki.wpvezbi.repository.jpa.ManufacturerRepository;
import mk.ukim.finki.wpvezbi.repository.jpa.ProductRepository;
import mk.ukim.finki.wpvezbi.service.ProductService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ManufacturerRepository manufacturerRepository;

    public ProductServiceImpl(ProductRepository productRepository,CategoryRepository categoryRepository,ManufacturerRepository manufacturerRepository) {
        this.productRepository = productRepository;
        this.categoryRepository=categoryRepository;
        this.manufacturerRepository=manufacturerRepository;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return this.productRepository.findByName(name);
    }

    @Override
    @Transactional
    public Optional<Product> save(String name, Double price, Integer quantity, Long categoryId, Long manufacturerId) {
        Category category=this.categoryRepository.findById(categoryId).orElseThrow(()->new CategoryNotFoundException(categoryId));
        Manufacturer manufacturer=this.manufacturerRepository.findById(manufacturerId).orElseThrow(()->new ManufacturerNotFound(manufacturerId));
        this.productRepository.deleteByName(name);

        return Optional.of(this.productRepository.save(new Product(name,price,quantity,category,manufacturer)));

    }

    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> edit(Long id, String name, Double price, Integer quantity, Long categoryId, Long manufacturerId) {
        Product product = this.productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);

        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));
        product.setCategory(category);

        Manufacturer manufacturer = this.manufacturerRepository.findById(manufacturerId)
                .orElseThrow(() -> new ManufacturerNotFound(manufacturerId));
        product.setManufacturer(manufacturer);

        return Optional.of(this.productRepository.save(product));

    }
}
