package mediasoft.dev.productapi.repositories;

import mediasoft.dev.productapi.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDAO extends JpaRepository<Category,Long> {}
