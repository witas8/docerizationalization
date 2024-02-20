package mw.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/beam")
@RequiredArgsConstructor
public class BeamController {

    private final RestTemplate restTemplate;

    @GetMapping("/drink/question")
    public ResponseEntity<String> ask(){

        ResponseEntity<String> response = restTemplate.exchange(
                "http://192.168.88.199:8081/jim/drink/answer",
                HttpMethod.GET,
                null,
                String.class
        );

        return ResponseEntity.ok(response.getBody());
    }

    @GetMapping("/drink/answer")
    public ResponseEntity<String> answer(){
        return ResponseEntity.ok("Beam wants to drink alcohol...");
    }

}
