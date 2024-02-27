package mw.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mw.example.feign.client.beam.BeamOpenFeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import mw.example.feign.client.beam.BeamOpenFeignResponse;

@Slf4j
@RestController
@RequestMapping("/jim")
@RequiredArgsConstructor
public class JimController {
    private final WebClient.Builder webClientBuilder;
    private final BeamOpenFeignClient beamOpenFeignClient;

    @GetMapping("/drink/question")
    public ResponseEntity<String> ask(){

        BeamOpenFeignResponse beamOpenFeignResponse = beamOpenFeignClient.checkIfBeamIsReady();
        if (beamOpenFeignResponse.isBeamReady()){
            log.info("Beam is ready");
        } else{
            log.info("Beam is NOT ready");
        }

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
