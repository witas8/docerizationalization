package mw.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "mw.example.feign.client.beam")
public class JimApplication {
    public static void main(String[] args) {
        SpringApplication.run(JimApplication.class, args);
    }

}