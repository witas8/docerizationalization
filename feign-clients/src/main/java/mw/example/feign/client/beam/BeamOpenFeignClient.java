package mw.example.feign.client.beam;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("beam")
public interface BeamOpenFeignClient {

    @GetMapping(path = "/beam/ready")
    BeamOpenFeignResponse checkIfBeamIsReady();
}
