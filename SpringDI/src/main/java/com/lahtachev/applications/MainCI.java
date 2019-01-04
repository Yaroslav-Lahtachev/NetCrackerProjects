package com.lahtachev.applications;

import com.lahtachev.objects.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCI {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-CI.xml");
        Car car = (Car) context.getBean("Car");
        car.getCarName();
        car.getEngine().drive();
    }
}

