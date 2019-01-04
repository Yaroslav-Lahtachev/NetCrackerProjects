package com.lahtachev.applications;

import com.lahtachev.objects.Transport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainParent {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-parent.xml");
        Transport car = (Transport) context.getBean("DefaultCar");
        Transport airplane = (Transport) context.getBean("Airplane");
    }
}