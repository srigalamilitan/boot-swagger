package com.putracode.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by krisna putra on 10/28/2017.
 */
@Data
@AllArgsConstructor
@ApiModel(value = "Product Model For display and Saving Data Product")
public class Product {
    private String id;
    @ApiModelProperty(notes = "Code Product",
            required = true,
            allowEmptyValue = false,
            dataType = "String"
            )
    private String code;
    private String name;
    private Long stock;

}
