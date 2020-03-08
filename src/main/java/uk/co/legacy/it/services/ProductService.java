package uk.co.legacy.it.services;

import org.springframework.stereotype.Service;
import uk.co.legacy.it.api.exceptions.ResourceNotFoundException;
import uk.co.legacy.it.dto.Product;
import uk.co.legacy.it.dto.ProductOption;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by phani16 on 07/03/2020.
 */
@Service
public class ProductService {

    private static Product product1 = Product.builder()
                                        .productId("1234")
                                        .description("abc product")
                                        .price(Double.valueOf("10.35"))
                                        .build();

    private static Product product2 = Product.builder()
            .productId("6789")
            .price(Double.valueOf("20.60"))
            .options(asList(ProductOption.builder().optionId("1").colourCode(10).isSpecialOption(true).build(),
                    ProductOption.builder().optionId("2").colourCode(15).optionPrice(Double.valueOf("17.75")).build()))
            .build();


    private static List<Product> products = new ArrayList<>();

    static {
        products.addAll(asList(product1,product2));
    }

    public Product getProductId(final String productId) {
        return products.stream().filter(id -> id.getProductId().equals(productId)).findAny().orElseThrow(ResourceNotFoundException::new);
    }

    public Product createProduct(final Product product) {
        products.add(product);
        return product;
    }

}
