package com.example.onetomany_annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OnetomanyAnnotationApplication {

  public static void main(String[] args) {
    SpringApplication.run( OnetomanyAnnotationApplication.class, args );
  }
}
