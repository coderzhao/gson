package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GeneralConfig {

    @Value("${sdk.host_ip}")
    private String host_ip;
    @Value("${sdk.port}")
    private short sdk_port;
    @Value("${sdk.token}")
    private String token;
    @Value("${sdk.version}")
    private String sdk_version;

    public String getHost_ip() {
        return host_ip;
    }

    public short getSdk_port() {
        return sdk_port;
    }

    public String getToken() {
        return token;
    }

    public String getSdk_version() {
        return sdk_version;
    }
}
