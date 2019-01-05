package com.lahtachev.applications;

import com.lahtachev.objects.Fruit;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpEL {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-SpEL.xml");
        Fruit fruit = (Fruit) context.getBean("Fruit");
    }
}