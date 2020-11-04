# REST API WITH SPRING BOOT

## Description

This repository is a Software of Application with JAVA.

## Installation

Using Spring Boot, JPA,etc preferably.

## Software and Automatization

Apply Maven 2.4.0 and Swagger API

## Tools

Java version JDK-11

## IDE

IntelliJ IDEA

## Database

Using H2Databse, MySQL,etc

## Client Rest

Postman, Insomnia, Talend API Tester,etc

## Usage

```html
$ git clone https://github.com/DanielArturoAlejoAlvarez/Spring-Boot-Maven-Rest-Api.git
[NAME APP]

```

Follow the following steps and you're good to go! Important:

![alt text](https://www.pragma.com.co/hs-fs/hubfs/academia/Lecciones/Spring/Spring7.gif?width=600&name=Spring7.gif)
## Coding

### Config
```java
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("mediasoft.dev.productapi.rest"))
                .paths(PathSelectors.any())
                .build();
    }
}
```

### Database 
```java
server.port=8081
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/product_api?serverTimezone=UTC
spring.jpa.hibernate.ddl-auto=update
```

### Controllers
```java
@RequestMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable(name = "id") Long id) {
        Optional<Product> opt = pdao.findById(id);
        if (!opt.isPresent()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(opt.get());
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProd = pdao.save(product);
        return ResponseEntity.ok(newProd);
    }
```

### Models
```java
@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String code;
    private String name;
    private String description;
    private Double price;
    private Double stock;
    @Column(length = 512)
    private String image;
    private String status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Category category;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = new Date();
    }
}
```

### Services
```java
@Repository
public interface ProductDAO extends JpaRepository<Product,Long> {}

```

## Contributing

Bug reports and pull requests are welcome on GitHub at https://github.com/DanielArturoAlejoAlvarez/Spring-Boot-Maven-Rest-Api. This project is intended to be a safe, welcoming space for collaboration, and contributors are expected to adhere to the [Contributor Covenant](http://contributor-covenant.org) code of conduct.

## License

The gem is available as open source under the terms of the [MIT License](http://opensource.org/licenses/MIT).
````