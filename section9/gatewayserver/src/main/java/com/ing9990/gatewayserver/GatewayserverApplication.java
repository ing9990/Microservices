package com.ing9990.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayserverApplication.class, args);
    }

    @Bean
    public RouteLocator eazyBankRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        final String google = "https://google.com";
        final String googleSearchQuery = "/search?q=";

        return routeLocatorBuilder.routes()
            .route(p -> p
                .path("/eazybank/accounts/**")
                .filters(f -> f.rewritePath("/eazybank/accounts/(?<segment>.*)", "/${segment}"))
                .uri("lb://ACCOUNTS"))
            .route(p -> p
                .path("/eazybank/loans/**")
                .filters(f -> f.rewritePath("/eazybank/loans/(?<segment>.*)", "/${segment}"))
                .uri("lb://LOANS"))
            .route(p -> p
                .path("/eazybank/cards/**")
                .filters(f -> f.rewritePath("/eazybank/cards/(?<segment>.*)", "/${segment}"))
                .uri("lb://CARDS"))

            // 구글로 검색 결과로 라우트 하도록 테스트
            .route(p -> p
                .path("/goto/google/**")
                .filters(f -> f.rewritePath("/goto/google/(?<segment>.*)", googleSearchQuery + "${segment}"))
                .uri(google))
            .build();
    }

}
