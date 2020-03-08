package uk.co.legacy.it.api.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uk.co.legacy.it.dto.Product;
import uk.co.legacy.it.services.ProductService;

/**
 * Created by phani16 on 07/03/2020.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/products")
public class ProductResource {

    private final ProductService productService;

    @GetMapping(value = "/{productId}")
    public Product getProductById(@PathVariable String productId) {
        return productService.getProductId(productId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Product postProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

}
