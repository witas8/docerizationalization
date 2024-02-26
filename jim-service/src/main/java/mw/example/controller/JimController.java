package mw.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/jim")
@RequiredArgsConstructor
public class JimController {
    private final WebClient.Builder webClientBuilder;

    @GetMapping("/drink/question")
    public ResponseEntity<String> ask(){

        String response = webClientBuilder.build().get()
                .uri("http://beam/beam/drink/answer")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/drink/answer")
    public ResponseEntity<String> answer(){
        return ResponseEntity.ok("Jim really wants to drink alcohol!");
    }

}
