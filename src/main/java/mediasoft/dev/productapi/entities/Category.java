package mediasoft.dev.productapi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean status;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    public Category(Long id, String name, Boolean status, Date createdAt) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.createdAt = createdAt;
    }
}
