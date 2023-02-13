package mk.ukim.finki.wpvezbi.repository.jpa;

import mk.ukim.finki.wpvezbi.model.ShoppingCart;
import mk.ukim.finki.wpvezbi.model.User;
import mk.ukim.finki.wpvezbi.model.enumeration.ShoppingCartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
Optional<ShoppingCart> findByUserAndStatus(User user, ShoppingCartStatus status);
}
