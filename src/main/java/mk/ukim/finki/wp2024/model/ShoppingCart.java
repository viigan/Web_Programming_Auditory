//package mk.ukim.finki.wp2024.model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import mk.ukim.finki.wp2024.model.enumerations.ShoppingCartStatus;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Data
//@Entity
//@NoArgsConstructor
//public class ShoppingCart {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private LocalDateTime dateCreated;
//
//    @ManyToOne
//    private User user;
//
//    @ManyToMany
//    private List<Product> products;
//
//    @Enumerated(EnumType.STRING)
//    private ShoppingCartStatus status;
//
//    public ShoppingCart(User user) {
//        this.dateCreated = LocalDateTime.now();
//        this.user = user;
//        this.products = new ArrayList<>();
//        this.status = ShoppingCartStatus.CREATED;
//    }
//}
//
package mk.ukim.finki.wp2024.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.wp2024.model.enumerations.ShoppingCartStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ShoppingCart {
    private Long Id;
    private LocalDateTime dateCreated;
    private User user;
    private List<Product> products;
    private ShoppingCartStatus status;

    public ShoppingCart(){
        this.Id= (long) (Math.random()*1000);
    }

    public ShoppingCart( User user) {
        this.dateCreated = LocalDateTime.now();
        this.Id= (long) (Math.random()*1000);

        this.user = user;
        this.products = new ArrayList<>();
        this.status = ShoppingCartStatus.CREATED;
    }
}
