package com.lahtachev.applications;

import com.lahtachev.objects.Collection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCollectionSI {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-collection-SI.xml");
        Collection collection = (Collection) context.getBean("Collection");
    }
}
