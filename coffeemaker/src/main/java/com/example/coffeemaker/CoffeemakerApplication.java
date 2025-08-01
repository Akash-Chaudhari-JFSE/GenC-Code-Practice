package com.example.coffeemaker;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CoffeemakerApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CafeService cafeService = context.getBean(CafeService.class);
        cafeService.serveCoffee();

        // To demonstrate prototype scope
        CoffeeMachine latte1 = context.getBean("latteMachine", CoffeeMachine.class);
        System.out.println(latte1);
        latte1.brew();

        CoffeeMachine latte2 = context.getBean("latteMachine", CoffeeMachine.class);
        System.out.println(latte2);
        latte2.brew();

        context.close();
    }
}
