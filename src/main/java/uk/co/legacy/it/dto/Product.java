package uk.co.legacy.it.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * Created by phani16 on 06/03/2020.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product implements Cloneable{
    private String productId;
    private String description;
    private Double price;
    private List<ProductOption> options;
}
