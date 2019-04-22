package com.khermstad.gcppubsubpublisherclient.gateway;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

@Component
@MessagingGateway(defaultRequestChannel = "pubsubOutputChannel")
public interface PubsubOutboundGateway {

    void sendToPubsub(String text);
}