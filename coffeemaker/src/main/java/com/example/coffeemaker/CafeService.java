package com.example.coffeemaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class CafeService {

    private final CoffeeMachine coffeeMachine;

    @Autowired
    public CafeService(@Qualifier("espressoMachine") CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
        System.out.println("CafeService: Constructor called");
    }

    public void serveCoffee() {
        coffeeMachine.brew();
    }

    @PostConstruct
    public void init() {
        System.out.println("CafeService: PostConstruct called");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("CafeService: PreDestroy called");
    }
}

