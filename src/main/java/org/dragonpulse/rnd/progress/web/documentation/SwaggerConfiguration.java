package org.dragonpulse.rnd.progress.web.documentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.Arrays;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Configuration for Swagger API.
     *
     * @return
     */
    @Bean(name="swaggerApi")
    public Docket scrabbleApi(@Qualifier("metaData") ApiInfo apiInfo) {
        logger.info("Entering into Config ::");
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.dragonpulse.rnd.progress"))
                .paths(regex("/.*"))
                .build()
                .directModelSubstitute(LocalDate.class, String.class)
                .apiInfo(apiInfo);
    }

    /**
     * Meta Data defination which will be displayed in Swagger API
     *
     * @return
     */

    @Bean("metaData")
    public ApiInfo metaData(@Qualifier("contact")Contact contact) {
        logger.info("Entering into MetaData ::");
        StringVendorExtension[] vendorExtension = {new StringVendorExtension("Apache License","https://www.apache.org/licenses/LICENSE-2.0")};
        ApiInfo apiInfo = new ApiInfo(
                "API Service for Person Saving Status",
                "API Service for Person Saving Status ",
                "1.0",
                "Terms of service",
                 contact,
                "Vijay- aitvijay@gmail.com",
                "",
                Arrays.asList(vendorExtension)
        );
        return apiInfo;
    }


    @Bean("contact")
    public Contact contact(){
        return new Contact("Vijay Satyanarayana","aitvijay@gmail.com","aitvijay@gmail.com");
    }



}
