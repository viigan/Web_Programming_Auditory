package mk.ukim.finki.wp2024.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 4000)
    private String description;

    public Category(String name, String description) {
        this.id= (long) (Math.random()*1000);
        this.name = name;
        this.description = description;
    }
}
