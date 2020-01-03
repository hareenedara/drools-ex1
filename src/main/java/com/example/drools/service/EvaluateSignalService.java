package com.example.drools.service;

import com.example.drools.model.ClientApp;
import com.example.drools.model.Result;
import com.example.drools.model.Signal;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EvaluateSignalService {

    @Autowired
    private KieContainer kieContainer;

    public Result evaluate(ClientApp client){
        Result result = new Result();
        long t1 = System.currentTimeMillis();
        KieSession kieSession = kieContainer.newKieSession();
        long t2 = System.currentTimeMillis();
        System.out.println("Time to create new session (ms): "+(t2-t1));
        kieSession.insert(client);
        kieSession.insert(result);
        kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println("Time Taken (ms):"+(System.currentTimeMillis() - t1));
        return result;
    }

}
