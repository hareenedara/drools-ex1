package com.example.drools.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Result {
    private String action;
    private List<String> results = new ArrayList<>();
}
