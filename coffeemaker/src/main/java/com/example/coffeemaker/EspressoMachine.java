package com.example.coffeemaker;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope("singleton")
public class EspressoMachine implements CoffeeMachine {

    public EspressoMachine() {
        System.out.println("EspressoMachine: Constructor called (Singleton)");
    }

    @Override
    public void brew() {
        System.out.println("Brewing an espresso...");
    }

    @PostConstruct
    public void init() {
        System.out.println("EspressoMachine: PostConstruct called");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("EspressoMachine: PreDestroy called");
    }
}
