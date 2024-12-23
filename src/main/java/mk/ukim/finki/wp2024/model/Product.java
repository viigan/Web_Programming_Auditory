//package mk.ukim.finki.wp2024.model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@Entity
//@NoArgsConstructor
//public class Product {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//
//    private Double price;
//
//    private Integer quantity;
//
//    @ManyToOne
//    private Category category;
//
//    @ManyToOne
//    private Manufacturer manufacturer;
//
//    public Product(
//            String name,
//            Double price,
//            Integer quantity,
//            Category category,
//            Manufacturer manufacturer
//    ) {
//        this.name = name;
//        this.price = price;
//        this.quantity = quantity;
//        this.category = category;
//        this.manufacturer = manufacturer;
//    }
//}
//

package mk.ukim.finki.wp2024.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Locale;

@AllArgsConstructor
@Data
@Entity
public  class Product {
    @Id
    private  Long id;
    private String name;
    private Double price;
//    private List<Product> productList;
    private  Integer quantity;

    @ManyToOne
    private Category category;

    @ManyToOne
    private  Manufacturer manufacturer;

    public Product(){
        this.id= (long) (Math.random()*1000);

    }
    public Product(String name, Double price, Integer quantity, Category category, Manufacturer manufacturer) {
        this.id= (long) (Math.random()*1000);
        this.name = name;
        this.price=price;
//        this.productList = productList;
        this.quantity = quantity;
        this.category = category;
        this.manufacturer = manufacturer;
    }
}

