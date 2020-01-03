package com.example.drools.controller;

import com.example.drools.model.ClientApp;
import com.example.drools.model.Result;
import com.example.drools.model.Signal;
import com.example.drools.service.EvaluateSignalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/challenge")
public class Controller {

    @Autowired
    private EvaluateSignalService service;

    @GetMapping()
    public Result challenge(){
        ClientApp clientApp = new ClientApp();
        Signal signal = new Signal();
        signal.setSigA("1");
        signal.setSigB("2");
        signal.setSigC("4");
        clientApp.setSignal(signal);
        return service.evaluate(clientApp);
    }
}
