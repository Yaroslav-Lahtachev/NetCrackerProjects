package com.lahtachev.applications;

import com.lahtachev.objects.Collection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCollectionCI {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-collection-CI.xml");
        Collection collection = (Collection) context.getBean("Collection");
    }
}
