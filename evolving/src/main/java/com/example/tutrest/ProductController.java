package com.example.tutrest;


import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ProductController {

    private final ProductRepository repository;
    private final ProductModelAssembler assembler;


    ProductController(ProductRepository repository, ProductModelAssembler assembler) {

        this.repository = repository;
        this.assembler = assembler;

    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/products")
    CollectionModel<EntityModel<Product>> all() {

        List<EntityModel<Product>> employees = repository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(employees, linkTo(methodOn(ProductController.class).all()).withSelfRel());
    }
    // end::get-aggregate-root[]

    @PostMapping("/products")
    ResponseEntity<?> newProduct(@RequestBody Product newProduct) {

        EntityModel<Product> entityModel = assembler.toModel(repository.save(newProduct));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    // Single item

    @GetMapping("/products/{id}")
    EntityModel<Product> one(@PathVariable Long id) {

        Product product = repository.findById(id) //
                .orElseThrow(() -> new ProductNotFoundException(id));

        return EntityModel.of(product, //
                linkTo(methodOn(ProductController.class).one(id)).withSelfRel(),
                linkTo(methodOn(ProductController.class).all()).withRel("products"));

    }

    @PutMapping("/products/{id}")
    ResponseEntity<?> replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {

        Product updatedProduct = repository.findById(id) //
                .map(product -> {
                    product.setProductName(newProduct.getProductName());
                    product.setPrice(newProduct.getPrice());
                    product.setCategory(newProduct.getCategory());
                    product.setDescription(newProduct.getDescription());
                    product.setManufacturer(newProduct.getManufacturer());
                    product.setInStock(newProduct.isInStock());
                    return repository.save(product);
                }) //
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return repository.save(newProduct);
                });

        EntityModel<Product> entityModel = assembler.toModel(updatedProduct);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @DeleteMapping("/products/{id}")
    ResponseEntity<?> deleteProduct( @PathVariable Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}

