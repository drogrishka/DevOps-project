package mk.ukim.finki.wpvezbi.service;


import mk.ukim.finki.wpvezbi.model.Product;
import mk.ukim.finki.wpvezbi.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    List<Product> listAllProductsInShoppingCart(Long cartId);
    ShoppingCart getActiveShoppingCart(String username);
    ShoppingCart addProductToShoppingCart(String username,Long productId);

}
