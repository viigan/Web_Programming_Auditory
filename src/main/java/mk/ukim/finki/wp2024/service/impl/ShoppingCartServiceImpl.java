//package mk.ukim.finki.wp2024.service.impl;
//
//import mk.ukim.finki.wp2024.model.Product;
////import mk.ukim.finki.wp2024.model.ShoppingCart;
//import mk.ukim.finki.wp2024.model.User;
//import mk.ukim.finki.wp2024.model.enumerations.ShoppingCartStatus;
//import mk.ukim.finki.wp2024.model.exceptions.ProductAlreadyInShoppingCartException;
//import mk.ukim.finki.wp2024.model.exceptions.ProductNotFoundException;
//import mk.ukim.finki.wp2024.model.exceptions.ShoppingCartNotFoundException;
//import mk.ukim.finki.wp2024.model.exceptions.UserNotFoundException;
//import mk.ukim.finki.wp2024.repository.jpa.ShoppingCartRepository;
//import mk.ukim.finki.wp2024.repository.jpa.UserRepository;
//import mk.ukim.finki.wp2024.service.ProductService;
//import mk.ukim.finki.wp2024.service.ShoppingCartService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class ShoppingCartServiceImpl implements ShoppingCartService {
//
//    private final ShoppingCartRepository shoppingCartRepository;
//    private final UserRepository userRepository;
//    private final ProductService productService;
//
//    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
//                                   UserRepository userRepository,
//                                   ProductService productService) {
//        this.shoppingCartRepository = shoppingCartRepository;
//        this.userRepository = userRepository;
//        this.productService = productService;
//    }
//
//    @Override
//    public List<Product> listAllProductsInShoppingCart(Long cartId) {
//        if (this.shoppingCartRepository.findById(cartId).isEmpty())
//            throw new ShoppingCartNotFoundException(cartId);
//        return this.shoppingCartRepository.findById(cartId).get().getProducts();
//    }
//
//    @Override
//    public ShoppingCart getActiveShoppingCart(String username) {
//        return this.shoppingCartRepository
//                .findByUserUsernameAndStatus(username, ShoppingCartStatus.CREATED)
//                .orElseGet(() -> {
//                    User user = this.userRepository.findByUsername(username)
//                            .orElseThrow(() -> new UserNotFoundException(username));
//                    ShoppingCart shoppingCart = new ShoppingCart(user);
//                    return this.shoppingCartRepository.save(shoppingCart);
//                });
//    }
//
//    @Override
//    public ShoppingCart addProductToShoppingCart(String username, Long productId) {
//        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
//        Product product = this.productService.findById(productId)
//                .orElseThrow(() -> new ProductNotFoundException(productId));
//        if (shoppingCart.getProducts()
//                .stream().filter(i -> i.getId().equals(productId))
//                .collect(Collectors.toList()).size() > 0)
//            throw new ProductAlreadyInShoppingCartException(productId, username);
//        shoppingCart.getProducts().add(product);
//        return this.shoppingCartRepository.save(shoppingCart);
//    }
//}
//
package mk.ukim.finki.wp2024.service.impl;

import mk.ukim.finki.wp2024.model.Product;
//import mk.ukim.finki.wp2024.model.ShoppingCart;
import mk.ukim.finki.wp2024.model.ShoppingCart;

import mk.ukim.finki.wp2024.model.User;
import mk.ukim.finki.wp2024.model.enumerations.ShoppingCartStatus;
import mk.ukim.finki.wp2024.model.exceptions.ProductAlreadyInShoppingCartException;
import mk.ukim.finki.wp2024.model.exceptions.ProductNotFoundException;
import mk.ukim.finki.wp2024.model.exceptions.ShopingCartNotFoundException;
import mk.ukim.finki.wp2024.model.exceptions.UserNotFoundException;
import mk.ukim.finki.wp2024.repository.inmemory.InMemoryProductRepository;
import mk.ukim.finki.wp2024.repository.inmemory.InMemoryShoppingCartRepository;
import mk.ukim.finki.wp2024.repository.inmemory.InMemoryUserRepository;
import mk.ukim.finki.wp2024.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
   private  final InMemoryUserRepository inMemoryUserRepository;
   private  final InMemoryProductRepository inMemoryProductRepository;
   private final InMemoryShoppingCartRepository inMemoryShoppingCartRepository;

    public ShoppingCartServiceImpl(InMemoryUserRepository inMemoryUserRepository, InMemoryProductRepository inMemoryProductRepository, InMemoryShoppingCartRepository inMemoryShoppingCartRepository) {
        this.inMemoryUserRepository = inMemoryUserRepository;
        this.inMemoryProductRepository = inMemoryProductRepository;
        this.inMemoryShoppingCartRepository = inMemoryShoppingCartRepository;
    }

    @Override
    public List<Product> listAllProductsInShoppingCart(Long cartId) {
        if(this.inMemoryShoppingCartRepository.findById(cartId).isEmpty()){
            throw new ShopingCartNotFoundException(cartId);
        }
        return this.inMemoryShoppingCartRepository.findById(cartId).get().getProducts();

    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
        return this.inMemoryShoppingCartRepository.findByUserNameAndStatus(username, ShoppingCartStatus.CREATED)
                .orElseGet(()->{
                    User user=this.inMemoryUserRepository.findByUsername(username).orElseThrow(() ->new UserNotFoundException(username));
                    ShoppingCart shoppingCart = new ShoppingCart(user);
                    return this.inMemoryShoppingCartRepository.save(shoppingCart);
                });
    }

    @Override
    public ShoppingCart addProductToShoppingCart(String username, Long productId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
        Product product= this.inMemoryProductRepository.findById(productId).orElseThrow(()->new ProductNotFoundException(productId));

        if(!shoppingCart.getProducts().stream().filter(p -> p.getId().equals(productId)).toList().isEmpty()){
            throw new ProductAlreadyInShoppingCartException(productId,username);
        }
        shoppingCart.getProducts().add(product);
        return this.inMemoryShoppingCartRepository.save(shoppingCart);

    }
}