package mw.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/jim")
@RequiredArgsConstructor
public class JimController {

    private final RestTemplate restTemplate;

    @GetMapping("/drink/question")
    public ResponseEntity<String> ask(){

        ResponseEntity<String> response = restTemplate.exchange(
//                "http://localhost:8082/beam/drink/answer",
                "http://beam:8082/beam/drink/answer",
//                "http://beam/beam/drink/answer",
                HttpMethod.GET,
                null,
                String.class
        );

        return ResponseEntity.ok(response.getBody());
    }

    @GetMapping("/drink/answer")
    public ResponseEntity<String> answer(){
        return ResponseEntity.ok("Jim really wants to drink alcohol!");
    }

}
