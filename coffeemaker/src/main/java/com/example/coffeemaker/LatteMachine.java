package com.example.coffeemaker;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LatteMachine implements CoffeeMachine {

    public LatteMachine() {
        System.out.println("LatteMachine: Constructor called (Prototype)");
    }

    @Override
    public void brew() {
        System.out.println("Brewing a latte...");
    }
}
