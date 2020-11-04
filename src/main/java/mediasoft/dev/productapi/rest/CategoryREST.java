package mediasoft.dev.productapi.rest;

import mediasoft.dev.productapi.entities.Category;
import mediasoft.dev.productapi.repositories.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryREST {

    @Autowired
    private CategoryDAO cdao;

    public ResponseEntity<List<Category>> getCategories() {
        return null;
    }
}
