package com.khermstad.gcppubsubpublisherclient.controller;


import com.khermstad.gcppubsubpublisherclient.gateway.PubsubOutboundGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishController {

    private PubsubOutboundGateway pubsubOutboundGateway;

    public PublishController(PubsubOutboundGateway pubsubOutboundGateway){
        this.pubsubOutboundGateway = pubsubOutboundGateway;
    }

    @PostMapping("/publish")
    public void publishPayload(String payload){
        pubsubOutboundGateway.sendToPubsub(payload);
    }


}
