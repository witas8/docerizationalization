package mw.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BeamApplication {
    public static void main(String[] args) {
        SpringApplication.run(BeamApplication.class, args);
    }

}