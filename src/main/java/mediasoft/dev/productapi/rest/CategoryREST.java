package mediasoft.dev.productapi.rest;

import mediasoft.dev.productapi.entities.Category;
import mediasoft.dev.productapi.repositories.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("categories")
public class CategoryREST {

    @Autowired
    private CategoryDAO cdao;

    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = cdao.findAll();
        return ResponseEntity.ok(categories);
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable(name = "id") Long id) {
        Optional<Category> opt = cdao.findById(id);
        if (!opt.isPresent()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(opt.get());
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category newCat = cdao.save(category);
        return ResponseEntity.ok(newCat);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> removeCategory(@PathVariable(value = "id") Long id) {
        cdao.deleteById(id);
        return ResponseEntity.ok(null);
    }

    @PutMapping
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        Optional<Category> opt = cdao.findById(category.getId());
        if (!opt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Category updCat = opt.get();
        updCat.setName(category.getName());
        updCat.setStatus(category.getStatus());
        cdao.save(updCat);
        return ResponseEntity.ok(updCat);
    }

}
