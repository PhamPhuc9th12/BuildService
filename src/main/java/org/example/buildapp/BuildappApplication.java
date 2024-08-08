package org.example.buildapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.example.buildapp")
public class BuildappApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuildappApplication.class, args);
    }

}
