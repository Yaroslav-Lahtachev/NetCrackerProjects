package com.lahtachev.applications;

import com.lahtachev.objects.Beer;
import com.lahtachev.objects.Pub;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainLookUp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-lookUp.xml");
        Pub pub = (Pub) context.getBean("Pub");

        Beer firstCup = pub.pourLightBeer();
        System.out.println("First cup: " + firstCup);

        Beer secondCup = pub.pourDarkBeer();
        System.out.println("Second cup: " + secondCup);
    }
}
