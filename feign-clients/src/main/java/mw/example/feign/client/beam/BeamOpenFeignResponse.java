package mw.example.feign.client.beam;

import lombok.Builder;

@Builder
public record BeamOpenFeignResponse(Boolean isBeamReady) {}
