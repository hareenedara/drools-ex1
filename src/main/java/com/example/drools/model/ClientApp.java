package com.example.drools.model;

import lombok.Data;

@Data
public class ClientApp {
    private String appVersion;
    private String osVersion;
    private String osName;
    private Signal signal;
}
