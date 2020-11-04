package mediasoft.dev.productapi.entities;

import lombok.*;

import javax.persistence.*;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}