package com.nikoladichev.findich.api;

import com.nikoladichev.findich.api.config.ObjectMapperConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({/* TODO [SWAGGER] OpenApiConfig.class, */ObjectMapperConfig.class})
public class FindichApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(FindichApiApplication.class, args);
  }
}
