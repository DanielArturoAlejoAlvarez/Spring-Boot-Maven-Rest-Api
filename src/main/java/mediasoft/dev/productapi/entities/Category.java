package mediasoft.dev.productapi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "categories")
public class Category {

    private Long id;
    private String name;
    private Boolean status;
    private Date createdAt;

    public Category(Long id, String name, Boolean status, Date createdAt) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.createdAt = createdAt;
    }
}
