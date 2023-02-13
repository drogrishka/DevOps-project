package mk.ukim.finki.wpvezbi.repository.impl;

import mk.ukim.finki.wpvezbi.bootstrap.DataHolder;
import mk.ukim.finki.wpvezbi.model.Category;
import mk.ukim.finki.wpvezbi.model.Manufacturer;
import mk.ukim.finki.wpvezbi.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryProductRepository {

    public List<Product> findAll(){
        return DataHolder.products;
    }

    public Optional<Product> findById(Long id){
        return DataHolder.products.stream().filter(i->i.getId().equals(id)).findFirst();
    }
    public Optional<Product> findByName(String name){
        return DataHolder.products.stream().filter(i->i.getName().equals(name)).findFirst();
    }
    public Optional<Product> save(String name, double price, int quantity, Category category, Manufacturer manufacturer){
        DataHolder.products.removeIf(i->i.getName().equals(name));
        Product product=new Product(name,price,quantity,category,manufacturer);
        DataHolder.products.add(product);
        return Optional.of(product);

    }
    public void deleteById(Long id){
        DataHolder.products.removeIf(i->i.getId().equals(id));
    }
}
