package mk.ukim.finki.wpvezbi.repository.jpa;

import mk.ukim.finki.wpvezbi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
 Optional<Product>findByName(String name);
 void deleteByName(String name);
}
