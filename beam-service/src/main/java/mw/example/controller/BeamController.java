package mw.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import mw.example.feign.client.beam.BeamOpenFeignResponse;

@RestController
@RequestMapping("/beam")
@RequiredArgsConstructor
public class BeamController {

    //private final RestTemplate restTemplate;
    private final WebClient.Builder webClientBuilder;

    @GetMapping("/drink/question")
    public ResponseEntity<String> ask(){
        //"http://localhost:8081/jim/drink/answer",
        //"http://jim:8081/jim/drink/answer",
        String response = webClientBuilder.build().get()
                .uri("http://jim/jim/drink/answer")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/drink/answer")
    public ResponseEntity<String> answer(){
        return ResponseEntity.ok("Beam wants to drink alcohol...");
    }

    @GetMapping("/ready")
    public BeamOpenFeignResponse isBeamReady(){
        return BeamOpenFeignResponse.builder().isBeamReady(true).build();
    }
}
