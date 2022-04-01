package gatewayserver.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Gateway
{
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route("user-service", rt -> rt.path("/api/v1/users/**")
                        .uri("http://host.docker.internal:3005/"))
                .route("post-service", rt -> rt.path("/api/v1/posts/**")
                        .uri("http://host.docker.internal:3010/"))
                .route("http://comment-service", rt -> rt.path("/posts/**")
                        .uri("http://host.docker.internal:3015/"))
                .route("like-service", rt -> rt.path("/api/v1/**")
                        .uri("http://host.docker.internal:3020/"))
                .build();
    }
}

