package cc.wlizhi.springbootdemo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        Contact contact = new Contact();
        contact.setName("Wlizhi");
        return new OpenAPI()
                .info(new Info()
                        .title("Springboot Demo API")
                        .version("1.0")
                        .contact(contact)
                        .description("Spring源码阅读")
                        .termsOfService("加班吃泡面~O(∩_∩)O~")
                        .license(new License().name("Apache 2.0")
                                .url(""))
                );
    }
}
