package uk.co.legacy.it.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by phani16 on 06/03/2020.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOption implements Cloneable{
    private String optionId;
    private Double optionPrice;
    private Boolean isSpecialOption;
    private Integer colourCode;
}
