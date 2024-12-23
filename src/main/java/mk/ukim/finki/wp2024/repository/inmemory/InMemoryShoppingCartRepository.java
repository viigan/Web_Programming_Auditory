//package mk.ukim.finki.wp2024.repository.inmemory;
//
//import mk.ukim.finki.wp2024.bootstrap.DataHolder;
//import mk.ukim.finki.wp2024.model.ShoppingCart;
//import mk.ukim.finki.wp2024.model.enumerations.ShoppingCartStatus;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public class InMemoryShoppingCartRepository {
//
//    public Optional<ShoppingCart> findById(Long id) {
//        return DataHolder.shoppingCarts.stream().filter(i -> i.getId().equals(id)).findFirst();
//    }
//
//    public Optional<ShoppingCart> findByUsernameAndStatus(String username, ShoppingCartStatus status) {
//        return DataHolder.shoppingCarts.stream().filter(i -> i.getUser().getUsername().equals(username) && i.getStatus().equals(status)).findFirst();
//    }
//
//    public ShoppingCart save(ShoppingCart shoppingCart) {
//        DataHolder.shoppingCarts.removeIf(i -> i.getUser().getUsername().equals(shoppingCart.getUser().getUsername()));
//        DataHolder.shoppingCarts.add(shoppingCart);
//        return shoppingCart;
//    }
//}
package mk.ukim.finki.wp2024.repository.inmemory;

import mk.ukim.finki.wp2024.bootstrap.DataHolder;
import mk.ukim.finki.wp2024.model.ShoppingCart;
import mk.ukim.finki.wp2024.model.User;
import mk.ukim.finki.wp2024.model.enumerations.ShoppingCartStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InMemoryShoppingCartRepository  {
    public Optional<ShoppingCart>findById(Long id){
        return DataHolder.shoppingCarts.stream().filter(i->i.getId().equals(id)).findFirst();

    }

    public Optional<ShoppingCart>findByUserNameAndStatus(String username,ShoppingCartStatus status){
        return DataHolder.shoppingCarts.stream().filter(i->i.getUser().getUsername().equals(username) && i.getStatus().equals(status)).findFirst();

    }

    public ShoppingCart save(ShoppingCart shoppingCart){
         DataHolder.shoppingCarts.removeIf(i->i.getUser().getUsername().equals(shoppingCart.getUser().getUsername()));
     DataHolder.shoppingCarts.add(shoppingCart);
     return shoppingCart;
    }

}