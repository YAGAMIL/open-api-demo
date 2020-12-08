package com.jhin.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: OpenAPI开放设置 Program:open-api-demo com.jhin.config Created on 2020/12/8 10:27
 *
 * @author <a href="mailto: Tablo_Jhin1996@outlook.com">Tablo</a>
 * @version 1.0
 */
@Slf4j
@Component
@Primary
@AllArgsConstructor
public class OpenApiConfig {
  private final GatewayProperties gatewayProperties;

/*
  @Bean
  @Lazy(false)
  public List<GroupedOpenApi> apis(SwaggerUiConfigParameters swaggerUiConfigParameters) {
    List<GroupedOpenApi> groups = new ArrayList<>();
    List<String> routes = new ArrayList<>();
    gatewayProperties.getRoutes().forEach(r -> System.out.println(r.getId()));
    routes.forEach(System.out::println);
    gatewayProperties
        .getRoutes()
        //                .filter(routeDefinition ->
        // routes.contains(routeDefinition.getId()))
        .forEach(
            routeDefinition ->
                routeDefinition.getPredicates().stream()
                    .filter(
                        predicateDefinition ->
                            ("Path").equalsIgnoreCase(predicateDefinition.getName()))
                    .forEach(
                        predicateDefinition -> {
                          swaggerUiConfigParameters.addGroup(routeDefinition.getId());
                          GroupedOpenApi.builder()
                              .pathsToMatch("/" + routeDefinition.getId() + "/**")
                              .group(routeDefinition.getId())
                              .build();
                        }));
    swaggerUiConfigParameters.addGroup("gateway");
    GroupedOpenApi.builder()
        .group("gateway")
        .packagesToScan("com.matcloud.gateway.controllers")
        .build();
    return groups;
  }
*/

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .components(new Components())
        .info(
            new Info()
                .title("Gateway API")
                .version("3.0")
                .license(new License().name("Apache 2.0").url("http://springdoc.org")));
  }
}
