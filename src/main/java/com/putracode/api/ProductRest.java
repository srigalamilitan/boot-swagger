package com.putracode.api;

import com.putracode.domain.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by krisna putra on 10/28/2017.
 */
@RestController
@RequestMapping("/api/product")
@Api(value = "API Product")
public class ProductRest {

    List<Product> products=new ArrayList<>();

    public ProductRest() {
        products.add(new Product("1","con","container",10L));
        products.add(new Product("2","ar","Arium",20L));
        products.add(new Product("3","idxx","Market",20l));
    }

    @ApiOperation(value = "Get All Data Product",
            responseContainer = "List",
            produces = "application/json",
            response = Product.class)
    @GetMapping("/")
    public Iterable<Product> getProduct(){
        return products;
    }
    @ApiOperation(value = "Find Product By Id",response = Product.class)
    @GetMapping("/{id}")
    public Product findByid(@PathVariable("id") String id){
        List<Product> result=products.stream().filter(product-> product.getId().equals(id)).collect(Collectors.toList());
        return result!=null && result.size()>0 ? result.get(0) : null;
    }
    @ApiOperation(value = "Insert Product",produces = "success")
    @PostMapping
    public String insert(@RequestBody Product p){
        products.add(p);
        return "success";
    }
    @ApiOperation("Update Product by Id")
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") String id, @RequestBody Product P){
        Product productEdit=null;
        for (Product data:products){
            if(data.getId().equals(id)){
                productEdit=data;
                break;
            }
        }
        if(productEdit!=null){
            productEdit.setCode(P.getCode());
            productEdit.setName(P.getName());
            productEdit.setStock(P.getStock());
        }

        return productEdit;
    }
    @ApiOperation("Patch Product Name by Api")
    @PatchMapping("/{id}/{name}")
    public Product patch(@PathVariable("id") String id, @PathVariable("name") String name){
        Product productEdit=null;
        for (Product data:products){
            if(data.getId().equals(id)){
                productEdit=data;
                break;
            }
        }
        if(productEdit!=null){
            productEdit.setName(name);
        }
        return productEdit;
    }
}
