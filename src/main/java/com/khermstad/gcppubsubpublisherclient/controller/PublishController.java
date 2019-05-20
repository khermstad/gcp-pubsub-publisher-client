package com.khermstad.gcppubsubpublisherclient.controller;


import com.khermstad.gcppubsubpublisherclient.gateway.PubsubOutboundGateway;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PublishController {

    private PubSubTemplate pubSubTemplate;

    public PublishController(PubSubTemplate pubSubTemplate){
        this.pubSubTemplate = pubSubTemplate;
    }

    @PostMapping("/publish")
    public void publishPayload(
            @RequestBody String payload, 
            String traceId, 
            String entity,
            String dcNumber, 
            String contractVersion, 
            String schemaUrl, 
            String eventType,
            String eventTimestamp, 
            String createdTime) {
        
        Map<String, String> headers = new HashMap<>();
        
        headers.put("traceId", traceId);
        headers.put("dcNumber", dcNumber);
        headers.put("contractVersion", contractVersion);
        headers.put("schemaUrl", schemaUrl);
        headers.put("eventType", eventType);
        headers.put("eventTimestamp", eventTimestamp);
        headers.put("createdTime", createdTime);
        headers.put("entity", entity);
        
        ListenableFuture future = pubSubTemplate.publish("topic1", payload, headers);
        System.out.println(future);
    }


}
