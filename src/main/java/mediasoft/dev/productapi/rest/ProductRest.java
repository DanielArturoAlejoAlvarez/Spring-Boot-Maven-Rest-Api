package mediasoft.dev.productapi.rest;

import mediasoft.dev.productapi.entities.Product;
import mediasoft.dev.productapi.repositories.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductRest {

    @Autowired
    private ProductDAO pdao;

    @GetMapping
    public ResponseEntity<List<Product>> listProduct() {
        List<Product> products = pdao.findAll();
        return ResponseEntity.ok(products);
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable(name = "id") Long id) {
        Optional<Product> optProduct = pdao.findById(id);
        if (optProduct.isPresent()) {
            return ResponseEntity.ok(optProduct.get());
        }
        return ResponseEntity.noContent().build();
    }


    //@GetMapping
    /*public String hello() {
        return "<h1>Hello World!</h1>";
    }*/
}
