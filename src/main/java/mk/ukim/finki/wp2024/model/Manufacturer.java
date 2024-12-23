package mk.ukim.finki.wp2024.model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@Entity
//@NoArgsConstructor
//@Table(name = "manufacturers")
//public class Manufacturer {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//
//    @Column(name = "manufacturer_address")
//    private String address;
//
//    public Manufacturer(String name, String address) {
//        this.name = name;
//        this.address = address;
//    }
//}

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
//@Data
//@Entity
//@NoArgsConstructor
//@Table(name = "manufacturers")
//@NoArgsConstructor
@Data
@Entity
@Table(name="manufacturerss")
public class Manufacturer {
    @Id
    private Long id;
    private  String name;

    @Column(name="manufacturerer_address")
    private String description;


    public Manufacturer(String name, String description) {

            this.id= (long) (Math.random()*1000);
        this.name = name;
        this.description = description;
    }
}
