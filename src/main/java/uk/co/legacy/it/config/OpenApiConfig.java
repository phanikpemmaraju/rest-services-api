package uk.co.legacy.it.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by phani16 on 07/03/2020.
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        final License license = new License().name("Apache License Version 2.0").url("https://www.apache.org/licenses/LICENSE-2.0");
        return new OpenAPI().info(new Info()
                                    .title("Legacy IT Rest Services API")
                                    .version("1.0.0")
                                    .description("Rest APIs exposed")
                                    .license(license));
    }
}
