package pl.otekcode.app.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket studentsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(info()).select()
                .build();
    }

    private ApiInfo info() {
        return new ApiInfoBuilder().title("Currency API")
                .version("1.0").build();
    }

}
