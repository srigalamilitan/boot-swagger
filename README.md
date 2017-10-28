# Simple Spring-boot Swagger Documentation
Learning Swagger documentation for rest.

To Add Swagger to your application
add the depedencies

		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.7.0</version>
			<scope>compile</scope>
		</dependency>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.7.0</version>
			<scope>compile</scope>
		</dependency>
		
create SwaggerConfiguration class


    @EnableSwagger2
    @Configuration
    public class SwaggerConfig {

    @Bean
    public Docket productAPI(){
       return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.putracode"))
                .paths(PathSelectors.regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }
    private ApiInfo metaInfo(){
        return new ApiInfo(
                "Spring boot Swagger",
                "Learning Swagger For Project",
                "1.0",
                "Tearm Of Service",
                new Contact("putracode",
                        "www.putracode.com",
                        "mr.krisna.putra@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/license.html",
                new ArrayList<>()
        );
    }
    }

Add annotation swagger @ApiOperation 
on the Method endpoint.
    
    @ApiOperation(value = "Get All Data Product",
            responseContainer = "List",
            produces = "application/json",
            response = Product.class)
    @GetMapping("/")
    public Iterable<Product> getProduct(){
        return products;
    }
    
@ApiModel and @ApiModelProperty
this is used for tell consumer application
about information about the property (response/ request)
example

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
    
how to run
1. open the terminal
    <pre>mvn spring-boot:run</pre>
2. open browser 
    <pre>http:localhost:8080/swagger-ui.html
    </pre>

Result 
   
   


![alt text](http://putracode.com/wp-content/uploads/2017/10/swagger-ui.png)
