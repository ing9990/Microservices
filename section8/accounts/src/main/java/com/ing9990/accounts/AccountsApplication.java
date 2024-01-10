package com.ing9990.accounts;

import com.ing9990.accounts.dto.AccountContactInfo;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
    info = @Info(
        title = "Accounts microservice REST API Documentation",
        description = "EazyBank Accounts microservice REST API Documentation",
        version = "v1",
        contact = @Contact(
            name = "Taewoo Kim",
            email = "mail80782258@gmail.cokm",
            url = "https://www.ing9990.xyz"
        )
    ),
    externalDocs = @ExternalDocumentation(
        description =  "EazyBank Accounts microservice REST API Documentation",
        url = "https://www.ing9990.xyz"
    )
)
@EnableConfigurationProperties(value = {AccountContactInfo.class})
@EnableFeignClients
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }
}
